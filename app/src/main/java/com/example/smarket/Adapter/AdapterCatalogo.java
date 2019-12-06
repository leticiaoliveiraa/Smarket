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


public class AdapterCatalogo extends BaseAdapter {


    private List<Produtos> listaCompras;
    private Context context;

    public AdapterCatalogo(List<Produtos> listaCompras, Context context) {
        this.listaCompras = listaCompras;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaCompras.size();
    }

    @Override
    public Produtos getItem(int position) {
        return listaCompras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaCompras.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Inflar a view item
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);

        // Recuperar o contato
        Produtos p = listaCompras.get(position);

        // Recuperar as views
        // Recuperar as views
        TextView textViewNome = view.findViewById(R.id.item_produto_nome);
        TextView textViewPreco = view.findViewById(R.id.item_produto_preco);

        // Adicionar na view
        textViewNome.setText(p.getNome());
        textViewPreco.setText(String.valueOf(p.getPreco()));

        return view;
    }

    public void atualiza(List<Produtos> produtos) {
        listaCompras.clear();
        listaCompras.addAll(produtos);
        notifyDataSetChanged();
    }

    public void remove(Produtos produto) {
        listaCompras.remove(produto);
        //notifyDataSetChanged();
    }

}
