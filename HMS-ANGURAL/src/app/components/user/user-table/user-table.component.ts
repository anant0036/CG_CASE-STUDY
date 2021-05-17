import { Component, OnInit } from '@angular/core';
import {UserSideService} from './../../../service/user-side.service'

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {

  collection:any;

  constructor(private service:UserSideService) { }

  ngOnInit(): void {

    this.service.getAllGuest().subscribe((data) => {

      // console.log(data);
      this.collection = data;

    })

  }

  deleteGuest(item)
  {
    this.service.deleteGuest(item).subscribe((data) => {
      console.log(data);
    },
    (err) => {
      console.log("GONE......");
      this.service.getAllGuest().subscribe((data) => {
        // console.log(data);
        this.collection = data;
      })
    })
  }

}
