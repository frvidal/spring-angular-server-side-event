package com.fitzhi.controller;

import java.time.Duration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.Logger;

import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/test")
/**
 * @author Fr&eacute;d&eacute;ric VIDAL Controller for Ping purpose
 */

public class PingController {

	@GetMapping("/ping")
	public ResponseEntity<String> welcome()  {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);
		return new ResponseEntity<>(
				"pong", 
				headers, 
				HttpStatus.OK);
	}

	@GetMapping(value = "/stream", produces = {MediaType.TEXT_EVENT_STREAM_VALUE} )
	public Flux<Message> event()  {
	     //simulate data streaming every 1 second.
        return Flux.interval(Duration.ofMillis(1000))
        		.map(l -> new Message(l, "Message for " + l))
        		.log();
	}
	
	
}
