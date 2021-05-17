import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class UserSideService {

  baseUrlGuest = "http://localhost:9190/api/guest";
  baseUrlReservation = "http://localhost:3000/res";


  constructor(private http:HttpClient) { }

  getAllGuest()
  {
    return this.http.get(this.baseUrlGuest);
  }

  AddToGuest(data)
  {
    return this.http.post(this.baseUrlGuest, data);
  }

  getCurrentGuest(id)
  {
    return this.http.get(`${this.baseUrlGuest}/${id}`);
  }

  updateGuest(id,data)
  {
    return this.http.put(`${this.baseUrlGuest}/${id}`,data);
  }

  deleteGuest(id)
  {
    return this.http.delete(`${this.baseUrlGuest}/${id}`);
  }


  // !RESERVATION

  getAllRes()
  {
    return this.http.get(this.baseUrlReservation);
  }

  AddToRes(data)
  {
    return this.http.post(this.baseUrlReservation, data);
  }

  getCurrentRes(id)
  {
    return this.http.get(`${this.baseUrlReservation}/${id}`);
  }

  updateRes(id,data)
  {
    return this.http.put(`${this.baseUrlReservation}/${id}`,data);
  }

  deleteRes(id)
  {
    return this.http.delete(`${this.baseUrlReservation}/${id}`);
  }


}
