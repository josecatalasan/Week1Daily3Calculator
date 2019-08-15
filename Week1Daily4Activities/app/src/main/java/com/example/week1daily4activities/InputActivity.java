package com.example.week1daily4activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    public static final int RESULT_CODE = 201;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etStreetAddress;
    private EditText etCity;
    private EditText etState;
    private EditText etZip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etStreetAddress = findViewById(R.id.etStreetAddress);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        etZip = findViewById(R.id.etZip);
    }

    public void sendInputs(View view){
        switch(view.getId()){
            case R.id.btnSendInputs:
                final String firstNameInput = etFirstName.getText().toString();
                final String lastNameInput = etLastName.getText().toString();
                final String streetAddressInput = etStreetAddress.getText().toString();
                final String cityInput = etCity.getText().toString();
                final String stateInput = etState.getText().toString();
                final String zipInput = etZip.getText().toString();
                final MailingInfo mailingInfo = new MailingInfo(firstNameInput, lastNameInput, streetAddressInput, cityInput, stateInput, zipInput);
                Intent mailingIntent = new Intent(this, InputActivity.class);
                Bundle mailingBundle = new Bundle();
                mailingBundle.putParcelable("mailingInfo", mailingInfo);
                mailingIntent.putExtras(mailingBundle);
                //send result back
                setResult(RESULT_CODE, mailingIntent);
                finish();
                break;
        }
    }
}
