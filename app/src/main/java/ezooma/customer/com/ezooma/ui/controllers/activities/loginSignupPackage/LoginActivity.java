package ezooma.customer.com.ezooma.ui.controllers.activities.loginSignupPackage;

import androidx.appcompat.widget.AppCompatEditText;
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

public class LoginActivity extends BaseActivity {
    AppCompatTextView mTxtSignUp, mTxtTitle, mTxtForgotPassword;
    CardView mCvFacebook, mCvLogin;
    AppCompatEditText mEdtEmail, mEdtPassword;
    AppCompatImageView mImgToolbarBack;
    String mRoute;
    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBundle = getIntent().getExtras();
        if (mBundle == null)
            return;
        mRoute = (String) mBundle.getSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE);
        initVariables();
        setViewsTexts();
        setViewsClicks();

    }

    private void setViewsTexts() {
        mTxtTitle.setText(getString(R.string.login));
    }

    private void setViewsClicks() {
        mTxtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRoute.equalsIgnoreCase(AppConstants.CHOOSE_OPTIONS)) {
                 mBundle = new Bundle();
                 mBundle.putSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE,AppConstants.CHOOSE_OPTIONS);
                    changeActivity(LoginActivity.this, RegisterActivity.class, false, mBundle);
                }
                else
                    finish();
            }
        });
        mTxtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(LoginActivity.this, ForgotPasswordActivity.class, false, null);
            }
        });
        mCvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(LoginActivity.this, SetLocationActivity.class, false, null);
                /* changeActivity(LoginActivity.this, HomeScreenActivity.class, false, null);*/
            }
        });

        mCvFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        mTxtSignUp = findViewById(R.id.txtSignUp);
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mTxtForgotPassword = findViewById(R.id.txtForgetPassword);
        mCvFacebook = findViewById(R.id.btnFacebookLogin);
        mCvLogin = findViewById(R.id.cvLogin);
        mEdtEmail = findViewById(R.id.edtEmail);
        mEdtPassword = findViewById(R.id.edtPassword);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
    }
}
