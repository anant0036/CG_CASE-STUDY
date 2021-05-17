import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl } from '@angular/forms';
import { UserSideService } from './../../../service/user-side.service'

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  constructor(private service:UserSideService) { }

  alertSuccess:boolean = false;
  alertDanger:boolean = false;

  addGuest = new FormGroup({
    name: new FormControl(''),
    email: new FormControl(''),
    phonenumber: new FormControl(''),
    address: new FormControl(''),
    gender: new FormControl(''),
    govId: new FormControl('')
  })

  ngOnInit(): void {
  }


  collectGuest()
  {
    // console.log(this.addGuest.value);
    this.service.AddToGuest(this.addGuest.value).subscribe((data) => {

      console.log(data);
      this.alertSuccess = true;

    },
    (err) =>{
      this.alertDanger = true;
    });

    this.addGuest.reset({});
  }



  closeAlert()
  {
    this.alertDanger = false;
    this.alertSuccess = false;
  }

}
