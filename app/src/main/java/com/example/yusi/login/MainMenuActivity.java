package com.example.yusi.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainMenuActivity extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        
        // Spinner element
//        Spinner spinner = (Spinner) findViewById(R.id.drawer_layout);

        // Spinner click listener
     //   spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Daftar Acara");
        categories.add("Jadwal Wawancara");
        categories.add("Form Acara");
        categories.add("POint Card");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
      //  spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void onClick(View v) {
        finish();
    }
}


