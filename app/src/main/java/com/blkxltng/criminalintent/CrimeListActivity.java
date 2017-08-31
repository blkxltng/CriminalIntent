package com.blkxltng.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by firej on 8/30/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
