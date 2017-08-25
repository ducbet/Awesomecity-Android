package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.Restaurant;
import com.framgia.awesomecity.data.source.remote.RestaurantRemoteDataSource;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/3/2017.
 */
public final class RestaurantRepository implements RestaurantDataSource {
    private static RestaurantRepository sInstance;
    private RestaurantDataSource mRestaurantRemoteDataSource;

    public static RestaurantRepository getInstance() {
        if (sInstance == null) {
            sInstance = new RestaurantRepository();
        }
        return sInstance;
    }

    private RestaurantRepository() {
        mRestaurantRemoteDataSource = new RestaurantRemoteDataSource();
    }

    @Override
    public Observable<Restaurant> getRestaurant() {
        return mRestaurantRemoteDataSource.getRestaurant();
    }
}
