package ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import ezooma.customer.com.ezooma.R;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MyProfileActivity extends AppCompatActivity {
    AppCompatImageView mImgToolbarBack;
    LinearLayout mLlFirstName, mLlLastName, mLlEditText;
    AppCompatImageView mImgEditProfile;
    RelativeLayout mRlEditImage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        initVariables();
        mImgEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLlEditText.getVisibility() == View.VISIBLE) {
                    mImgEditProfile.setImageResource(R.drawable.edit);
                    mLlFirstName.setVisibility(View.VISIBLE);
                    mLlLastName.setVisibility(View.VISIBLE);
                    mRlEditImage.setVisibility(View.GONE);
                    mLlEditText.setVisibility(View.GONE);
                } else {
                    mImgEditProfile.setImageResource(R.drawable.ic_done);
                    mLlFirstName.setVisibility(View.GONE);
                    mLlLastName.setVisibility(View.GONE);
                    mRlEditImage.setVisibility(View.VISIBLE);
                    mLlEditText.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void initVariables() {
        mRlEditImage = findViewById(R.id.rlEditImage);
        mImgToolbarBack = findViewById(R.id.imgToolbarBack);
        mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mImgEditProfile = findViewById(R.id.imgEditProfile);
        mLlFirstName = findViewById(R.id.lLFirstName);
        mLlLastName = findViewById(R.id.lLLastName);
        mLlEditText = findViewById(R.id.lLEditText);
    }
}
