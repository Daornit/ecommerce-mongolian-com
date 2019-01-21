import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CardModule } from 'primeng/card';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {

    news: any;
    title: String;
    constructor(private http: HttpClient) { }

    ngOnInit() {
        this.title = "Good morning!";
        // this.http.get("http://localhost:4200/api/news").subscribe(
        //     data =>{
        //         this.news = data;
        //     }
        // );
    }

}
