package com.framgia.awesomecity.screen.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.util.Log;
import android.widget.Toast;

import com.framgia.awesomecity.data.model.LoginModel;
import com.framgia.awesomecity.screen.main.MainActivity;
import com.framgia.awesomecity.service.LoginResponse;
import com.framgia.awesomecity.service.LoginService;
import com.framgia.awesomecity.service.ServiceGenerator;
import com.framgia.awesomecity.utils.Values;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Listens to user actions from the UI ({@link LoginActivity}), retrieves the data and updates
 * the UI as required.
 */
final class LoginPresenter extends BaseObservable implements LoginContract.Presenter {
    private static final String TAG = LoginPresenter.class.getName();

    private final LoginContract.ViewModel mViewModel;
    private Context mContext;

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
        LoginService service = ServiceGenerator.createService(LoginService.class);
        service.login(signin).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == Values.POST_OK) {
                    LoginResponse model = response.body();
                    mViewModel.onLoginSuccess();

                    Intent intent = new Intent(mContext, MainActivity.class);
                    mContext.startActivity(intent);
                } else {
                    mViewModel.onLoginFailWrong();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mViewModel.onLoginFailConnection();
            }
        });
    }
}
