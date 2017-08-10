package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.OrderDish;
import com.framgia.awesomecity.data.source.remote.OrderDishesRemoteDataSource;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/10/2017.
 */

public class OrderDishesRepository implements OrderDishesDataSource {

    private static OrderDishesRepository sInstance;

    private OrderDishesDataSource mOrderDishesRemoteDataSource;

    public static OrderDishesRepository getInstance(){
        if(sInstance == null)
            sInstance = new OrderDishesRepository();
        return sInstance;
    }

    private OrderDishesRepository(){
        mOrderDishesRemoteDataSource = new OrderDishesRemoteDataSource();
    }

    @Override
    public Observable<List<OrderDish>> getOrderDishes() {
        return mOrderDishesRemoteDataSource.getOrderDishes();
    }

    @Override
    public Observable<OrderDish> getOrderDish(int orderDishId) {
        return mOrderDishesRemoteDataSource.getOrderDish(orderDishId);
    }
}
