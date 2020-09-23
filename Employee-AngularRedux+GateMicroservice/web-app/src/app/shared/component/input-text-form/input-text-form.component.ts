import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-input-text',
  templateUrl: './input-text-form.component.html',
  styleUrls: ['./input-text-form.component.css']
})
export class InputTextFormComponent implements OnInit {

  @Input() id: string;
  @Input() label: string;
  @Input() placeholder = '';
  @Input() form: FormGroup;
  @Input() showErrors: boolean;
  @Input() mask: string;

  constructor() { }

  ngOnInit(): void {
  }

  ifRequired(value: string): boolean {
    // const field = this.form.get(value);
    // return this.showErrors ? field.errors?.required : field.touched && field.errors?.required;
    return false;
  }
}
