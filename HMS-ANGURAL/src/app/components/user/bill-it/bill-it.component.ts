import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-bill-it',
  templateUrl: './bill-it.component.html',
  styleUrls: ['./bill-it.component.css']
})
export class BillItComponent implements OnInit {

  yep: any;
  payable:any;
  b:any;
  c:any;
  tax:any;
  constructor() { }

  bill = new FormGroup({
    noNight: new FormControl(''),
    price: new FormControl(''),
    exprice: new FormControl('')
  })

  ngOnInit(): void {
  }

  calBill() {
    this.yep = this.bill.value;
    let a = this.yep.exprice
    this.b = this.yep.noNight
    this.c = this.yep.price

    let money = this.b*this.c;
    let fullmoney = money + a;

    this.tax = (18 * fullmoney)/100

    this.payable = fullmoney + this.tax;

    console.log(this.payable);

  }

}
