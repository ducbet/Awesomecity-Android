package com.framgia.awesomecity.screen.login;

import android.databinding.BaseObservable;

import com.framgia.awesomecity.data.model.LoginModel;
import com.framgia.awesomecity.data.model.TableModel;
import com.framgia.awesomecity.service.LoginResponse;
import com.framgia.awesomecity.service.LoginService;
import com.framgia.awesomecity.service.ServiceGenerator;
import com.framgia.awesomecity.utils.Values;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import retrofit2.Response;

/**
 * Listens to user actions from the UI ({@link LoginActivity}), retrieves the data and updates
 * the UI as required.
 */
final class LoginPresenter extends BaseObservable implements LoginContract.Presenter {
    private static final String TAG = LoginPresenter.class.getName();

    private final LoginContract.ViewModel mViewModel;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public LoginPresenter(LoginContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    @Override
    public void login(LoginModel signin) {
        final LoginService service = ServiceGenerator.createService(LoginService.class);
        mCompositeDisposable.add(service.login(signin)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response<LoginResponse>>() {
                    @Override
                    public void onNext(@NonNull Response<LoginResponse> response) {
                        if (response.code() != Values.POST_OK) {
                            mViewModel.onLoginFailWrong();
                            return;
                        }
                        mViewModel.onLoginSuccess(response.body().getUserResponse().getToken());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mViewModel.onLoginFailConnection();
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
    }

}

