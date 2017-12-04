package org.hssus.suryanamaskaryajna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.hssus.suryanamaskaryajna.adapters.SNCountByPersonAdapter;
import org.hssus.suryanamaskaryajna.adapters.SuryaNamaskarMantraAdaptor;

public class SNCountsPerPerson extends BaseActivity {

    RecyclerView personNameRV;
    ImageView btnBack;
    RecyclerView.LayoutManager mLayoutManager;
    SNCountByPersonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sncounts_per_person);
        initUiElements();
        addAdaptor();
        addEvents();
    }

    private void initUiElements(){
        this.personNameRV = (RecyclerView) findViewById(R.id.personNameRV);
        this.btnBack=(ImageView) findViewById(R.id.userSettings);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.btnBack.setImageDrawable(getResources().getDrawable(R.drawable.back,getTheme()));
        this.personNameRV.setLayoutManager(mLayoutManager);
    }

    private void addAdaptor(){
        this.mAdapter = new SNCountByPersonAdapter(getResources().getStringArray(R.array.person_name),this);
        this.personNameRV.setAdapter(mAdapter);
    }

    private void addEvents(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });
    }
}
