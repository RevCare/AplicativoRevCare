package com.example.myapplication.infra.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.negocio.Validacao;
import com.example.myapplication.usuario.dominio.Usuario;

public class CadastroUsuarioActivity2 extends AppCompatActivity {

    private EditText nEmail;
    private EditText nTelefone;
    private EditText nSenha;
    private EditText nConfirmarSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro_usuario_2);
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
                    Usuario usuario = new Usuario();
                    preencheObjeto(usuario);
                    startActivity(new Intent(CadastroUsuarioActivity2.this, ServicosAgendados.class));

                }

            }


            public void preencheObjeto(Usuario usuario) {

                usuario.setNome(nEmail.getText().toString().trim());
                usuario.setNascimento(nTelefone.getText().toString().trim());
                usuario.setEndereco(nSenha.getText().toString().trim());

            }

        });
    }
}
