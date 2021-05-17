import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl } from '@angular/forms'
import {AdminSideService} from '../../../service/admin-side.service';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent implements OnInit {

  constructor(private adminService:AdminSideService) { }

  alertSuccess:boolean = false;
  alertDanger:boolean = false;

  addEmp = new FormGroup({
    name: new FormControl(''),
    email: new FormControl(''),
    address: new FormControl(''),
    salary: new FormControl(''),
    age: new FormControl('')
  })


  ngOnInit(): void {
  }


  collectEmp()
  {
    this.adminService.AddToEmp(this.addEmp.value).subscribe((data) => {
      console.log(data);
      this.alertSuccess = true;
      
    },
    (err) => {
      console.log(err);
      this.alertDanger = true;
    });

    this.addEmp.reset({});
  }


  closeAlert()
  {
    this.alertDanger = false;
    this.alertSuccess = false;
  }


}
