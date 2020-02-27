package com.example.newsletter.ui.registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.newsletter.R;

public class RegistrationViewModel extends ViewModel {

    private MutableLiveData<RegistrationFormState> registrationFormState = new MutableLiveData<>();
    private MutableLiveData<RegistrationResult> registrationResult = new MutableLiveData<>();


    RegistrationViewModel() {

    }

    public LiveData<RegistrationFormState> getRegistrationFormState() {
        return registrationFormState;
    }

    public LiveData<RegistrationResult> getRegistrationResult() {
        return registrationResult;
    }

    public void registration(String username, String password) {
        // can be launched in a separate asynchronous job
        //Result<LoggedInUser> result = loginRepository.login(username, password);

        //if (result instanceof Result.Success) {
            //LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            //loginResult.setValue(new RegistrationResult(new RegistrationInUserView(data.getDisplayName())));
        //} else {
            //loginResult.setValue(new RegistrationResult(R.string.login_failed));
        //}
    }

    public void registrationDataChanged(String username, String password, String confirmPassword) {
        if (!isUserNameValid(username)) {
            registrationFormState.setValue(new RegistrationFormState(R.string.invalid_username, null, null));
        } else if (!isPasswordValid(password)) {
            registrationFormState.setValue(new RegistrationFormState(null, R.string.invalid_password, null));
        } else if (!isConfirmPasswordValid(password, confirmPassword)) {
            registrationFormState.setValue(new RegistrationFormState(null, null, R.string.invalid_confirm_password));
        } else {
            registrationFormState.setValue(new RegistrationFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    private boolean isConfirmPasswordValid(String password, String confirmPassword){
        if(password.compareTo(confirmPassword)==0){
            return true;
        } else {
            return false;
        }

    }
}
