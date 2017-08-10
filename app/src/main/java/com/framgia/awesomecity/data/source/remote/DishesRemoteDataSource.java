package com.framgia.awesomecity.data.source.remote;

import com.framgia.awesomecity.data.model.Dish;
import com.framgia.awesomecity.data.source.DishesDataSource;
import com.framgia.awesomecity.service.CityService;
import com.framgia.awesomecity.service.ServiceGenerator;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/10/2017.
 */

public class DishesRemoteDataSource implements DishesDataSource {

    private CityService mCityService;

    public DishesRemoteDataSource(){
        mCityService = ServiceGenerator.createService(CityService.class);
    }

    @Override
    public Observable<List<Dish>> getDishes() {
        return mCityService.getDishes();
    }

    @Override
    public Observable<Dish> getDish(int dishId) {
        return mCityService.getDish(dishId);
    }
}
