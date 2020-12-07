import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IUser } from 'src/app/shared/interfaces';
import { emailValidator } from 'src/app/shared/validators';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
  
export class ProfileComponent implements OnInit {

  form: FormGroup;

  inEditMode = false;
  isLoading = false;
  errorMessage = "";

  get currentUser(): IUser {
    return this.userService.currentUser;
  }

  constructor(
    private fb: FormBuilder,
    private userService: UserService
  ) {
    this.form = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, emailValidator]],
      imgUrl: ['', [Validators.required]],
      genre: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
  }

  toggleEditMode(): void {
    this.inEditMode = !this.inEditMode;
  }

  submitHandler(): void {
    const data = this.form.value;
    this.errorMessage = '';
    this.isLoading = true;
    this.userService.updateProfile(data).subscribe({
      next: () => {
        this.isLoading = false;
        this.inEditMode = false;
      },
      error: (err) => {
        this.isLoading = false;
        this.errorMessage = err.error.message;
      }
    });
  }
}
