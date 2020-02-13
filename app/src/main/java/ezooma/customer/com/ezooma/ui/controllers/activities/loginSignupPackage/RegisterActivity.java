package ezooma.customer.com.ezooma.ui.controllers.activities.loginSignupPackage;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens.SetLocationActivity;
import ezooma.customer.com.ezooma.utilities.AppConstants;
import ezooma.customer.com.ezooma.utilities.GlobalBundleKeys;
import ezooma.customer.com.ezooma.utilities.abstracts.BaseActivity;

import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends BaseActivity {
    AppCompatTextView mTxtLogin, mTxtToolBarTitle;
    CardView mCvRegister;
    AppCompatImageView mImgToolbarBack;
    Bundle mBundle;
    String mRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mRoute = (String) mBundle.getSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE);
        }
        initVariables();
        setViewsTexts();
        setViewsClicks();

    }

    private void setViewsTexts() {
        mTxtToolBarTitle.setText(getString(R.string.register));
    }

    private void setViewsClicks() {
        mTxtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRoute==null) {
                    mBundle = new Bundle();
                    mBundle.putSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE, AppConstants.REGISTER);
                    changeActivity(RegisterActivity.this, LoginActivity.class, false, mBundle);
                }
                else{
                    finish();
                }
            }
        });
        mCvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(RegisterActivity.this, SetLocationActivity.class, false, null);
                /*changeActivity(RegisterActivity.this, HomeScreenActivity.class, false, null);*/
            }
        });
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initVariables() {
        mTxtLogin = findViewById(R.id.txtAlreadyAccount);
        mTxtToolBarTitle = findViewById(R.id.txtToolbarTitle);
        mCvRegister = findViewById(R.id.cvRegister);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
    }
}
