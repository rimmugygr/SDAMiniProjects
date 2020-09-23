import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-input-select',
  templateUrl: './select-form.component.html',
  styleUrls: ['./select-form.component.css']
})
export class SelectFormComponent implements OnInit {

  @Input() id: string;
  @Input() label: string;
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
