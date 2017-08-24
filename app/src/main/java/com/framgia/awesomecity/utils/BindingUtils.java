package com.framgia.awesomecity.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.framgia.awesomecity.R;
import com.framgia.awesomecity.screen.customer.main.MainViewModel;
import com.squareup.picasso.Picasso;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by tmd on 20/07/2017.
 */

public class BindingUtils {

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));
    }

    @BindingAdapter({"drawerLayout", "viewModel"})
    public static void onNavigationItemSelected(final NavigationView navigationView,
                                                final DrawerLayout drawerLayout,
                                                final MainViewModel viewModel) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        drawerLayout.closeDrawer(navigationView);
                        viewModel.onItemSelected(item.getItemId());
                        return true;
                    }
                });
    }

    @BindingAdapter({"toolbar", "activity"})
    public static void setToggle(DrawerLayout drawerLayout, Toolbar toolbar,
                                 AppCompatActivity activity) {
        activity.setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, drawerLayout, toolbar,
                R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.mipmap.food)
                .into(view);
    }
}
