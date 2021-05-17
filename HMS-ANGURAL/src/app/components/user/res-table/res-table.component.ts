import { Component, OnInit } from '@angular/core';
import {UserSideService} from './../../../service/user-side.service'

@Component({
  selector: 'app-res-table',
  templateUrl: './res-table.component.html',
  styleUrls: ['./res-table.component.css']
})
export class ResTableComponent implements OnInit {

  collection:any;

  constructor(private service:UserSideService) { }

  ngOnInit(): void {

    this.service.getAllRes().subscribe((data) => {

      console.log(data);
      this.collection = data;
      

    })

  }

  deleteRes(item)
  {
    this.service.deleteRes(item).subscribe((data) => {
      console.log(data);
    },
    (err)=>{
      console.log("GONE.....");
      this.service.getAllRes().subscribe((data) => {
        this.collection = data;
      })
    })
  }

}
