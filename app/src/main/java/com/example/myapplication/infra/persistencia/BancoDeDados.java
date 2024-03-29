package com.example.myapplication.infra.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BancoDeDados extends SQLiteOpenHelper {

    private static final String DB_NAME = "revcare.bd";
    private static final int DB_VERSION = 1;


    public static final String TABELA_USUARIO = "Tabela_Usuario";
    public static final String COL_ID_USUARIO = "id";
    public static final String COL_NOME_USUARIO = "nome";
    public static final String COL_NASCIMENTO_USUARIO = "nascimento";
    public static final String COL_TELEFONE_USUARIO = "telefone";
    public static final String COL_EMAIL_USUARIO = "email";
    public static final String COL_CPF_USUARIO = "cpf";
    public static final String COL_SENHA_USUARIO = "senha";

    public static final String TABELA_PROFISSIONAL = "Tabela_Profissional";
    public static final String COL_ID_PROFISSIONAL = "id";
    public static final String COL_NOME_PROFISSIONAL = "nome";
    public static final String COL_NASCIMENTO_PROFISSIONAL = "nascimento";
    public static final String COL_TELEFONE_PROFISSIONAL = "telefone";
    public static final String COL_EMAIL_PROFISSIONAL = "email";
    public static final String COL_CPF_PROFISSIONAL = "cpf";
    public static final String COL_REGULAMENTACAO_PROFISSIONAL= "regulamentacao";
    public static final String COL_SENHA_PROFISSIONAL = "senha";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %1$s ";
    private static final String SQL_INTEGER_AUTOINCREMENT = "  %2$s INTEGER PRIMARY KEY AUTOINCREMENT, ";


    public BancoDeDados(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableUsuario(db);
        createTableProfissional(db);
    }
    private void createTableUsuario(SQLiteDatabase db) {
        String sqlTbUsuario = SQL_CREATE_TABLE + "( " +
                SQL_INTEGER_AUTOINCREMENT +
                "  %3$s TEXT NOT NULL, " +
                "  %4$s TEXT NOT NULL, " +
                " %5$s TEXT NOT NULL, " +
                " %6$s TEXT NOT NULL, " +
                " %7$s TEXT NOT NULL, " +
                " %8$s TEXT NOT NULL, " +

                ");";
        sqlTbUsuario = String.format(sqlTbUsuario,
                TABELA_USUARIO, COL_ID_USUARIO, COL_NOME_USUARIO,
                COL_NASCIMENTO_USUARIO, COL_TELEFONE_USUARIO,
                COL_EMAIL_USUARIO, COL_CPF_USUARIO, COL_SENHA_USUARIO);
        db.execSQL(sqlTbUsuario);
    }
    private void createTableProfissional(SQLiteDatabase db) {
        String sqlTbProfissional = SQL_CREATE_TABLE + "( " +
                SQL_INTEGER_AUTOINCREMENT +
                "  %3$s TEXT NOT NULL, " +
                "  %4$s TEXT NOT NULL, " +
                " %5$s TEXT NOT NULL, " +
                " %6$s TEXT NOT NULL, " +
                " %7$s TEXT NOT NULL, " +
                " %8$s TEXT NOT NULL, " +
                " %9$s TEXT NOT NULL, " +

                ");";
        sqlTbProfissional= String.format(sqlTbProfissional,
                TABELA_PROFISSIONAL, COL_ID_PROFISSIONAL, COL_NOME_PROFISSIONAL,
                COL_NASCIMENTO_PROFISSIONAL, COL_TELEFONE_PROFISSIONAL,
                COL_EMAIL_PROFISSIONAL, COL_CPF_PROFISSIONAL, COL_REGULAMENTACAO_PROFISSIONAL,COL_SENHA_PROFISSIONAL);
        db.execSQL(sqlTbProfissional);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_PROFISSIONAL);
        onCreate(db);

    }
}
