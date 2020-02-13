package ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.utilities.abstracts.BaseActivity;

import android.os.Bundle;
import android.view.View;

public class SetLocationActivity extends BaseActivity {
    AppCompatButton mBtnAskLocation;
AppCompatImageView mImgToolbarBack ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_location);
        initVariables();

    }

    private void initVariables() {
        /*mImgToolbarBack=findViewById(R.id.imgToolbarBack);*/
        mBtnAskLocation = findViewById(R.id.btnAskLocation);
        /*mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
        mBtnAskLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(SetLocationActivity.this, ChooseLocationActivity.class, false, null);
            }
        });
    }
}
