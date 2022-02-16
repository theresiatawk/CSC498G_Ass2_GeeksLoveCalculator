package com.lau.ass2geekslovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int lower_bound = 0;
    int upper_bound = 100;
    int random_number;
    String name, language_selected;
    TextView view_result;
    Button calculate_result, reset;
    ImageView language_icon;
    EditText full_name;
    TableLayout result_table;

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
        full_name = (EditText) findViewById(R.id.personName);
        result_table = (TableLayout) findViewById(R.id.resultTable);
        reset = (Button) findViewById(R.id.resetButton);

        full_name.setText("");
        reset.setVisibility(View.GONE);
        calculate_result.setText("Calculate Love");
        result_table.setVisibility(View.GONE);

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
        name = (String) full_name.getText().toString();

        if (name.length() == 0) {
            String message = "Error: You should fill your name";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
        else{
            // Generate a random number from 0 to 100
            Random random = new Random();
            random_number = random.nextInt(upper_bound-lower_bound) + lower_bound;

            //Displaying the text
            String result = (String) name + " your love to " +language_selected+ " language is " +random_number+ " %";
            view_result.setText(result);

            //Animating
            language_icon.setTranslationY(-1500);

            if (language_selected.equalsIgnoreCase("Python"))
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
            language_icon.animate().translationYBy(1500).rotation(3600).setDuration(1200);
            calculate_result.setText("Play Again");
            reset.setVisibility(View.VISIBLE);

            displayRecord();
        }
    }
    public void displayRecord(){
        result_table.setVisibility(View.VISIBLE);
        TableRow row1 = new TableRow(this);
        TextView user = new TextView(this);
        TextView language = new TextView(this);
        TextView score = new TextView(this);


        user.setText(name);
        language.setText(language_selected);
        score.setText(random_number + "%");

        user.setGravity(Gravity.CENTER);
        language.setGravity(Gravity.CENTER);
        score.setGravity(Gravity.CENTER);

        user.setTextSize(20);
        language.setTextSize(20);
        score.setTextSize(20);

        row1.addView(user);
        row1.addView(language);
        row1.addView(score);

        result_table.addView(row1);

    }
    public void reset (View v){
        full_name.setText("");
        view_result.setText("");
        calculate_result.setText("Calculate Love");
        reset.setVisibility(View.GONE);
        language_icon.setImageDrawable(null);
        result_table.setVisibility(View.GONE);

    }
}