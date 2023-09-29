package com.assistant.hrms_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AssetPopUp extends AppCompatActivity {

    Spinner spinner;
    Button submit;
    String[] typeleave = {"Laptop","Mobile","Speaker","Chair","Dress"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assetpopup);

        spinner = findViewById(R.id.spinner);
        submit = findViewById(R.id.submit_button);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(AssetPopUp.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,typeleave);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                Toast.makeText(AssetPopUp.this, value, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {    }
            //        layout.setBackgroundColor(5264F9);
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AssetPopUp.this,"Application Submitted",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AssetPopUp.this,ProfilePage.class);
                startActivity(intent);
            }
        });

    }
}
