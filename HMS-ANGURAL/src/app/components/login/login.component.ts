import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../service/login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  alert:boolean = false;
  message:string = '';

  credentials = {
    username: '',
    password: ''
  }

  constructor(private loginService:LoginService ) { }

  ngOnInit(): void {
  }

  closeAlert()
  {
    this.alert = false;
  }

  onSubmit()
  {
    if(this.credentials.username == '' || this.credentials.password == '')
    {
      this.alert = true;
      this.message = 'Enter the Username and Password'
    }
    else
    {
      this.loginService.GenrateToken(this.credentials).subscribe(
        (response:any) => {
          // console.log(response.accessToken);
          localStorage.setItem("token",response.accessToken);
          if(response.roles[0] == 'ROLE_ADMIN')
          {
            window.location.href="/dash";
          }
          else if(response.roles[0] == 'ROLE_USER')
          {
            window.location.href="/userdash";
          }
        },
        error=>{
          this.alert = true;
          this.message = 'No matching user found enter correct details'
        }
      )
    }
  }

}
