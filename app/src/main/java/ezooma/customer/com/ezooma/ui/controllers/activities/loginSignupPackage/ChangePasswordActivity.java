package ezooma.customer.com.ezooma.ui.controllers.activities.loginSignupPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.utilities.abstracts.BaseActivity;

import android.os.Bundle;
import android.view.View;

public class ChangePasswordActivity extends BaseActivity {
    AppCompatTextView mTxtTitle;
    AppCompatImageView mImgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initVariables();
        setViewsTexts();
        setViewsClicks();

    }

    private void setViewsTexts() {
        mTxtTitle.setText(getString(R.string.change_password));
    }

    private void setViewsClicks() {
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initVariables() {
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mImgBack = findViewById(R.id.imgToolbarBack);
    }
}
