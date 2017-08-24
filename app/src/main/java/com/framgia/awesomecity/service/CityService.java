package com.framgia.awesomecity.service;

import com.framgia.awesomecity.data.model.Dish;
import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.data.model.OrderDish;
import com.framgia.awesomecity.data.model.Restaurant;
import com.framgia.awesomecity.data.model.Table;

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
    @GET("orders?status=serving")
    Observable<List<Order>> getOrders();
    @GET("orders/{orderId}")
    Observable<Order> getOrder(@Path("orderId") int orderId);
    @GET("orders/{orderId}/order_dishes")
    Observable<List<OrderDish>> getOrderDishes(@Path("orderId") int orderId);
    @POST("orders/{orderId}")
    Observable<Boolean> doneOrderDish(@Path("orderId") int orderId, @Body OrderDish orderDish);
    @POST("orders/{orderId}")
    Observable<Boolean> cancelOrderDish(@Path("tableId") int orderId, @Body OrderDish orderDish);
    @GET("tables")
    Observable<List<Table>> getTables();
    @GET("tables/{tableId}")
    Observable<Table> getTable(@Path("tableId") int tableId);
    @GET("dishes")
    Observable<List<Dish>> getDishes();
    @GET("dishes/{dishId}")
    Observable<Dish> getDish(@Path("dishId") int dishId);
    @GET("order_dishes")
    Observable<List<OrderDish>> getOrderDishes();
    @GET("order_dishes/{orderDishId}")
    Observable<OrderDish> getOrderDish(@Path("orderDishId") int orderDishId);
    @GET("restaurant_informations")
    Observable<Restaurant> getRestaurant();
}
