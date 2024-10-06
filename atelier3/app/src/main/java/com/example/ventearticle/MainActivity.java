package com.example.ventearticle;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private Button btnCal , btnZero;
    private EditText prix ,poids, totHt,totTtc;
    private Spinner tva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initialiser();
        ecouters();

    }

    private void ecouters() {
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remise_zero();
            }
        });
        prix.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculer();
            }
        });
        poids.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculer();
            }
        });
        tva.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculer();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void remise_zero() {

       prix.setText("0");
       poids.setText("0");
        totHt.setText("0");
        totTtc.setText("0");
        tva.setSelection(0);


    }

    private void calculer() {
        try {
            Float pr=Float.parseFloat(prix.getText().toString());
            Float po=Float.parseFloat(poids.getText().toString());
            Float t= Float.parseFloat((String) tva.getSelectedItem());
            Float ht=pr*po;
            Float ttc= ht*(100+t)/100;
            totHt.setText(ht +"");
            totTtc.setText(ttc+"");
        }catch (NumberFormatException e){
            totHt.setText(" invalid");
            totTtc.setText(" invalid");
        }




    }

    private void initialiser() {
        btnCal=findViewById(R.id.btnCal);
        btnZero=findViewById(R.id.btnZero);
        prix=findViewById(R.id.prix);
        poids=findViewById(R.id.poids);
        tva=findViewById(R.id.tva);
        totHt=findViewById(R.id.totHt);
        totTtc=findViewById(R.id.totTtc);
        prix.setText("0");
        poids.setText("0");
        totHt.setEnabled(false);
        totTtc.setEnabled(false);


    }
}