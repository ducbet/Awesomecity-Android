package com.framgia.awesomecity.data.source.remote;

import com.framgia.awesomecity.data.model.OrderDish;
import com.framgia.awesomecity.data.source.OrderDishesDataSource;
import com.framgia.awesomecity.service.CityService;
import com.framgia.awesomecity.service.ServiceGenerator;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/10/2017.
 */

public class OrderDishesRemoteDataSource implements OrderDishesDataSource {

    private CityService mCityService;

    public OrderDishesRemoteDataSource(){
        mCityService = ServiceGenerator.createService(CityService.class);
    }

    @Override
    public Observable<List<OrderDish>> getOrderDishes() {
        return mCityService.getOrderDishes();
    }

    @Override
    public Observable<OrderDish> getOrderDish(int orderDishId) {
        return mCityService.getOrderDish(orderDishId);
    }
}
