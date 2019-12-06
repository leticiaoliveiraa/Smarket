package com.example.smarket.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.smarket.Objetos.Administradores;

public class AdministradoresDAO {

    private Conexao conn;
    private  String TABLE = "PRODUTOS";

    public AdministradoresDAO(Context context) { conn = new Conexao(context);}

    //COLOCAR TRATAMENTO DE ERROS PARA VERIFICAR REPETIÇÃO DE CHAVE
    public void salvar(Administradores admin){
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues dados = preencherDados(admin);

        db.insert(TABLE, null, dados);
        db.close();
    }

    private ContentValues preencherDados (Administradores admin){

        ContentValues dados = new ContentValues();
        dados.put("USERNAME", admin.getUsername());
        dados.put("PASSWORD", admin.getPassword());

        return dados;
    }

    //COLOCAR TRATAMENTO DE ERRO CASO A SENHA ESTIVER ERRADA
    public boolean verificarSenha (String nome, String senha){

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] param = {nome, senha};
        String sql = "SELECT * FROM ADMINISTRADORES WHERE NOME = ? AND SENHA = ?";
        Cursor cursor = db.rawQuery(sql, param);

        boolean result = cursor.moveToNext();

        cursor.close();
        db.close();

        return result;

    }

}
