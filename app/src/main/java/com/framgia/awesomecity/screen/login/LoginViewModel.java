package com.framgia.awesomecity.screen.login;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.framgia.awesomecity.data.model.LoginModel;
import com.framgia.awesomecity.data.model.UserModel;
import com.framgia.awesomecity.utils.Values;

/**
 * Exposes the data to be used in the Login screen.
 */

public class LoginViewModel extends BaseObservable
        implements LoginContract.ViewModel {

    private LoginContract.Presenter mPresenter;

    private String mErrorMessage;
    private String mEmail;
    private String mPassword;

    public LoginViewModel() {
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    @Bindable
    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    @Override
    public void onLoginFailConnection() {
        setErrorMessage(Values.LOGIN_FAIL_CONNECTION);
        notifyPropertyChanged(BR.errorMessage);
    }

    @Override
    public void onLoginFailWrong() {
        setErrorMessage(Values.LOGIN_FAIL_WRONG);
        notifyPropertyChanged(BR.errorMessage);

    }

    @Override
    public void onLoginSuccess() {
        setErrorMessage(Values.LOGIN_SUCCESS);
        notifyPropertyChanged(BR.errorMessage);
    }

    public void onLoginButtonClicked(View view) {
        mPresenter.login(new LoginModel(new UserModel(mEmail, mPassword)));
    }
}
