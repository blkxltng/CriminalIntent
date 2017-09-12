package com.blkxltng.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.Date;

/**
 * Created by firej on 9/12/2017.
 */

public class DatePickerActivity extends SingleFragmentActivity {

    public static final String EXTRA_DATE = "com.blkxltng.criminalintent.date";

    @Override
    protected Fragment createFragment() {
        return new DatePickerFragment();
    }

    public static Intent newIntent(Context packageContext, Date date) {
        Intent intent = new Intent(packageContext, DatePickerActivity.class);
        intent.putExtra(EXTRA_DATE, date);
        return intent;
    }


}
