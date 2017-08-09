package com.framgia.awesomecity.data.source.remote;

import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.data.model.OrderDish;
import com.framgia.awesomecity.data.source.OrdersDataSource;
import com.framgia.awesomecity.service.CityService;
import com.framgia.awesomecity.service.ServiceGenerator;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/3/2017.
 */

public class OrdersRemoteDataSource implements OrdersDataSource {

    private CityService mCityService;

    public OrdersRemoteDataSource(){
        mCityService = ServiceGenerator.createService(CityService.class);
    }

    @Override
    public Observable<List<Order>> getOrders() {
        return mCityService.getOrders();
    }

    @Override
    public Observable<Order> getOrder(int orderId) {
        return mCityService.getOrder(orderId);
    }

    @Override
    public Observable<Boolean> doneOrderDish(int orderId, OrderDish orderDish) {
        return mCityService.doneOrderDish(orderId, orderDish);
    }

    @Override
    public Observable<Boolean> cancelOrderDish(int orderId, OrderDish orderDish) {
        return mCityService.cancelOrderDish(orderId, orderDish);
    }

}
