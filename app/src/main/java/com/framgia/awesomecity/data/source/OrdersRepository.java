package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.data.model.OrderDish;
import com.framgia.awesomecity.data.source.remote.OrdersRemoteDataSource;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/3/2017.
 */

public class OrdersRepository implements OrdersDataSource {

    private static OrdersRepository sInstance;

    private OrdersDataSource mOrderRemoteDataSource;

    public static OrdersRepository getInstance(){
        if(sInstance == null)
            sInstance = new OrdersRepository();
        return sInstance;
    }

    private OrdersRepository(){
        mOrderRemoteDataSource = new OrdersRemoteDataSource();
    }

    @Override
    public Observable<List<Order>> getOrders() {
        return mOrderRemoteDataSource.getOrders();
    }

    @Override
    public Observable<Order> getOrder(int orderId) {
        return mOrderRemoteDataSource.getOrder(orderId);
    }

    @Override
    public Observable<Boolean> doneOrderDish(int orderId, OrderDish orderDish) {
        return mOrderRemoteDataSource.doneOrderDish(orderId, orderDish);
    }

    @Override
    public Observable<Boolean> cancelOrderDish(int orderId, OrderDish orderDish) {
        return mOrderRemoteDataSource.cancelOrderDish(orderId, orderDish);
    }

}
