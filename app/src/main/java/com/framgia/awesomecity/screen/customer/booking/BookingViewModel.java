package com.framgia.awesomecity.screen.customer.booking;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.framgia.awesomecity.BR;
import com.framgia.awesomecity.screen.customer.main.MainContract;
import com.framgia.awesomecity.screen.customer.main.MainViewModel;
import com.framgia.awesomecity.utils.Values;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Exposes the data to be used in the Booking screen.
 */
public class BookingViewModel extends BaseObservable implements BookingContract.ViewModel {
    private BookingContract.Presenter mPresenter;
    private static final String TAG = "BookingViewModel";
    private String mCapacity;
    private String mDate;
    private String mTime;
    private Context mContext;
    private MainContract.ViewModel mMainViewModel;

    public BookingViewModel(MainContract.ViewModel mainViewModel) {
        mMainViewModel = mainViewModel;
        mContext = ((MainViewModel) mainViewModel).getActivity();
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(BookingContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public String getCapacity() {
        return mCapacity;
    }

    public void setCapacity(String capacity) {
        mCapacity = capacity;
        notifyPropertyChanged(BR.capacity);
    }

    @Bindable
    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
        notifyPropertyChanged(BR.time);
    }

    public void onButtonClicked(View button) {
        mMainViewModel.onOpenTableFragment();
    }

    public void showDatePicker(View view) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog pickerDialog = new DatePickerDialog(mContext,
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                    String timeString = year + "-" + month + "-" + day;
                    try {
                        Date date = dateFormat.parse(timeString);
                        setDate(dateFormat.format(date));
                    } catch (ParseException e) {
                        Log.e(TAG, Values.ERROR_DATE_TIME);
                    }
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH));
        pickerDialog.show();
    }

    public void showTimePicker(View view) {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog pickerDialog = new TimePickerDialog(mContext,
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.US);
                    String dateString = hour + ":" + minute;
                    try {
                        Date date = timeFormat.parse(dateString);
                        setTime(timeFormat.format(date));
                    } catch (ParseException e) {
                        Log.e(TAG, Values.ERROR_DATE_TIME);
                    }
                }
            },
            calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        pickerDialog.show();
    }
}
