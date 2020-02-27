package com.example.newsletter.ui.registration;

import androidx.annotation.Nullable;

public class RegistrationFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer confirmPasswordError;
    private boolean isDataValid;

    RegistrationFormState(@Nullable Integer usernameError, @Nullable Integer passwordError, @Nullable Integer confirmPasswordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.confirmPasswordError = confirmPasswordError;
        this.isDataValid = false;
    }

    RegistrationFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.confirmPasswordError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    public Integer getPasswordError() {
        return passwordError;
    }

    @Nullable
    public Integer getConfirmPasswordError() {
        return confirmPasswordError;
    }


    public boolean isDataValid() {
        return isDataValid;
    }
}
