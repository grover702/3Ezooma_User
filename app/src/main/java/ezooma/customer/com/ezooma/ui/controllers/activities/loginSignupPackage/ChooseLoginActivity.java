package ezooma.customer.com.ezooma.ui.controllers.activities.loginSignupPackage;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.utilities.AppConstants;
import ezooma.customer.com.ezooma.utilities.GlobalBundleKeys;
import ezooma.customer.com.ezooma.utilities.abstracts.BaseActivity;

import android.os.Bundle;
import android.view.View;

public class ChooseLoginActivity extends BaseActivity {
    CardView mCvSignUpEmail, mBtnSignUpFacebook;
    AppCompatTextView mTxtAlreadyAccount;
    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login);
        initVariables();
        setViewsClick();
    }

    private void initVariables() {
        mCvSignUpEmail = findViewById(R.id.cvSignUpEmail);
        mBtnSignUpFacebook = findViewById(R.id.btnSignUpFacebook);
        mTxtAlreadyAccount = findViewById(R.id.txtAlreadyAccount);
    }

    private void setViewsClick() {
        mCvSignUpEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(ChooseLoginActivity.this, RegisterActivity.class, false, null);
                /* changeActivity(ChooseLoginActivity.this, SetLocationActivity.class, false, null);*/
            }
        });
        mBtnSignUpFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* changeActivity(ChooseLoginActivity.this, OrderStatusActivity.class, false, null);*/
            }
        });
        mTxtAlreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBundle = new Bundle();
                mBundle.putSerializable(GlobalBundleKeys.BK_LOGIN_ROUTE , AppConstants.CHOOSE_OPTIONS);
                changeActivity(ChooseLoginActivity.this, LoginActivity.class, false, mBundle);
            }
        });
    }
}
