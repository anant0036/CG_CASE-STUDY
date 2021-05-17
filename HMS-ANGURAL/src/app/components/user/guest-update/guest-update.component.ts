import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router'
import { UserSideService } from './../../../service/user-side.service'

@Component({
  selector: 'app-guest-update',
  templateUrl: './guest-update.component.html',
  styleUrls: ['./guest-update.component.css']
})
export class GuestUpdateComponent implements OnInit {

  constructor(private router:ActivatedRoute,private service:UserSideService) { }

  alertSuccess:boolean = false;

  updateGuest = new FormGroup({
    name: new FormControl(''),
    email: new FormControl(''),
    phonenumber: new FormControl(''),
    address: new FormControl(''),
    gender: new FormControl(''),
    govId: new FormControl('')
  })



  ngOnInit(): void {

    this.service.getCurrentGuest(this.router.snapshot.params.id).subscribe((data) => {

      this.updateGuest = new FormGroup({
        name: new FormControl(data['name']),
        email: new FormControl(data['email']),
        phonenumber: new FormControl(data['phonenumber']),
        address: new FormControl(data['address']),
        gender: new FormControl(data['gender']),
        govId: new FormControl(data['govId'])
      })

    })


  }


  putGuest()
  {

    this.service.updateGuest(this.router.snapshot.params.id,this.updateGuest.value).subscribe((data) => {
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
