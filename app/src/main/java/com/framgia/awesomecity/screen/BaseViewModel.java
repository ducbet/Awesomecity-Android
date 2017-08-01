package com.framgia.awesomecity.screen;

/**
 * Created by tmd on 18/07/2017.
 */

public interface BaseViewModel<T> {
    void onStart();

    void onStop();

    void setPresenter(T presenter);
}
