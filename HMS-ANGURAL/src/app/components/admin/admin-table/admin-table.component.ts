import { Component, OnInit } from '@angular/core';
import { AdminSideService } from '../../../service/admin-side.service';

@Component({
  selector: 'app-admin-table',
  templateUrl: './admin-table.component.html',
  styleUrls: ['./admin-table.component.css']
})
export class AdminTableComponent implements OnInit {

  collection:any;

  constructor(private adminService: AdminSideService) { }

  ngOnInit(): void {
    
    // this.adminService.getAllEmp();
    this.adminService.getAllEmp().subscribe((data) => {
      // console.log(data);
      this.collection = data;
    })

  }

  deleteEmp(item)
  {
    // console.log(item);
    this.adminService.deleteEmp(item).subscribe((data) => {
      console.log(data);
      
    },
    (err) => {
      console.log("GONE......");
      this.adminService.getAllEmp().subscribe((data) => {
        // console.log(data);
        this.collection = data;
      })
    });
  }

}
