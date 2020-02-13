package ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.interfaces.OnItemClickListener;
import ezooma.customer.com.ezooma.models.CategoriesModel;
import ezooma.customer.com.ezooma.ui.controllers.activities.loginSignupPackage.ChangePasswordActivity;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvFoodCategoriesAdapter;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvTrendingCaterersAdapter;
import ezooma.customer.com.ezooma.utilities.abstracts.BaseActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenActivity extends BaseActivity {
    AppCompatTextView mToolbarTitle, mTxtSeeAll;
    AppCompatImageView mImgToolbarSideMenu, mImgToolbarCart, mImgFilters;
    DrawerLayout mDrawerLayout;
    NavigationView mNavView;
    AppCompatEditText mEdtSearch;
    RecyclerView mRvTrendingCaterers, mRvFoodCategories;
    RvTrendingCaterersAdapter mRvTrendingCaterersAdapter;
    RvFoodCategoriesAdapter mRvFoodCategoriesAdapter;

    List<CategoriesModel> mCategoriesList = new ArrayList<>();
    CategoriesModel oldIndexObject = null;
    int oldIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initVariables();
        setInitialValues();
        setUpTrendingRv();
        setUpFoodCategoriesRv();
        homeClickListeners();
    }

    private void setUpTrendingRv() {
        SnapHelper lSnapHelper = new LinearSnapHelper();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return true;
            }
        };
        mRvTrendingCaterers.setLayoutManager(layoutManager);
        mRvTrendingCaterers.setItemAnimator(new DefaultItemAnimator());
        lSnapHelper.attachToRecyclerView(mRvTrendingCaterers);
        mRvTrendingCaterersAdapter = new RvTrendingCaterersAdapter(this);
        mRvTrendingCaterers.setAdapter(mRvTrendingCaterersAdapter);
        mRvTrendingCaterersAdapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, String object, int position) {
                changeActivity(HomeScreenActivity.this, ProviderFoodDetailActivity.class, false, null);
            }
        });
    }

    private void setUpFoodCategoriesRv() {
        for (int i = 0; i < 10; i++) {
            CategoriesModel lCategoriesModel = new CategoriesModel();
            lCategoriesModel.setVisibleSubCate(false);
            mCategoriesList.add(lCategoriesModel);
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRvFoodCategories.setLayoutManager(layoutManager);
        mRvFoodCategories.setItemAnimator(new DefaultItemAnimator());
        mRvFoodCategoriesAdapter = new RvFoodCategoriesAdapter(this,mCategoriesList);
        mRvFoodCategories.setAdapter(mRvFoodCategoriesAdapter);
        mRvFoodCategoriesAdapter.setOnItemClickListener(new OnItemClickListener<CategoriesModel>() {
            @Override
            public void onItemClick(View view, CategoriesModel object, int position) {

                int index = mCategoriesList.indexOf(object);
                if (index == -1)
                    return;
                if (object.isVisibleSubCate()) {
                    object.setVisibleSubCate(false);
                } else {
                    object.setVisibleSubCate(true);
                }
                if (oldIndex == -1 || oldIndex == index) {
                    oldIndex = position;
                    oldIndexObject = object;
                } else /*if (oldIndex != index)*/ {
                    // int oldIndex = filterList.indexOf(oldIndexObject);
                       /* if (oldIndex == -1)
                            return;*/
                    oldIndexObject.setVisibleSubCate(false);
                    mCategoriesList.set(oldIndex, oldIndexObject);
                    mRvFoodCategoriesAdapter.notifyItemChanged(oldIndex);
                    oldIndex = position;
                    oldIndexObject = object;
                }
                mCategoriesList.set(index, object);

                mRvFoodCategoriesAdapter.notifyItemChanged(index);
            }
        });
    }

    private void initVariables() {
        mToolbarTitle = findViewById(R.id.txtHomeToolbarTitle);
        mImgToolbarSideMenu = findViewById(R.id.imgHomeToolbarMenu);
        mImgToolbarCart = findViewById(R.id.imgToolbarCart);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavView = findViewById(R.id.nav_view);
        mTxtSeeAll = findViewById(R.id.txtSeeAll);
        mImgFilters = findViewById(R.id.imgFilter);
        mEdtSearch = findViewById(R.id.edtSearch);
        mRvTrendingCaterers = findViewById(R.id.rvTrendingCaterers);
        mRvFoodCategories = findViewById(R.id.rvCategories);
    }

    private void setInitialValues() {
        openCloseDrawer(false);
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_myOrders:
                        openCloseDrawer(false);
                        changeActivity(HomeScreenActivity.this, MyOrdersActivity.class, false, null);
                        return false;
                    case R.id.nav_notifications:
                        openCloseDrawer(false);
                        changeActivity(HomeScreenActivity.this, NotificationsActivity.class, false, null);
                        return false;
                    case R.id.nav_Help:
                        openCloseDrawer(false);
                        changeActivity(HomeScreenActivity.this, HelpActivity.class, false, null);
                        return false;
                    case R.id.nav_ContactUs:


                        return false;
                    case R.id.nav_profile:
                        openCloseDrawer(false);
                        changeActivity(HomeScreenActivity.this, MyProfileActivity.class, false, null);
                        return false;
                    case R.id.nav_Logout:
                        openCloseDrawer(false);
                        return false;


                    case R.id.nav_change_pass:
                        openCloseDrawer(false);
                        changeActivity(HomeScreenActivity.this, ChangePasswordActivity.class, false, null);
                        return false;

                }
                return false;
            }
        });
    }

    private void homeClickListeners() {
        mImgToolbarSideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCloseDrawer(true);
            }
        });
        mTxtSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(HomeScreenActivity.this, ProvidersListActivity.class, false, null);
            }
        });
        mImgToolbarCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(HomeScreenActivity.this , MyCartActivity.class , false,null);
            }
        });
    }

    void openCloseDrawer(boolean drawerStatus) {
        if (drawerStatus) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.closeDrawers();
        }
    }
}
