package ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.interfaces.OnItemClickListener;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvNotificationsAdapter;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvProviderListAdapter;
import ezooma.customer.com.ezooma.utilities.abstracts.BaseActivity;

import android.os.Bundle;
import android.view.View;

public class ProvidersListActivity extends BaseActivity {
    RecyclerView mRvProviderList;
    RvProviderListAdapter mRvProviderListAdapter;
    AppCompatImageView mImgHomeToolbarMenu, mImgToolbarCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_providers_list);
        initVariables();
        setUpRv();
        setUpClicks();
    }

    private void setUpClicks() {
        mImgHomeToolbarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mImgToolbarCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(ProvidersListActivity.this, ChangeLocationActivity.class, false, null);
            }
        });
    }

    private void setUpRv() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        mRvProviderList.setLayoutManager(layoutManager);
        mRvProviderList.setItemAnimator(new DefaultItemAnimator());
        mRvProviderListAdapter = new RvProviderListAdapter(this);
        mRvProviderList.setAdapter(mRvProviderListAdapter);
        mRvProviderListAdapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, String object, int position) {
                if(view.getId()==R.id.imgBookMark){

                }

                changeActivity(ProvidersListActivity.this, ProviderFoodDetailActivity.class, false, null);
            }
        });
    }

    private void initVariables() {
        mRvProviderList = findViewById(R.id.rvProviderList);
        mImgHomeToolbarMenu = findViewById(R.id.imgHomeToolbarMenu);
        mImgToolbarCart = findViewById(R.id.imgToolbarCart);
    }
}
