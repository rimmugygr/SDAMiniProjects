import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-input-text',
  templateUrl: './input-text.component.html',
  styleUrls: ['./input-text.component.css']
})
export class InputTextComponent implements OnInit {

  @Input() id: string;
  @Input() label: string;
  @Input() placeholder = '';
  @Input() form: FormGroup;
  @Input() showErrors: boolean;
  @Input() mask?: string;

  constructor() { }

  ngOnInit(): void {
  }

  ifRequired(value: string): boolean {
    const field = this.form.get(value);
    return this.showErrors ? field.errors?.required : field?.touched && field.errors?.required;
  }
}
