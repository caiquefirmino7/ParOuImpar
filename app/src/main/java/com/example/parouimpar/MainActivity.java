package com.example.parouimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.parouimpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCalcular.setOnClickListener(view -> {
            String numero = binding.txtInputNumber.getText().toString();
            if(numero.isEmpty()){
                binding.txtInputNumber.setError("Informe um número");
            } else {
                calcularParOuImpar();
            }

        });
        binding.iconRefresh.setOnClickListener(view -> refreshData());

    }

    private void calcularParOuImpar(){

        int numero = Integer.parseInt(binding.txtInputNumber.getText().toString());

        if(numero % 2 == 0){
            binding.txtResult.setText("Seu número é Par!");
        } else {
            binding.txtResult.setText("Seu número é Impar!");
        }

    }

    private void refreshData(){
        binding.txtInputNumber.setText("");
        binding.txtResult.setText("");
    }

}