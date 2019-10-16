package com.example.myapplication.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.negocio.UsuarioService;
import com.example.myapplication.servicosAgendados;
import com.example.myapplication.usuario.dominio.Usuario;


public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText nNome;
    private EditText nDataNascimento;
    private EditText nTelefone;
    private EditText nEndereco;
    private EditText nEmail;
    private EditText nCpf;
    private EditText nSenha;
    private EditText nConfirmaSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro_usuario);
        Button botao_finalizar_cadastro = findViewById(R.id.botaoFinalizarCadastro);
        botao_finalizar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nNome = findViewById(R.id.nomeTextField);
                nDataNascimento = findViewById(R.id.dataNascimentoTextField);
                nCpf = findViewById(R.id.cpfTextField);
                nTelefone = findViewById(R.id.telefoneTextField);
                nEndereco = findViewById(R.id.enderecoTextField);
                nEmail = findViewById(R.id.emailTextField);
                nSenha = findViewById(R.id.senhaTextField);
                nConfirmaSenha = findViewById(R.id.confirmaSenhaTextField);

                //nCpf.setInputType(InputType.TYPE_CLASS_NUMBER);

                boolean valido = validacao(nNome, nDataNascimento, nCpf, nTelefone, nEndereco, nEmail, nSenha, nConfirmaSenha);
                if (valido){
                Usuario usuario = new Usuario();
                preencheObjeto(usuario);

            Intent telaPrincipal = new Intent(CadastroUsuarioActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                }
            }







            public boolean validacao(EditText nNome,EditText nDataNascimento,EditText nCpf,EditText nTelefone,EditText nEndereco,EditText nEmail,EditText nSenha,EditText nConfirmaSenha) {


                boolean teveCampoVazio = false;
                String txtNome = nNome.getText().toString().trim();
                String txtDataNascimento= nDataNascimento.getText().toString().trim();
                String txtCpf= nCpf.getText().toString().trim();
                String txtTelefone= nTelefone.getText().toString().trim();
                String txtEndereco= nEndereco.getText().toString().trim();
                String txtEmail= nEmail.getText().toString().trim();
                String txtSenha = nSenha.getText().toString().trim();
                String txtConfirmaSenha = nConfirmaSenha.getText().toString().trim();

                if (txtNome.equals("")) {
                    nNome.requestFocus();
                    nNome.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (txtDataNascimento.equals("")) {
                    nDataNascimento.requestFocus();
                    nDataNascimento.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (txtCpf.equals("")){
                    nCpf.requestFocus();
                    nCpf.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if ((nCpf.equals("00000000000") ||
                        nCpf.equals("11111111111") ||
                        nCpf.equals("22222222222") || nCpf.equals("33333333333") ||
                        nCpf.equals("44444444444") || nCpf.equals("55555555555") ||
                        nCpf.equals("66666666666") || nCpf.equals("77777777777") ||
                        nCpf.equals("88888888888") || nCpf.equals("99999999999") ||
                        (nCpf.length() != 11))){
                    nCpf.requestFocus();
                    nCpf.setError("CPF inválido.");
                }
                if (txtTelefone.equals("")) {
                    nTelefone.requestFocus();
                    nTelefone.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (txtEndereco.equals("")) {
                    nEndereco.requestFocus();
                    nEndereco.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (txtEmail.equals("")) {
                    nEmail.requestFocus();
                    nEmail.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (txtSenha.equals("")) {
                    nSenha.requestFocus();
                    nSenha.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }
                if (txtConfirmaSenha.equals("")) {
                    nConfirmaSenha.requestFocus();
                    nConfirmaSenha.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }

                if (!teveCampoVazio){

                    if (!(txtSenha.equals(txtConfirmaSenha))){
                        nSenha.requestFocus();
                        nSenha.setError("As senhas devem ser iguais.");
                        nConfirmaSenha.setError("As senhas devem ser iguais.");

                    }else{
                        return true;
                    }
                }


                return false;
            }


            public void preencheObjeto(Usuario usuario){

                usuario.setNome(nNome.getText().toString().trim());
                usuario.setNascimento(nDataNascimento.getText().toString().trim());
                usuario.setTelefone(nTelefone.getText().toString().trim());
                usuario.setEndereco(nEndereco.getText().toString().trim());
                usuario.setEmail(nEmail.getText().toString().trim());
                usuario.setCpf(nCpf.getText().toString().trim());
                usuario.setSenha(nSenha.getText().toString().trim());
                usuario.setConfirmaSenha(nConfirmaSenha.getText().toString().trim());

            }
        });




    }




}


