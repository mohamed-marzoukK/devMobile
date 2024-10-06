package com.example.prixvignette;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edM;
    private Spinner spT;
    private SeekBar seekP;
    private RadioGroup rdgC;
    private RadioButton rdE ,rdD ,rdG;
    private Button btnA ,btnE ,btnV;
    private ListView lstA;
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
    }

    private void initialiser() {
        edM=findViewById(R.id.edM);
        spT=findViewById(R.id.spT);
        seekP=findViewById(R.id.seekP);
        rdgC=findViewById(R.id.rdgC);
        rdE=findViewById(R.id.rdE);
        rdD=findViewById(R.id.rdD);
        rdG=findViewById(R.id.rdG);
        btnA=findViewById(R.id.btnA);
        btnE=findViewById(R.id.btnE);
        btnV=findViewById(R.id.btnV);
        lstA=findViewById(R.id.lstA);


    }
}