package org.hssus.suryanamaskaryajna;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends BaseActivity {

    ImageView backImage;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeUI();
        addEvents();
    }

    private void initializeUI(){
        this.backImage=(ImageView)findViewById(R.id.userSettings);
        this.backImage.setImageDrawable(getResources().getDrawable(R.drawable.back,getTheme()));
        this.btnRegister=(Button)findViewById(R.id.btnRegister);

    }

    private void addEvents(){
        this.backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();

            }
        });

        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,Registration.class);
                Bundle b = new Bundle();
                b.putString("starting_location", "login"); //Your id
                i.putExtras(b); //Put your id to your next Intent
                startActivity(i, ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this).toBundle());
            }
        });
    }
}
