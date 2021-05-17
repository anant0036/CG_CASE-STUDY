import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router'
import { AdminSideService } from '../../../service/admin-side.service';

@Component({
  selector: 'app-update-form',
  templateUrl: './update-form.component.html',
  styleUrls: ['./update-form.component.css']
})
export class UpdateFormComponent implements OnInit {

  constructor(private router:ActivatedRoute,private service:AdminSideService) { }

  alertSuccess:boolean = false;

  updateEmp = new FormGroup({
    name: new FormControl(''),
    email: new FormControl(''),
    address: new FormControl(''),
    salary: new FormControl(''),
    age: new FormControl('')
  })

  ngOnInit(): void {
    console.log(this.router.snapshot.params.id);
    this.service.getCurrentEmp(this.router.snapshot.params.id).subscribe((data) => {
      console.log(data);

      this.updateEmp = new FormGroup({
        name: new FormControl(data['name']),
        email: new FormControl(data['email']),
        address: new FormControl(data['address']),
        salary: new FormControl(data['salary']),
        age: new FormControl(data['age'])
      })

    })
  }

  putEmp() 
  {
    console.log("item",this.updateEmp.value);
    this.service.updateEmp(this.router.snapshot.params.id,this.updateEmp.value).subscribe((data) => {
      console.log("data",data);
    },
    (err) => {
      console.log(err);
      this.alertSuccess = true;
    });
  }

  closeAlert()
  {
    this.alertSuccess = false;
  }

}
