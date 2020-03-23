import { HttpClient } from '@angular/common/http';
import { Component, OnInit, NgZone } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { MyMessage } from './my-message';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  ping$ = new BehaviorSubject<string>('empty');

  public event$ = new BehaviorSubject<string>(null);

  eventSource: EventSource;

  constructor(
    private httpClient: HttpClient,
    private zone: NgZone) {
      this.eventSource = this.createEventSource();
    }

    private createEventSource(): EventSource {
      const eventSource = new EventSource('http://localhost:8080/api/test/stream');
      eventSource.onmessage = (sse: MessageEvent) => {
        console.log (sse.data);
        const myMessage: MyMessage = new MyMessage(JSON.parse(sse.data));
        this.zone.run(() => this.event$.next(myMessage.message));
      };
      eventSource.onerror = err => this.event$.error(err);
      return eventSource;
  }

  ngOnInit() {
    this.httpClient.get<string>('http://localhost:8080/api/test/ping', { responseType: 'text' as 'json' })
      .pipe(tap(resp => console.log(resp)))
      .subscribe(resp => this.ping$.next(resp));
  }

}
