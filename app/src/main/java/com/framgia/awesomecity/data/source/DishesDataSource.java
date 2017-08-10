package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.Dish;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/10/2017.
 */

public interface DishesDataSource {

    Observable<List<Dish>> getDishes();

    Observable<Dish> getDish(int dishId);
}
