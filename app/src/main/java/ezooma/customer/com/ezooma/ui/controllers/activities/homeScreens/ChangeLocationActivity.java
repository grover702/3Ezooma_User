package ezooma.customer.com.ezooma.ui.controllers.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import ezooma.customer.com.ezooma.R;

import android.os.Bundle;
import android.view.View;

public class ChangeLocationActivity extends AppCompatActivity {
    AppCompatTextView mTxtTitle;
AppCompatImageView mImgToolbarBack ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_location);
        initVariables();
        setViewClicks();
    }

    private void setViewClicks() {
    mImgToolbarBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    }

    private void initVariables() {
        mTxtTitle = findViewById(R.id.txtToolbarTitle);
        mImgToolbarBack=findViewById(R.id.imgToolbarBack);
        mTxtTitle.setText("Edit Address");
    }
}
