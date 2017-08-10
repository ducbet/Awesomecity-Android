package com.framgia.awesomecity.service;

import com.framgia.awesomecity.data.model.Dish;
import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.data.model.OrderDish;
import com.framgia.awesomecity.data.model.TableModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by lamvu on 8/9/2017.
 */

public interface CityService {

    @GET("orders")
    Observable<List<Order>> getOrders();

    @GET("orders/{orderId}")
    Observable<Order> getOrder(@Path("orderId") int orderId);

    @POST("orders/{orderId}")
    Observable<Boolean> doneOrderDish(@Path("orderId") int orderId, @Body OrderDish orderDish);

    @POST("orders/{orderId}")
    Observable<Boolean> cancelOrderDish(@Path("tableId") int orderId, @Body OrderDish orderDish);

    @GET("tables")
    Observable<List<TableModel>> getTables();

    @GET("dishes/{dishId}")
    Observable<Dish> getDish(@Path("dishId") int dishId);
}
