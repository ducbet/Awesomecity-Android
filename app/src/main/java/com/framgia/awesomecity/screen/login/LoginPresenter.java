package com.framgia.awesomecity.screen.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.framgia.awesomecity.data.model.LoginModel;
import com.framgia.awesomecity.screen.main.MainActivity;
import com.framgia.awesomecity.service.LoginResponse;
import com.framgia.awesomecity.service.LoginService;
import com.framgia.awesomecity.service.ServiceGenerator;
import com.framgia.awesomecity.utils.Values;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.framgia.awesomecity.utils.Values.RESONSE_EMAIL;
import static com.framgia.awesomecity.utils.Values.RESPONSE_LOGIN_STATUS;
import static com.framgia.awesomecity.utils.Values.RESPONSE_TOKEN;

/**
 * Listens to user actions from the UI ({@link LoginActivity}), retrieves the data and updates
 * the UI as required.
 */
final class LoginPresenter extends BaseObservable implements LoginContract.Presenter {
    private static final String TAG = LoginPresenter.class.getName();

    private final LoginContract.ViewModel mViewModel;
    private Context mContext;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public LoginPresenter(LoginContract.ViewModel viewModel, Context context) {
        mViewModel = viewModel;
        mContext = context;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void login(LoginModel signin) {
        final LoginService service = ServiceGenerator.createService(LoginService.class);
        mCompositeDisposable.add(service.login(signin)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<LoginResponse>() {
                    @Override
                    public void onNext(@NonNull LoginResponse loginResponse) {
                        storeLoginData(loginResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mViewModel.onLoginFailWrong();
                    }

                    @Override
                    public void onComplete() {
                        mViewModel.onLoginSuccess();
                    }
                })
        );
    }

    @Override
    public void checkIfLoggedIn() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        Boolean status = preferences.getBoolean(RESPONSE_LOGIN_STATUS, false);

        if (status == true) {
            Intent intent = new Intent(mContext, MainActivity.class);
            mContext.startActivity(intent);
        }
    }

    public void storeLoginData(LoginResponse response) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(RESPONSE_LOGIN_STATUS, true);
        editor.putString(RESONSE_EMAIL, response.getUserResponse().getEmail());
        editor.putString(RESPONSE_TOKEN, response.getUserResponse().getToken());
        editor.commit();
    }

}

