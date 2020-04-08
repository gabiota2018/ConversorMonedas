package com.example.conversormonedas;

//import androidx.appcompat.app.AppCompatActivity;
import  androidx.appcompat.app.AppCompatActivity;
import  androidx.lifecycle.Observer;
import  androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import  androidx.appcompat.app.AppCompatActivity;
import  androidx.lifecycle.Observer;
import  androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {
    private RadioButton rdEurosDolares;
    private RadioButton rdDolaresEuros;
    private EditText etDolares;
    private EditText etEuros;
    private TextView tvResultado;
    private Button btnConvertir;
    private MainViewModel mv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarVista();

        mv=ViewModelProviders.of(this).get(MainViewModel.class);
        mv.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvResultado.setText(s);
            }
        });
    }
    private void iniciarVista(){
        rdEurosDolares=findViewById(R.id.rdEuroDolar);//
        rdDolaresEuros=findViewById(R.id.rdDolarEuro);//
        etDolares=findViewById(R.id.etDolares);//
        etEuros=findViewById(R.id.etEuros);//
        tvResultado=findViewById(R.id.tvResultado);//
        btnConvertir=findViewById(R.id.btnConvertir);


    }

    public void habilitarCambio(View v){
        mv.hacerCalculo(etDolares.getText().toString(),etEuros.getText().toString());
    }
}
