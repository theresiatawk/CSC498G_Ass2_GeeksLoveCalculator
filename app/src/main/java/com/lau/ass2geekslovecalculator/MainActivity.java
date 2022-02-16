package com.lau.ass2geekslovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int lower_bound = 0;
    int upper_bound = 100;
    TextView view_result;
    Button calculate_result;
    String language_selected;
    ImageView language_icon;

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
        language_icon = (ImageView) findViewById(R.id.languageIcon);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        language_selected = (String) text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Enter Something",Toast.LENGTH_LONG).show();
    }
    public void calculate(View view){
        Random random = new Random();
        int random_number = random.nextInt(upper_bound-lower_bound) + lower_bound;
        String result = "Your love to " +language_selected+ " language is " +random_number+ " %";
        view_result.setText(result);
        if (language_selected.equalsIgnoreCase( "Python"))
            language_icon.setImageResource(R.drawable.python);
        else if (language_selected.equalsIgnoreCase( "Java"))
            language_icon.setImageResource(R.drawable.java);
        else if (language_selected.equalsIgnoreCase( "Kotlin"))
            language_icon.setImageResource(R.drawable.kotlin);
        else if (language_selected.equalsIgnoreCase( "C"))
            language_icon.setImageResource(R.drawable.c);
        else if (language_selected.equalsIgnoreCase( "C++"))
            language_icon.setImageResource(R.drawable.cplusplus);
        else if (language_selected.equalsIgnoreCase( "PHP"))
            language_icon.setImageResource(R.drawable.php);
        else if (language_selected.equalsIgnoreCase( "HTML"))
            language_icon.setImageResource(R.drawable.html);
        else{
            language_icon.setImageResource(R.drawable.html);
        }
    }
}