export class MyMessage {
    id: number;
    message: string;

    constructor(jsonData) {
        Object.assign(this, jsonData);
    }
}
