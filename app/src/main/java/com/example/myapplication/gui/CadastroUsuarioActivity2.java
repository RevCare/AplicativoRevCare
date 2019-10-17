package com.example.myapplication.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.usuario.dominio.Usuario;

public class CadastroUsuarioActivity2 extends AppCompatActivity {

    private EditText nEmail;
    private EditText nTelefone;
    private EditText nSenha;
    private EditText nConfirmaSenha;


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
                nConfirmaSenha = findViewById(R.id.confirmarSenhaTextField);

                boolean valido = validacao(nTelefone, nEmail, nSenha, nConfirmaSenha);
                if (valido) {
                    Usuario usuario = new Usuario();
                    preencheObjeto(usuario);
                    startActivity(new Intent(CadastroUsuarioActivity2.this, ServicosAgendados.class));

                }

            }

            public boolean validacao(EditText nTelefone, EditText nEmail, EditText nSenha, EditText nConfirmarSenha) {


                boolean teveCampoVazio = false;
                String txxTelefone = nTelefone.getText().toString().trim();
                String txtEmail = nEmail.getText().toString().trim();
                String txtSenha = nSenha.getText().toString().trim();
                String txtConfirmarSenha = nConfirmarSenha.getText().toString().trim();


                if (txtEmail.equals("")) {
                    nEmail.requestFocus();
                    nEmail.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (txxTelefone.equals("")) {
                    nTelefone.requestFocus();
                    nTelefone.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (txtSenha.equals("")) {
                    nSenha.requestFocus();
                    nSenha.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (txtConfirmarSenha.equals("")) {
                    nConfirmaSenha.requestFocus();
                    nConfirmaSenha.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (!teveCampoVazio) {

                    if (!(txtSenha.equals(txtConfirmarSenha))) {
                        nSenha.requestFocus();
                        nSenha.setError("As senhas devem ser iguais.");
                        nConfirmaSenha.setError("As senhas devem ser iguais.");

                    } else {
                        return true;
                    }
                }
                return false;

            }

            public void preencheObjeto(Usuario usuario) {

                usuario.setNome(nEmail.getText().toString().trim());
                usuario.setNascimento(nTelefone.getText().toString().trim());
                usuario.setEndereco(nSenha.getText().toString().trim());

            }

        });
    }
}
