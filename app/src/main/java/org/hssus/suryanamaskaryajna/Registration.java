package org.hssus.suryanamaskaryajna;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

public class Registration extends BaseActivity {

    ImageView backImage;
    Button btnRegister;
    Spinner ageSpinner,countrySpinner,stateSpinner,shakhaSpinner;
    String gender="male";
    Switch shakhaSwitch;
    String startingSource="login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Bundle b = getIntent().getExtras();

        if(b != null)
            startingSource = b.getString("starting_location");

        initializeUI();
        addEvents();
        addAdapters();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked;
        checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.malebtn:
                if (checked)
                    gender="male";
                    break;
            case R.id.femalebtn:
                if (checked)
                    gender="female";
                    break;
        }
    }

    private void initializeUI(){
        this.backImage=(ImageView)findViewById(R.id.userSettings);
        this.backImage.setImageDrawable(getResources().getDrawable(R.drawable.back,getTheme()));
        ageSpinner=(Spinner)findViewById(R.id.ageSpinner);
        countrySpinner=(Spinner)findViewById(R.id.countrySpinner);
        stateSpinner=(Spinner)findViewById(R.id.stateSpinner);
        shakhaSpinner=(Spinner)findViewById(R.id.shakhaSpinner);
        btnRegister=(Button)findViewById(R.id.btnRegister);
        shakhaSwitch=(Switch)findViewById(R.id.shakhaSwitch);

        if(!startingSource.equals("login"))
            btnRegister.setText("Add Family Member");
        else
            btnRegister.setText("Register");
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
                displayToastMessage(ageSpinner.getSelectedItem().toString()+" "+countrySpinner.getSelectedItem().toString()+" "+gender+" "+shakhaSwitch.isChecked());
            }
        });
    }

    private void addAdapters(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.country_names, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter1);
    }
}
