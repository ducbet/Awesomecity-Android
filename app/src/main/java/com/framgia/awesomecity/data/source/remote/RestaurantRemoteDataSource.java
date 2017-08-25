package com.framgia.awesomecity.data.source.remote;

import com.framgia.awesomecity.data.model.Restaurant;
import com.framgia.awesomecity.data.source.RestaurantDataSource;
import com.framgia.awesomecity.service.CityService;
import com.framgia.awesomecity.service.ServiceGenerator;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/9/2017.
 */
public class RestaurantRemoteDataSource implements RestaurantDataSource {
    private CityService mCityService;

    public RestaurantRemoteDataSource() {
        mCityService = ServiceGenerator.createService(CityService.class);
    }

    @Override
    public Observable<Restaurant> getRestaurant() {
        return mCityService.getRestaurant();
    }
}
