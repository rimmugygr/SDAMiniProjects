import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {ReactiveFormsModule} from '@angular/forms';
import {NgxMaskModule} from 'ngx-mask';



@NgModule({
  declarations: [],
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
  ]

})
export class SharedModule { }
