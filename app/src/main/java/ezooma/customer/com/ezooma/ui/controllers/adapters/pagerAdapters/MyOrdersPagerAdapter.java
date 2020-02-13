package ezooma.customer.com.ezooma.ui.controllers.adapters.pagerAdapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import ezooma.customer.com.ezooma.ui.controllers.fragments.CurrentOrdersFragment;
import ezooma.customer.com.ezooma.ui.controllers.fragments.PastOrdersFragment;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class MyOrdersPagerAdapter extends FragmentStatePagerAdapter {
    private String[] mPagerTitles;

    public MyOrdersPagerAdapter(@NonNull FragmentManager fm, String[] pPagerTitles) {
        super(fm);
        mPagerTitles = pPagerTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CurrentOrdersFragment.newInstance();
            case 1:
                return PastOrdersFragment.newInstance();

        }

        return CurrentOrdersFragment.newInstance();
    }

    @Override
    public int getCount() {
        return mPagerTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerTitles[position];//mFragmentTitleList.get(position);
    }
}
