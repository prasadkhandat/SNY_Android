package org.hssus.suryanamaskaryajna;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import org.hssus.suryanamaskaryajna.adapters.MainMenusAdapter;

public class SuryaNamaskarHelp extends BaseActivity {

    RecyclerView sn_help_menus;
    private MainMenusAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView backImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surya_namaskar_help);
        initializeUIelements();
        addEvents();
        addAdapters();
    }

    void initializeUIelements(){
        sn_help_menus=(RecyclerView) findViewById(R.id.sn_help_menus);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.backImage=(ImageView)findViewById(R.id.userSettings);
        this.backImage.setImageDrawable(getResources().getDrawable(R.drawable.back,getTheme()));
        this.sn_help_menus.setLayoutManager(mLayoutManager);
    }

    private void addEvents(){
        this.backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });

    }

    private void addAdapters(){
        this.mAdapter = new MainMenusAdapter(getResources().getStringArray(R.array.sn_help_menu),this);
        this.sn_help_menus.setAdapter(mAdapter);

    }
}
