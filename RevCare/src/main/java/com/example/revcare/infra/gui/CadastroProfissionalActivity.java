package com.example.revcare.infra.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.revcare.R;
import com.example.revcare.usuario.dominio.Usuario;

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

                //nCpf.setInputType(InputType.TYPE_CLASS_NUMBER);

                boolean valido = validacao(nNome, nDataNascimento, nCpf, nEndereco);
                if (valido) {
                    startActivity(new Intent(CadastroProfissionalActivity.this, CadastroProfissionalActivity2.class));
                }


            }







            public boolean validacao(EditText nNome, EditText nDataNascimento, EditText nCpf, EditText nEndereco) {


                boolean teveCampoVazio = false;
                String txtNome = nNome.getText().toString().trim();
                String txtDataNascimento= nDataNascimento.getText().toString().trim();
                String txtCpf= nCpf.getText().toString().trim();
                String txtEndereco= nEndereco.getText().toString().trim();

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
                if (txtEndereco.equals("")) {
                    nEndereco.requestFocus();
                    nEndereco.setError("Preencha o Campo.");
                    teveCampoVazio = true;

                }


                if (!teveCampoVazio){
                    return true;
                }


                return false;
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

