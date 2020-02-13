package ezooma.customer.com.ezooma.ui.controllers.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import ezooma.customer.com.ezooma.R;

import android.os.Bundle;
import android.view.View;

public class ForgotPasswordActivity extends AppCompatActivity {
    AppCompatTextView mTxtFpTitle;
    AppCompatImageView mImgToolbarBack;
    AppCompatButton mBtnForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initVariables();
        setViewsTexts();
        setViewsClicks();

    }

    private void setViewsTexts() {
        mTxtFpTitle.setText(getString(R.string.forgot_password));
    }

    private void setViewsClicks() {
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initVariables() {
        mTxtFpTitle = findViewById(R.id.txtToolbarTitle);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mBtnForgotPass = findViewById(R.id.btnForgotPass);
    }
}
