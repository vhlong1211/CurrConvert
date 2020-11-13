package com.example.currconvert;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    private EditText from;
    private TextView to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        from = (EditText) findViewById(R.id.InputEditText);
        to = (TextView) findViewById(R.id.OutputTextView);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list1 = new ArrayList<String>();
        list1.add("VND");
        list1.add("AUD");
        list1.add("CAD");
        list1.add("EUR");
        list1.add("INR");
        list1.add("JPY");
        list1.add("USD");
        list1.add("KRW");
        list1.add("SGD");
        list1.add("THB");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);


        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list2 = new ArrayList<String>();
        list2.add("VND");
        list2.add("AUD");
        list2.add("CAD");
        list2.add("EUR");
        list2.add("INR");
        list2.add("JPY");
        list2.add("USD");
        list2.add("KRW");
        list2.add("SGD");
        list2.add("THB");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
    }

    public void onClick(View v) {

        int index1 = spinner1.getSelectedItemPosition();
        int index2 = spinner2.getSelectedItemPosition();
        float value = Float.parseFloat(from.getText().toString());

        /* you have 8 units to convert from and to.
         * that means 8*8 = 64 cases!
         * to minimize work we convert from any selected unit to Centimeter
         * then we convert from Centimeter to the desired unit.
         */

        // ratios from google convertor
        float ratio[] = {1.0f, 0.000059f,0.000057f, 0.000037f, 0.0032f, 0.0045f, 0.000043f, 0.048f,0.000058f,0.0013f};
        float result = value / ratio[index1] * ratio[index2];
        to.setText(result + "");
    }
}