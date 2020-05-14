package com.myapplicationdev.android.p04_revisionnotes;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShow;
    EditText etNote;
    RadioButton rb;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShow = findViewById(R.id.buttonShowList);
        etNote = findViewById(R.id.editTextNote);
        rg = findViewById(R.id.radioGroupStars);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertNote(etNote.getText().toString(), rb.getText().toString());
                db.close();
            }
        });

           btnShow.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i = new Intent(MainActivity.this, SecondActivity.class);
                   startActivity(i);
               }
           });
    }
}
