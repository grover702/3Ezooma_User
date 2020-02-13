package ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.interfaces.OnFragmentInteraction;
import ezooma.customer.com.ezooma.ui.controllers.adapters.pagerAdapters.MyOrdersPagerAdapter;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MyOrdersActivity extends AppCompatActivity implements OnFragmentInteraction {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    AppCompatTextView mTxtTitle;
    AppCompatImageView mImgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        initVariables();
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setUpTabLayouts();
    }

    private void initVariables() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.pager);
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mImgBack = findViewById(R.id.imgToolbarBack);
        mTxtTitle.setText("My Orders");
    }
    private void setUpTabLayouts() {

        String[] strings = new String[]{"Current Orders", "Past Orders"};

        MyOrdersPagerAdapter lMyOrdersPagerAdapter = new MyOrdersPagerAdapter(getSupportFragmentManager(), strings);

        mViewPager.setAdapter(lMyOrdersPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragment(Object o, String fragmentTag) {

    }
}
