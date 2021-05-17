import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl = "http://localhost:8080/api/auth"

  constructor(private http:HttpClient) { }

  GenrateToken(credentials:any)
  {
    return this.http.post(`${this.baseUrl}/signin`,credentials);
  }


}
