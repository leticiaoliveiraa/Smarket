package com.example.smarket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    public Conexao(Context context) {
        super(context, "LISTACOMPRAS", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE PRODUTOS (ID INTEGER PRIMARY KEY, CATEGORIA TEXT, NOME TEXT NOT NULL, PRECO DOUBLE, MARCA TEXT," +
                " DATAVALIDADE TEXT);";
        String sql2 = "CREATE TABLE ADMINISTRADORES (ID INTEGER PRIMARY KEY, USERNAME TEXT NOT NULL, PASSWORD TEXT);";
        db.execSQL(sql);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS CONTATO";
        db.execSQL(sql);

        onCreate(db);
    }


}