package com.example.myapplication.infra.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.profissional.dominio.Profissional;
import com.example.myapplication.usuario.dominio.Usuario;

public class CadastroProfissionalActivity2 extends AppCompatActivity {
    private EditText nEmail;
    private EditText nTelefone;
    private EditText nSenha;
    private EditText nConfirmaSenha;

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
                nConfirmaSenha = findViewById(R.id.confirmarSenhaTextField);

                boolean valido = validacao(nTelefone, nEmail, nSenha, nConfirmaSenha);
                //A VALIDAÇÃO TA DANDO ALGO ERRADO, TEM QUE AJEITAR. SE TIRAR ESSE IF E SÓ DEIXAR O START ACTIVITY FUNCIONA.
                if (valido) {
                    Profissional profissional = new Profissional();
                    startActivity(new Intent(CadastroProfissionalActivity2.this, ServicosAgendados.class));

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

            public void preencheObjeto(Profissional profissional) {

                profissional.setNome(nEmail.getText().toString().trim());
                profissional.setNascimento(nTelefone.getText().toString().trim());
                profissional.setEndereco(nSenha.getText().toString().trim());

            }

        });
    }
}