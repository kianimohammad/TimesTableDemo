package com.w20.tiemstable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Integer> numbers = new ArrayList<>();

        ListView lv = findViewById(R.id.lv);
        final EditText et = findViewById(R.id.editText);
        Button btn = findViewById(R.id.button);

        final ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbers);
        lv.setAdapter(adapter);

        /* request focus for the edit text */
        et.requestFocus();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
                et.setFocusable(false);
                et.setFocusableInTouchMode(true);

                numbers.clear();
                if (et.getText().toString().isEmpty())
                    return;

//                numbers.add(Integer.parseInt(et.getText().toString()));
                for (int i=1; i<=10; i++)
                    numbers.add(i * Integer.parseInt(et.getText().toString()));
                adapter.notifyDataSetChanged();


            }
        });
    }
}
