package com.ethvor.repairorder;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import java.util.ArrayList;

public class RepairOrderActivity extends AppCompatActivity {

    private Spinner spinnerOrderType;
    private String selectedOrderType = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order);

        spinnerOrderType = findViewById(R.id.spinnerOrderType);
        ArrayList<String> orderTypesList = new ArrayList<>();
        orderTypesList.add("Select Order Type");
        orderTypesList.add("Type 1");
        orderTypesList.add("Type 2");
        orderTypesList.add("Type 3");
        orderTypesList.add("Type 4");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, orderTypesList); //after some google search i think this is the only way to give the spinner the array
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrderType.setAdapter(adapter);


        //Spinners dont use onclicklistener, they use onitemselectedlistener. had to google this
        spinnerOrderType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedOrderType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}