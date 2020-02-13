package ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvMenuItemsAdapter;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvReviewsAdapter;

import android.os.Bundle;
import android.view.View;

public class ReviewsActivity extends AppCompatActivity {
    AppCompatTextView mToolBarTitle;
    RecyclerView mRvReviews;
    AppCompatImageView mImgBack;
    RvReviewsAdapter mRvMenuItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        initVariables();
        setViewsText();
        setViewsClicks();
        setUpReviewsRv();
    }

    private void setViewsClicks() {
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setViewsText() {
        mToolBarTitle.setText("Review & Ratings");
    }

    private void setUpReviewsRv() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        mRvReviews.setLayoutManager(layoutManager);
        mRvReviews.setItemAnimator(new DefaultItemAnimator());
        mRvMenuItemsAdapter = new RvReviewsAdapter(this);
        mRvReviews.setAdapter(mRvMenuItemsAdapter);
    }

    private void initVariables() {
        mToolBarTitle = findViewById(R.id.txtToolbarTitle);
        mRvReviews = findViewById(R.id.rvReviews);
        mImgBack = findViewById(R.id.imgToolbarBack);

    }
}
