package com.example.newsletter.ui.registration;

public class RegistrationInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    RegistrationInUserView(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
