import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AdminRoutingModule } from './components/admin/admin-routing.module';
import { UserRoutingModule } from './components/user/user-routing.module';
import { AdminComponent } from './components/admin/admin.component'
import { UserComponent } from './components/user/user.component'
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AdminTableComponent } from './components/admin/admin-table/admin-table.component';
import { UserTableComponent } from './components/user/user-table/user-table.component';
import { AddFormComponent } from './components/admin/add-form/add-form.component';
import { UserFormComponent } from './components/user/user-form/user-form.component';
import { UpdateFormComponent } from './components/admin/update-form/update-form.component';
import { GuestUpdateComponent } from './components/user/guest-update/guest-update.component';
import { ResTableComponent } from './components/user/res-table/res-table.component';
import { ResAddformComponent } from './components/user/res-addform/res-addform.component';
import { ResUpdateComponent } from './components/user/res-update/res-update.component';
import { BillItComponent } from './components/user/bill-it/bill-it.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent,
    UserComponent,
    AdminTableComponent,
    UserTableComponent,
    AddFormComponent,
    UserFormComponent,
    UpdateFormComponent,
    GuestUpdateComponent,
    ResTableComponent,
    ResAddformComponent,
    ResUpdateComponent,
    BillItComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AdminRoutingModule,
    UserRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
