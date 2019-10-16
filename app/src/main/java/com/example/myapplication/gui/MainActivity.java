package com.example.myapplication.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.servicosAgendados;

public class MainActivity extends AppCompatActivity {




    //Button botao_entrar = (Button) findViewById(R.id.botao_entrar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        //Button botao_cadastrar = findViewById(R.id.botaoCadastrar);
        Button botao_entrar = findViewById(R.id.botaoEntrar);
        Button botao_cadastrar = findViewById(R.id.botaoCadastro);



        botao_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CadastroUsuarioActivity.class));
            }

        });

        botao_entrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent tela = new Intent(MainActivity.this, servicosAgendados.class);
                startActivity(tela);

            }

        });

            }



}
