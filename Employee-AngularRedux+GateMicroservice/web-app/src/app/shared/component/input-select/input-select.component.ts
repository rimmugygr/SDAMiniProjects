import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-input-select',
  templateUrl: './input-select.component.html',
  styleUrls: ['./input-select.component.css']
})
export class InputSelectComponent implements OnInit {

  @Input() id: string;
  @Input() label: string;
  @Input() placeholder = '';
  @Input() form: FormGroup;
  @Input() showErrors: boolean;
  @Input() mapOptions: Record<string, string>;
  constructor() { }

  ngOnInit(): void {
  }

  ifRequired(value: string): boolean {
    const field = this.form.get(value);
    return this.showErrors ? field.errors?.required : field.touched && field.errors?.required;
  }
}
