import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component'
import { AdminDashComponent } from './admin-dash/admin-dash.component'
import { AdminTableComponent } from './admin-table/admin-table.component'
import { AddFormComponent } from './add-form/add-form.component';
import { UpdateFormComponent } from './update-form/update-form.component';

const routes: Routes = [

    {
        path: '', component: AdminComponent,
        children:[
            {
                path: 'dash', component: AdminDashComponent
            },
            {
                path: 'table', component: AdminTableComponent
            },
            {
                path: 'addForm', component: AddFormComponent
            },
            {
                path: 'updateForm/:id', component: UpdateFormComponent
            }
        ]
    }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: [AdminDashComponent]
})
export class AdminRoutingModule { }
