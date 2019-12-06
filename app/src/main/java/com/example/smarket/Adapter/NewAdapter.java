package com.example.smarket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smarket.Objetos.Produtos;
import com.example.smarket.R;

import java.util.List;

public class NewAdapter extends BaseAdapter {

    List<Produtos> lista;
    Context context;

    public NewAdapter(List<Produtos> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        System.out.println("TAM: " + lista.size());
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        TextView nome = view.findViewById(R.id.item_produto_nome);
        TextView preco = view.findViewById(R.id.item_produto_preco);

        nome.setText(lista.get(position).getNome());
        preco.setText(String.valueOf(lista.get(position).getPreco()));

        return view;
    }

    public void atualiza(List<Produtos> lista) {
        this.lista.clear();
        this.lista.addAll(lista);
        notifyDataSetChanged();
    }
}
