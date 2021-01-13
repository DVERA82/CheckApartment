package com.example.checkapartment;

import android.content.Intent;
import android.os.Bundle;

import com.example.checkapartment.MVPloging.ILoging;
import com.example.checkapartment.MVPloging.Presentador;
import com.example.checkapartment.databinding.ActivityLoginBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements ILoging {
    private ActivityLoginBinding binding;
    private ILoging iLoging;
    private Presentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presentador = new Presentador(iLoging);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = binding.editTextPassword.getText().toString();
                validarPassword(password);
                Toast.makeText(LoginActivity.this,mensajeLoging(),Toast.LENGTH_SHORT).show();
                if (contadorLoging()==3){
                    binding.button.setEnabled(false);
                }
                if (mensajeLoging().equals("Validada")){
                    onIntent();
                }
            }
        });

    }

    @Override
    public void validarPassword(String password) {
    presentador.validarPassword(password);


    }

    @Override
    public String mensajeLoging() {

        return presentador.mensajeLoging();
    }

    @Override
    public int contadorLoging() {

        return presentador.contadorLoging();
    }
    public void onIntent(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}