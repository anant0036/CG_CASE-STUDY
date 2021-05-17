import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router'
import { UserSideService } from './../../../service/user-side.service'

@Component({
  selector: 'app-res-update',
  templateUrl: './res-update.component.html',
  styleUrls: ['./res-update.component.css']
})
export class ResUpdateComponent implements OnInit {

  constructor(private router: ActivatedRoute, private service: UserSideService) { }


  alertSuccess: boolean = false;

  updateRes = new FormGroup({
    name: new FormControl(''),
    noChild: new FormControl(''),
    noAdult: new FormControl(''),
    noNight: new FormControl(''),
    checkIn: new FormControl(''),
    CheckOut: new FormControl('')
  })

  ngOnInit(): void {

    this.service.getCurrentRes(this.router.snapshot.params.id).subscribe((data) => {
      this.updateRes = new FormGroup({
        name: new FormControl(data['name']),
        noChild: new FormControl(data['noChild']),
        noAdult: new FormControl(data['noAdult']),
        noNight: new FormControl(data['noNight']),
        checkIn: new FormControl(data['checkIn']),
        CheckOut: new FormControl(data['CheckOut'])
      })
    })

  }

  putRes()
  {
    this.service.updateRes(this.router.snapshot.params.id,this.updateRes.value).subscribe((data) => {
      console.log("data",data);
      this.alertSuccess = true;
    },
    (err) => {
      console.log(err);
      this.alertSuccess = true;
    })
  }

  closeAlert()
  {
    this.alertSuccess = false;
  }

}
