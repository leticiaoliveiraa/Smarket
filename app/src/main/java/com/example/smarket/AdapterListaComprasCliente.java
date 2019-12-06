package com.example.smarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.smarket.Produtos;

import java.util.List;


public class AdapterListaComprasCliente extends BaseAdapter {


    private List<Produtos> listaCompras;
    private Context context;

    public AdapterListaComprasCliente(List<Produtos> listaCompras, Context context) {
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

    /*@Override
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
    }*/



    @Override
    public View getView(int itemIndex, View convertView, ViewGroup viewGroup) {

        ListViewItemViewHolder viewHolder = null;

        if(convertView!=null)
        {
            viewHolder = (ListViewItemViewHolder) convertView.getTag();
        }else
        {
            convertView = View.inflate(context, R.layout.activity_list_view_with_checkbox_item, null);

            Produtos p = listaCompras.get(itemIndex);

            CheckBox listItemCheckbox = (CheckBox) convertView.findViewById(R.id.list_view_item_checkbox);

            TextView textViewNome = convertView.findViewById(R.id.item_produto_nome);
            TextView textViewPreco = convertView.findViewById(R.id.item_produto_preco);

            textViewNome.setText(p.getNome());
            textViewPreco.setText(String.valueOf(p.getPreco()));

            viewHolder = new ListViewItemViewHolder(convertView);

            viewHolder.setItemCheckbox(listItemCheckbox);

            convertView.setTag(viewHolder);
        }

        Produtos produtos = listaCompras.get(itemIndex);
        viewHolder.getItemCheckbox().setChecked(produtos.isChecked());

        return convertView;
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
