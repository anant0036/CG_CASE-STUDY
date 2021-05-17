import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})
export class AdminSideService {

  baseUrl = "http://localhost:9190/api/emp";

  constructor(private http: HttpClient) { }

  getAllEmp() {
    return this.http.get(this.baseUrl)
  }

  AddToEmp(data) {

    return this.http.post(this.baseUrl, data);

  }

  getCurrentEmp(id)
  {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  updateEmp(id,data)
  {
    return this.http.put(`${this.baseUrl}/${id}`,data);
  }

  deleteEmp(id)
  {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

}
