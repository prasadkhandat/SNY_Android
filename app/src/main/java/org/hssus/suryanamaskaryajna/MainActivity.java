package org.hssus.suryanamaskaryajna;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import org.hssus.suryanamaskaryajna.adapters.MainMenusAdapter;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private MainMenusAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView titleUserIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        initUiElements();
        addAdaptor();
        addEvents();
    }

    private void initUiElements(){
        this.recyclerView = (RecyclerView) findViewById(R.id.main_menus);
        this.titleUserIcon=(ImageView) findViewById(R.id.userSettings);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.titleUserIcon.setImageDrawable(getResources().getDrawable(R.drawable.usericon,getTheme()));
        this.recyclerView.setLayoutManager(mLayoutManager);

    }

    private void addEvents(){
        this.titleUserIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayToastMessage("Clicked on user button");
                Intent i =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i, ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
    }

    private void addAdaptor(){
        this.mAdapter = new MainMenusAdapter(getResources().getStringArray(R.array.menu_names),this);
        this.recyclerView.setAdapter(mAdapter);
    }
}
