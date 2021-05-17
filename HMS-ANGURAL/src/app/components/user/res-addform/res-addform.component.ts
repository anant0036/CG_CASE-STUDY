import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { UserSideService } from './../../../service/user-side.service'
import { DatePipe } from '@angular/common'

@Component({
  selector: 'app-res-addform',
  templateUrl: './res-addform.component.html',
  styleUrls: ['./res-addform.component.css']
})
export class ResAddformComponent implements OnInit {

  constructor(private service: UserSideService) { }

  alertSuccess: boolean = false;
  alertDanger: boolean = false;

  yep: any = new Date()
  // inputDate:any = this.datepipe.transform(this.date, 'dd-MM-yyyy');

  addReser = new FormGroup({
    name: new FormControl(''),
    noChild: new FormControl(''),
    noAdult: new FormControl(''),
    noNight: new FormControl(''),
    checkIn: new FormControl(''),
    CheckOut: new FormControl('')


  })

  ngOnInit(): void {
  }


  collectRes() {
    // console.log(this.addReser.value);
    this.service.AddToRes(this.addReser.value).subscribe((data) => {
      console.log(data);
      this.alertSuccess = true;
    },
      (err) => {
        this.alertDanger = true;
      });

    this.addReser.reset({});
  }

  closeAlert()
  {
    this.alertDanger = false;
    this.alertSuccess = false;
  }

}
