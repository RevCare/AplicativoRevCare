package com.example.myapplication.infra.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.usuario.dominio.Usuario;
import com.example.myapplication.negocio.Validacao;

public class CadastroProfissionalActivity extends AppCompatActivity {

    private EditText nNome;
    private EditText nDataNascimento;
    private EditText nEndereco;
    private EditText nCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_profissional);
        getSupportActionBar().hide();
        Button botao_continuar_cadastro = findViewById(R.id.botaoContinuarCadastro);
        botao_continuar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nNome = findViewById(R.id.nomeTextField);
                nDataNascimento = findViewById(R.id.dataNascimentoTextField);
                nCpf = findViewById(R.id.cpfTextField);
                nEndereco = findViewById(R.id.enderecoTextField);
                Validacao valido = new Validacao();

                if (valido.validacao(nNome, nDataNascimento, nCpf, nEndereco)) {
                    startActivity(new Intent(CadastroProfissionalActivity.this, CadastroProfissionalActivity2.class));
                }


            }


            public void preencheObjeto(Usuario usuario){

                usuario.setNome(nNome.getText().toString().trim());
                usuario.setNascimento(nDataNascimento.getText().toString().trim());
                usuario.setEndereco(nEndereco.getText().toString().trim());
                usuario.setCpf(nCpf.getText().toString().trim());

            }
        });




    }




}

