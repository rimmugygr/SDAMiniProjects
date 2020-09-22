import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {ReactiveFormsModule} from '@angular/forms';
import {NgxMaskModule} from 'ngx-mask';
import { InputTextComponent } from './component/input-text/input-text.component';
import { InputSelectComponent } from './component/input-select/input-select.component';



@NgModule({
  declarations: [InputTextComponent, InputSelectComponent],
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
    InputTextComponent,
    InputSelectComponent,
  ]

})
export class SharedModule { }
