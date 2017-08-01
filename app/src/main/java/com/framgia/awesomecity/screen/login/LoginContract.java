package com.framgia.awesomecity.screen.login;


import com.framgia.awesomecity.data.model.LoginModel;
import com.framgia.awesomecity.screen.BasePresenter;
import com.framgia.awesomecity.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface LoginContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onLoginFailConnection();
        void onLoginFailWrong();
        void onLoginSuccess();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void login(LoginModel signin);
        void checkIfLoggedIn();
    }
}
