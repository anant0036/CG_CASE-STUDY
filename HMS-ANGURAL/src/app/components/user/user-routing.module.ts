import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user.component';
import { ResDashComponent } from './res-dash/res-dash.component';
import {UserTableComponent} from './user-table/user-table.component'
import { UserFormComponent } from './user-form/user-form.component'
import { GuestUpdateComponent } from './guest-update/guest-update.component'
import { ResTableComponent } from './res-table/res-table.component'
import {ResAddformComponent} from './res-addform/res-addform.component'
import {ResUpdateComponent} from './res-update/res-update.component'
import {BillItComponent} from './bill-it/bill-it.component'

const routes: Routes = [
    {
        path: '', component: UserComponent,
        children:[
            {
                path: 'userdash', component: ResDashComponent
            },
            {
                path: 'usertable', component: UserTableComponent
            },
            {
                path: 'userform', component: UserFormComponent
            },
            {
                path: 'guestupdate/:id', component: GuestUpdateComponent
            },
            {
                path: 'restable', component: ResTableComponent 
            },
            {
                path: 'newResform', component: ResAddformComponent
            },
            {
                path: 'resUpdate/:id', component: ResUpdateComponent
            },
            {
                path: 'billit', component: BillItComponent
            }
        ]
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: [ResDashComponent]
})
export class UserRoutingModule { }
