package ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvFoodPicsAdapter;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvMenuItemsAdapter;
import ezooma.customer.com.ezooma.utilities.abstracts.BaseActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class ProviderFoodDetailActivity extends BaseActivity {
    AppCompatImageView mImgBack, mImgBookMark, mImgThumbNail, mImgSearch;
    AppCompatTextView mTxtRating, mTxtProviderName, mTxtLocation, mTxtDeliveryDays, mTxtPersons,
            mTxtSeeAll, mTxtType, mTxtDistance;
    RecyclerView mRvImages, mRvMenuItems, mRvMenu;
    RvMenuItemsAdapter mRvMenuItemsAdapter;
    RvFoodPicsAdapter mRvFoodPicsAdapter;
    RelativeLayout mRlRating, mRlCart, mRlViewMyCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caterer_food_detail);
        initVariables();
        setViewsClicks();
        setUpImagesRv();
        setUpMenuItemsRv();
    }

    private void setUpMenuItemsRv() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvMenuItems.setLayoutManager(layoutManager);
        mRvMenuItems.setItemAnimator(new DefaultItemAnimator());
        mRvMenuItemsAdapter = new RvMenuItemsAdapter(this);
        mRvMenuItems.setAdapter(mRvMenuItemsAdapter);
    }

    private void setUpImagesRv() {
        SnapHelper lSnapHelper = new LinearSnapHelper();
        lSnapHelper.attachToRecyclerView(mRvImages);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return true;
            }
        };
        mRvImages.setLayoutManager(layoutManager);
        mRvImages.setItemAnimator(new DefaultItemAnimator());
        mRvFoodPicsAdapter = new RvFoodPicsAdapter(this);
        mRvImages.setAdapter(mRvFoodPicsAdapter);
    }

    private void initVariables() {
        mImgBack = findViewById(R.id.imgBack);
        mImgBookMark = findViewById(R.id.imgBookMark);
        mImgThumbNail = findViewById(R.id.imgFoodThumbnail);
        mImgSearch = findViewById(R.id.imgSearch);
        /*mTxtRating = findViewById(R.id.);*/
        mTxtProviderName = findViewById(R.id.txtProviderName);
        mTxtLocation = findViewById(R.id.txtLocation);
        mTxtDeliveryDays = findViewById(R.id.txtTime);
        mTxtPersons = findViewById(R.id.txtPersons);
        mTxtSeeAll = findViewById(R.id.txtSeeAll);
        mTxtType = findViewById(R.id.txtFoodType);
        mTxtDistance = findViewById(R.id.txtDistance);
        mRvImages = findViewById(R.id.rvFoodPhotos);
        mRvMenuItems = findViewById(R.id.rvFoodMenuItems);
        mRlRating = findViewById(R.id.rlRating);
        mRlCart = findViewById(R.id.rlCart);
        mRlViewMyCart = findViewById(R.id.rlViewMyCart);
        /*mRvMenu = findViewById(R.id.);*/
        mImgBookMark.setSelected(false);
    }


    private void setViewsClicks() {
        mRlViewMyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(ProviderFoodDetailActivity.this, MyCartActivity.class, false, null);
            }
        });
        mRlRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(ProviderFoodDetailActivity.this, ReviewsActivity.class, false, null);
            }
        });
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mImgBookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImgBookMark.isSelected()) {
                    mImgBookMark.setSelected(false);
                } else {
                    mImgBookMark.setSelected(true);
                }
            }
        });
    }

}
