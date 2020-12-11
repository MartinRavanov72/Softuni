import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { emailValidator } from 'src/app/shared/validators';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
  
export class LoginComponent implements OnInit {

  form: FormGroup;

  isLoading = false;
  errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private router: Router
  ) { 
    
    const passwordControl = this.fb.control('', [Validators.required, Validators.minLength(4)]);
    this.form = this.fb.group({
      email: ['', [Validators.required, emailValidator]],
      password: passwordControl
    });
  }

  ngOnInit(): void {
  }

  submitFormHandler(): void {
    const data = this.form.value;
    this.isLoading = true;
    this.errorMessage = '';

    this.userService.login(data).subscribe({
      next: (data) => {
        this.isLoading = false;
        this.router.navigate(['/']);
      },
      error: (err) => {
        this.errorMessage = err.error.message;
        this.isLoading = false;
      }
    });
  }
}
