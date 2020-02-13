package ezooma.customer.com.ezooma.ui.controllers.activities.loginSignupPackage;

import android.os.Handler;

import android.os.Bundle;

import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.utilities.abstracts.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                changeActivity(SplashActivity.this , ChooseLoginActivity.class,false,null);

            }
        }, 3000);
    }
}
