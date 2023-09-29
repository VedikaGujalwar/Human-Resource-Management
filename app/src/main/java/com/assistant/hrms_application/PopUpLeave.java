package com.assistant.hrms_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PopUpLeave extends AppCompatActivity {
    RelativeLayout layout;
    Spinner spinner;
    Button submit;
    String[] typeleave = {"PL", "CL", "EL"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupleave);

        layout = findViewById(R.id.layout);
        spinner = findViewById(R.id.spinner);
        submit = findViewById(R.id.submit);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(PopUpLeave.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, typeleave);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                Toast.makeText(PopUpLeave.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

//        layout.setBackgroundColor(5264F9);

        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopUpLeave.this,"Application Submitted",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PopUpLeave.this,ProfilePage.class);
                startActivity(intent);
            }
        });
    }

}