package com.framgia.awesomecity.data.source;

import android.content.Context;

import com.framgia.awesomecity.data.model.Restaurant;
import com.framgia.awesomecity.data.source.local.RestaurantLocalDataSource;
import com.framgia.awesomecity.data.source.remote.RestaurantRemoteDataSource;

import io.reactivex.Observable;

/**
 * Created by tmd on 8/3/2017.
 */
public final class RestaurantRepository implements RestaurantDataSource {
    private static RestaurantRepository sInstance;
    private RestaurantDataSource mRestaurantRemoteDataSource;
    private RestaurantLocalDataSource mRestaurantLocalDataSource;

    public static RestaurantRepository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new RestaurantRepository(context);
        }
        return sInstance;
    }

    private RestaurantRepository(Context context) {
        mRestaurantRemoteDataSource = new RestaurantRemoteDataSource();
        mRestaurantLocalDataSource = new RestaurantLocalDataSource(context);
    }

    @Override
    public Observable<Restaurant> getRestaurant() {
        Observable<Restaurant> mLocalRestaurantObservable =
            mRestaurantLocalDataSource.getRestaurant();
        Observable<Restaurant> mRemoteRestaurantObservable =
            mRestaurantRemoteDataSource.getRestaurant();
        return Observable.concat(mLocalRestaurantObservable, mRemoteRestaurantObservable)
            .first(new Restaurant())
            .toObservable();
    }
}
