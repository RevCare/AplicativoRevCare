package com.example.myapplication.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private EditText lCpf;
    private EditText lSenha;

    //Button botao_entrar = (Button) findViewById(R.id.botao_entrar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

         lCpf = findViewById(R.id.caixatxtEmailLogin);
         lSenha = findViewById(R.id.caixatxtSenhaLogin);


        final Switch aSwitch = findViewById(R.id.chaveClienteProfissonal);

        //Button botao_cadastrar = findViewById(R.id.botaoCadastrar);
        Button botao_entrar = findViewById(R.id.botaoEntrar);
        Button botao_cadastrar = findViewById(R.id.botaoCadastro);



        botao_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (aSwitch.isChecked()) {
                    startActivity(new Intent(MainActivity.this, CadastroProfissionalActivity.class));

                }
                else{
                    startActivity(new Intent(MainActivity.this, CadastroUsuarioActivity.class));

                }

            }
        });

        botao_entrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent tela = new Intent(MainActivity.this, ServicosAgendados.class);
                startActivity(tela);

            }

        });

            }



}
