package com.example.newsletter.ui.registration;

import androidx.annotation.Nullable;


public class RegistrationResult {
    @Nullable
    private RegistrationInUserView success;
    @Nullable
    private Integer error;

    RegistrationResult(@Nullable Integer error) {
        this.error = error;
    }

    RegistrationResult(@Nullable RegistrationInUserView success) {
        this.success = success;
    }

    @Nullable
    public RegistrationInUserView getSuccess() {
        return success;
    }

    @Nullable
    public Integer getError() {
        return error;
    }
}
