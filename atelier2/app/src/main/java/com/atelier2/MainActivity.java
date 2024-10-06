package com.atelier2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
     private Button btnCF , btnFC;
     private EditText edC ,edF;
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
        ecouteurs();
    }

    private void ecouteurs() {
        btnCF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                convertirDC_DF();
            }

        });
        btnFC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                convertirDF_DC();
            }

        });
    }

    private void convertirDC_DF() {
        try {
            float c= Float.parseFloat(edC.getText().toString());
            float f=(c+9)/5+32;
            edF.setText(f+"");
            colorer();
        }catch (NumberFormatException e){
            edF.setText("Tempurature invalid");
        }
    }

    private void convertirDF_DC() {

        try {
            float f= Float.parseFloat(edF.getText().toString());
            float c=(f-32)*5/9;
            edC.setText(c+"");
            colorer();
        }catch (NumberFormatException e){
            edC.setText("Tempurature invalid");
        }

    }

    private void colorer() {
        float c= Float.parseFloat(edC.getText().toString());
        if (c<=0){
            edC.setTextColor(Color.WHITE);
            edC.setBackgroundColor(Color.BLACK);
            edF.setTextColor(Color.WHITE);
            edF.setBackgroundColor(Color.BLACK);
        } else if (c<=20) {
            edC.setTextColor(Color.BLUE);
            edC.setBackgroundColor(Color.BLACK);
            edF.setTextColor(Color.BLUE);
            edF.setBackgroundColor(Color.BLACK);
            
        } else if (c<=30) {
            edC.setTextColor(Color.YELLOW);
            edC.setBackgroundColor(Color.GREEN);
            edF.setTextColor(Color.YELLOW);
            edF.setBackgroundColor(Color.GREEN);

        } else {
            edC.setTextColor(Color.RED);
            edC.setBackgroundColor(Color.GRAY);
            edF.setTextColor(Color.RED);
            edF.setBackgroundColor(Color.GRAY);
        }

    }

    private void initialiser() {
        edC=findViewById(R.id.edC);
        edF=findViewById(R.id.edF);
        btnCF=findViewById(R.id.btnCF);
        btnFC=findViewById(R.id.btnFC);
    }
}