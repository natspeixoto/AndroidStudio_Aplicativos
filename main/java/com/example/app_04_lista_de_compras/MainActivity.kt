package com.example.app_04_lista_de_compras

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variáveis de elementos visuais
        val listViewProdutos = findViewById<ListView>(R.id.listViewProdutos)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtProduto = findViewById<TextView>(R.id.txtProduto)


        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        //Definição do adaptadr da Lista
        listViewProdutos.adapter = produtosAdapter
        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if (produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                txtProduto.text = ""
            } else {
                txtProduto.error = "Coloque um produto"
            }

        }
        listViewProdutos.setOnItemClickListener{ adapterView: AdapterView<*>,
                                                 view, position: Int, id: Long ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
        }
    }
}

