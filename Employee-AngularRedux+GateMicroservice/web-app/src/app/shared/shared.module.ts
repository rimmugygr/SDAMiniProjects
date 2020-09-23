import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {ReactiveFormsModule} from '@angular/forms';
import {NgxMaskModule} from 'ngx-mask';
import { InputTextFormComponent } from './component/input-text-form/input-text-form.component';
import { SelectFormComponent } from './component/select-form/select-form.component';



@NgModule({
  declarations: [InputTextFormComponent, SelectFormComponent],
  imports: [
    CommonModule,
    FontAwesomeModule,
    ReactiveFormsModule,
    NgxMaskModule,
  ],
  exports: [
    FontAwesomeModule,
    ReactiveFormsModule,
    NgxMaskModule,
    CommonModule,
    InputTextFormComponent,
    SelectFormComponent,
  ]

})
export class SharedModule { }
