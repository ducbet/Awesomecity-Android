package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.Dish;
import com.framgia.awesomecity.data.source.remote.DishesRemoteDataSource;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/10/2017.
 */

public class DishesRepository implements DishesDataSource {

    private static DishesRepository sInstance;

    private DishesDataSource mDishesRemoteDataSource;

    public static DishesRepository getInstance(){
        if(sInstance == null)
            sInstance = new DishesRepository();
        return sInstance;
    }

    private DishesRepository(){
        mDishesRemoteDataSource = new DishesRemoteDataSource();
    }

    @Override
    public Observable<List<Dish>> getDishes() {
        return mDishesRemoteDataSource.getDishes();
    }

    @Override
    public Observable<Dish> getDish(int dishId) {
        return mDishesRemoteDataSource.getDish(dishId);
    }
}
