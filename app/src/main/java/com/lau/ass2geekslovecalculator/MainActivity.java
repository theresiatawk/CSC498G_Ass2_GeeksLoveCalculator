package com.lau.ass2geekslovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int lower_bound = 0;
    int upper_bound = 100;
    TextView view_result;
    Button calculate_result;
    String language_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencing our spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Fills our spinner with the array we just created in strings.xml file
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Connecting the spinner with the adapter
        spinner.setAdapter(adapter);
        // To be able to click on one of the item
        spinner.setOnItemSelectedListener(this);

        view_result = (TextView) findViewById(R.id.textResult);
        calculate_result = (Button) findViewById(R.id.calculateButton);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        language_selected = (String) text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void calculate(View view){
        Random random = new Random();
        int random_number = random.nextInt(upper_bound-lower_bound) + lower_bound;
        String result = "Your love to " +language_selected+ " language is " +random_number+ " %";
        view_result.setText(result);
        calculate_result.setVisibility(View.GONE);

    }
}