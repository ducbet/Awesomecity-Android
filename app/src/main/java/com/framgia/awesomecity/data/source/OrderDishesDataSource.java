package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.OrderDish;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/10/2017.
 */

public interface OrderDishesDataSource {

    Observable<List<OrderDish>> getOrderDishes();

    Observable<OrderDish> getOrderDish(int orderDishId);
}
