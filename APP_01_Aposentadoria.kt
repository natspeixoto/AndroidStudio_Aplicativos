package com.example.app_01_aposentadoria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spn_sexo = findViewById<Spinner>(R.id.spn_Sexo)
        val txt_Idade = findViewById<EditText>(R.id.txt_Idade)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)

        spn_sexo.adapter = ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino")
        )

        btn_Calcular.setOnClickListener {

            val sexo = spn_sexo.selectedItem as String
            val idade = txt_Idade.text.toString().toInt()
            //val idade = 50
            var resultado = 0
            if (sexo == "Masculino") {
                resultado = 65 - idade
            } else {
                resultado = 60 - idade
            }
            txt_Resultado.text = "Faltam $resultado anos para você se aposentar"

        }
        }

    }
