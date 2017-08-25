package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.Restaurant;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/9/2017.
 */
public interface RestaurantDataSource {
    Observable<Restaurant> getRestaurant();
}
