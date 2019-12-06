package com.example.smarket.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.smarket.Adapter.NewAdapter;
import com.example.smarket.BD.DaoLista;
import com.example.smarket.BD.ProdutosDAO;
import com.example.smarket.Objetos.Produtos;
import com.example.smarket.R;

public class ListaComprasActivity extends AppCompatActivity {

    private NewAdapter adapter;
    private Produtos produto;
    private ProdutosDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras);

        adapter = new NewAdapter(DaoLista.lista, this);

        ListView listView = findViewById(R.id.listView_ListaCompras);
        listView.setAdapter(adapter);



        FloatingActionButton fab_catalogo = findViewById(R.id.fab_catalogo_produtos);
        fab_catalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaComprasActivity.this, CatalogoClienteActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto_cliente, menu);
    }

    public boolean onContextItemSelected (MenuItem item) {

        AdapterView.AdapterContextMenuInfo contextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        produto = (Produtos) adapter.getItem(contextMenuInfo.position);

        if (item.getItemId() == R.id.admin_apagar){
            ProdutosDAO dao = new ProdutosDAO(this);
            dao.remover((Produtos) item);
            onResume();
        }

        return  super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcoes_lista_cliente, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.ligar_cliente) {

            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                String[] permissions = {Manifest.permission.CALL_PHONE};
                ActivityCompat.requestPermissions(this, permissions,
                        123);

            } else {

                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel: 82999999999"));
                startActivity(i);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (permissions[0].equals(Manifest.permission.CALL_PHONE) &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel: 82999999999"));
            startActivity(i);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUME: " + DaoLista.lista.size());
        adapter.atualiza(DaoLista.lista);
    }


}
