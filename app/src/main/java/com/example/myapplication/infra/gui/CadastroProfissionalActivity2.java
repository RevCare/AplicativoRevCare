package com.example.myapplication.infra.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.negocio.Validacao;
import com.example.myapplication.profissional.dominio.Profissional;
import com.example.myapplication.usuario.dominio.Usuario;

public class CadastroProfissionalActivity2 extends AppCompatActivity {
    private EditText nEmail;
    private EditText nTelefone;
    private EditText nSenha;
    private EditText nConfirmarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_profissional2);
        getSupportActionBar().hide();
        Button botao_finalizar_cadastro = findViewById(R.id.botaoFinalizarCadastro);
        botao_finalizar_cadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                nTelefone = findViewById(R.id.telefoneTextField);
                nEmail = findViewById(R.id.emailTextField);
                nSenha = findViewById(R.id.senhaTextField);
                nConfirmarSenha = findViewById(R.id.confirmarSenhaTextField);

                Validacao valido = new Validacao();

                if (valido.validacao2(nTelefone, nEmail, nSenha, nConfirmarSenha)) {
                    Profissional profissional = new Profissional();
                    startActivity(new Intent(CadastroProfissionalActivity2.this, ServicosAgendados.class));

                }

            }



            public void preencheObjeto(Profissional profissional) {

                profissional.setNome(nEmail.getText().toString().trim());
                profissional.setNascimento(nTelefone.getText().toString().trim());
                profissional.setEndereco(nSenha.getText().toString().trim());

            }

        });
    }
}