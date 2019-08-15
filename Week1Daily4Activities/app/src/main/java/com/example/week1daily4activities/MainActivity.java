package com.example.week1daily4activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 101;
    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvStreetAddress;
    private TextView tvCity;
    private TextView tvState;
    private TextView tvZip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        tvStreetAddress = findViewById(R.id.tvStreetAddress);
        tvCity = findViewById(R.id.tvCity);
        tvState = findViewById(R.id.tvState);
        tvZip = findViewById(R.id.tvZip);
    }

    public void takeInputs(View view){
        Intent inputIntent = new Intent(this, InputActivity.class);
        startActivityForResult(inputIntent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(resultCode){
            case InputActivity.RESULT_CODE:
                Bundle resultBundle = data.getExtras();
                MailingInfo passedMailingInfo = resultBundle.getParcelable("mailingInfo");
                //MailingInfo passedMailingInfo = (MailingInfo) resultBundle.getParcelable("mailingInfo");
                tvFirstName.setText(passedMailingInfo.getFirstName());
                tvLastName.setText(passedMailingInfo.getLastName());
                tvStreetAddress.setText(passedMailingInfo.getStreetAddress());
                tvCity.setText(passedMailingInfo.getCity());
                tvState.setText(passedMailingInfo.getState());
                tvZip.setText(passedMailingInfo.getZip());
                break;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString("firstName", tvFirstName.getText().toString());
        outState.putString("lastName", tvLastName.getText().toString());
        outState.putString("streetAddress", tvStreetAddress.getText().toString());
        outState.putString("city", tvCity.getText().toString());
        outState.putString("state", tvState.getText().toString());
        outState.putString("zip", tvZip.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){
            tvFirstName.setText(savedInstanceState.getString("firstName", " "));
            tvLastName.setText(savedInstanceState.getString("lastname", " "));
            tvStreetAddress.setText(savedInstanceState.getString("streetAddress", " "));
            tvCity.setText(savedInstanceState.getString("city", " "));
            tvState.setText(savedInstanceState.getString("state", " "));
            tvZip.setText(savedInstanceState.getString("zip", " "));
        }
    }
}
