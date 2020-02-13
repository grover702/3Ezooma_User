package ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.interfaces.OnItemClickListener;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvMyOrderAdapter;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvTrendingCaterersAdapter;
import ezooma.customer.com.ezooma.utilities.abstracts.BaseActivity;

import android.os.Bundle;
import android.view.View;

public class MyCartActivity extends BaseActivity {
    RecyclerView mRvCartOrder;
    AppCompatTextView mTxtToolBarTitle;
    AppCompatImageView mImgBack, mImgEditAddress;
    RvMyOrderAdapter mRvMyOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        initVariables();
        setUpCartOrderRv();
        setViewsClick();
    }

    private void setViewsClick() {
        mImgEditAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MyCartActivity.this, ChangeLocationActivity.class, false, null);
            }
        });
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setUpCartOrderRv() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvCartOrder.setLayoutManager(layoutManager);
        mRvCartOrder.setItemAnimator(new DefaultItemAnimator());
        mRvMyOrderAdapter = new RvMyOrderAdapter(this);
        mRvCartOrder.setAdapter(mRvMyOrderAdapter);
    }

    private void initVariables() {
        mRvCartOrder = findViewById(R.id.rvCartOrder);
        mTxtToolBarTitle = findViewById(R.id.txtToolbarTitle);
        mImgBack = findViewById(R.id.imgToolbarBack);
        mImgEditAddress = findViewById(R.id.imgEditAddress);
        mTxtToolBarTitle.setText("My Cart");
    }
}
