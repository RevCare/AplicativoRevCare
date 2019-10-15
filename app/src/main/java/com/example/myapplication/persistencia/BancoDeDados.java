//package com.example.myapplication.persistencia;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//import com.example.myapplication.usuario.dominio.Usuario;
//
//public class BancoDeDados extends SQLiteOpenHelper {
//
//    private static final int VERSAO_BANCO = 1;
//    private static final String BANCO_USUARIO = "bd_usuario";
//
//    // TABELA USUARIO
//
//    private static final String TABELA_USUARIO = "tb_usuario";
//
//    private static final String COLUNA_ID12 = "id";
//    private static final String COLUNA_NOME = "nome";
//    private static final String COLUNA_NASCIMENTO = "nascimento";
//    private static final String COLUNA_TELEFONE = "telefone";
//    private static final String COLUNA_ENDERECO = "endereco";
//    private static final String COLUNA_EMAIL = "email";
//    private static final String COLUNA_CPF = "cpf";
//
//    //TABELA PROFISSIONAL
//
//    private static final String TABELA_PROFISSIONAL = "tb_profissional";
//
//    private static final String COLUNA_ID = "id";
//    private static final String COLUNA_NOME = "nome";
//    private static final String COLUNA_NASCIMENTO = "nascimento";
//    private static final String COLUNA_TELEFONE = "telefone";
//    private static final String COLUNA_ENDERECO = "endereco";
//    private static final String COLUNA_EMAIL = "email";
//    private static final String COLUNA_CPF = "cpf";
//    private static final String COLUNA_CERT = "certificacao";
//
//
//
//
//    public BancoDeDados(@Nullable Context context) {
//        super(context, BANCO_USUARIO, null, VERSAO_BANCO);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
////SEPARAR EM METODOS - N ESQUECER
//        String QUERY_USUARIO = "CREATE TABLE " + TABELA_USUARIO + "("
//                + COLUNA_ID12  + "INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUNA_NOME + " TEXT,"
//                + COLUNA_NASCIMENTO + " TEXT" + COLUNA_TELEFONE + " TEXT" + COLUNA_ENDERECO
//                + " TEXT" + COLUNA_EMAIL + " TEXT" + COLUNA_CPF + " TEXT)";
//        db.execSQL(QUERY_USUARIO);
////SEPARAR EM METODOS - N ESQUECER
//        String QUERY_PROFISSIONAL = "CREATE TABLE " + TABELA_PROFISSIONAL + "("
//                + COLUNA_ID  + "INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUNA_NOME + " TEXT,"
//                + COLUNA_NASCIMENTO + " TEXT" + COLUNA_TELEFONE + " TEXT" + COLUNA_ENDERECO
//                + " TEXT" + COLUNA_EMAIL + " TEXT" + COLUNA_CPF + " TEXT" + COLUNA_CERT + " TEXT)";
//        db.execSQL(QUERY_PROFISSIONAL);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//
//    }
//    // TESTANDO ADD provavel em UsuarioDAO
//    void addUsuario (Usuario usuario){
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//
//        values.put(COLUNA_NOME, usuario.getNome());
//        values.put(COLUNA_NASCIMENTO, usuario.getNascimento());
//        values.put(COLUNA_TELEFONE, usuario.getTelefone());
//        values.put(COLUNA_ENDERECO, usuario.getEndereco());
//        values.put(COLUNA_EMAIL, usuario.getEmail());
//        values.put(COLUNA_CPF, usuario.getCpf());
//
//    }
//}