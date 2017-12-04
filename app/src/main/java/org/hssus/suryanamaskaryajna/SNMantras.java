package org.hssus.suryanamaskaryajna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import org.hssus.suryanamaskaryajna.adapters.MainMenusAdapter;
import org.hssus.suryanamaskaryajna.adapters.SuryaNamaskarMantraAdaptor;

public class SNMantras extends BaseActivity {



    private RecyclerView recyclerView;
    private SuryaNamaskarMantraAdaptor mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snmantras);
        initUiElements();
        addAdaptor();
        addEvents();
    }


    private void initUiElements(){
        this.recyclerView = (RecyclerView) findViewById(R.id.sn_mantras);
        this.btnBack=(ImageView) findViewById(R.id.userSettings);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.btnBack.setImageDrawable(getResources().getDrawable(R.drawable.back,getTheme()));
        this.recyclerView.setLayoutManager(mLayoutManager);

    }

    private void addEvents(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });
    }

    private void addAdaptor(){
        this.mAdapter = new SuryaNamaskarMantraAdaptor(getResources().getStringArray(R.array.sn_mantra),getResources().getStringArray(R.array.sn_mantra_meaning),this);
        this.recyclerView.setAdapter(mAdapter);
    }
}
