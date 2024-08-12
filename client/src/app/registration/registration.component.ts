

import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpService } from '../../services/http.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {
  itemForm!: FormGroup;
  formModel: any = { role: null, email: '', password: '', username: '' };
  showMessage: boolean = false;
  responseMessage: any;
  usernamePattern = '^[a-z]+$';
  passwordPattern = '^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$';

  constructor(
    private formBuilder: FormBuilder,
    private bookService: HttpService,
    private router: Router
  ) {
    this.itemForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.pattern(this.usernamePattern)]],
      email: ['', [Validators.required, this.emailValidator]],
      password: ['', [Validators.required, Validators.pattern(this.passwordPattern)]],
      role: ['', [Validators.required]],
    });
  }

  ngOnInit(): void {}

  emailValidator(control: AbstractControl): ValidationErrors | null {
    const emailRegex: RegExp = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailRegex.test(control.value)) {
      return { invalidEmailFormat: true }
    }
    return null;
  }

  onRegister(): void {
    if (this.itemForm.valid) {
      this.bookService.registerUser(this.itemForm.value).subscribe(
        data => {
          this.showMessage = true;
          this.responseMessage = data.message;
          this.itemForm.reset();
        },
        error => {
          this.showMessage = true;
          this.responseMessage = error.message;
        }
      );
    } else {
      this.itemForm.markAllAsTouched();
    }
  }
}

