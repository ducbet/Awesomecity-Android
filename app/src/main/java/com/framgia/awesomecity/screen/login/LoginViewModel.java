package com.framgia.awesomecity.screen.login;


import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.framgia.awesomecity.data.model.LoginModel;
import com.framgia.awesomecity.data.model.User;
import com.framgia.awesomecity.utils.Values;

/**
 * Exposes the data to be used in the Login screen.
 */

public class LoginViewModel extends BaseObservable implements LoginContract.ViewModel {

    private LoginContract.Presenter mPresenter;

    private Context mContext;
    private String mErrorMessage;
    private String mUsername;
    private String mPassword;

    public LoginViewModel(Context context) {
        mContext = context;
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
    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
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
    public void onLoginSuccess(String token) {
        setErrorMessage(Values.LOGIN_SUCCESS);
        notifyPropertyChanged(BR.errorMessage);
    }

    public void onLoginButtonClicked(View view) {
        mPresenter.login(new LoginModel(new User(mUsername, mPassword)));
    }

}
