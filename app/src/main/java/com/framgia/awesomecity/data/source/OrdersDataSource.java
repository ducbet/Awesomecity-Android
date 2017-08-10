package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.data.model.OrderDish;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/3/2017.
 */

public interface OrdersDataSource {

    Observable<List<Order>> getOrders();

    Observable<Order> getOrder(int orderId);

    Observable<Boolean> doneOrderDish(int orderId, OrderDish orderDish);

    Observable<Boolean> cancelOrderDish(int orderId, OrderDish orderDish);
}
