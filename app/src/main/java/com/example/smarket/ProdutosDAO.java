package com.example.smarket;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdutosDAO {

    private Conexao conn;
    private  String TABLE = "PRODUTOS";

    public ProdutosDAO(Context context) { conn = new Conexao(context);}

    public void salvar(Produtos produto){
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues dados = preencherDados(produto);

        db.insert(TABLE, null, dados);
        db.close();
    }

    private ContentValues preencherDados (Produtos produto){

        ContentValues dados = new ContentValues();
        dados.put("NOME", produto.getNome());
        dados.put("PRECO", produto.getPreco());
        dados.put("DATAVALIDADE", produto.dataValidade);
        dados.put("MARCA", produto.getMarca());

        return dados;
    }

    public List<Produtos> listarProdutos() {

        List<Produtos> list = new ArrayList<>();

        String sql = "SELECT * FROM PRODUTOS;";
        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        while(cursor.moveToNext()){

            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("NOME"));
            double preco = cursor.getDouble(cursor.getColumnIndex("PRECO"));
            String categoria = cursor.getString(cursor.getColumnIndex("CATEGORIA"));
            String data = cursor.getString(cursor.getColumnIndex("DATAVALIDADE"));
            String marca = cursor.getString(cursor.getColumnIndex("MARCA"));

            list.add(new Produtos(nome, categoria, preco, marca, data));

        }

        cursor.close();
        db.close();

        return list;
    }

    public boolean buscarPorCategoria (String categoria){

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] param = {categoria};
        String sql = "SELECT * FROM PRODUTOS WHERE CATEGORIA = ?";
        Cursor cursor = db.rawQuery(sql, param);

        boolean result = cursor.moveToNext();

        cursor.close();
        db.close();

        return result;

    }

    //rever esse ID
    public void remover(Produtos produto){

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] param = {String.valueOf(produto.getId())};
        db.delete(TABLE, "id = ?", param);
        db.close();

    }

}
