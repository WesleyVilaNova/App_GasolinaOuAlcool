package com.example.gasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bt_Calcular (view:View){
        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()

        val validaCampos = validarCampos (precoAlcool, precoGasolina)
            if (validaCampos) {
                calcularMelhorPreco(precoAlcool , precoGasolina)
            }
            else {
                text_resultado.setText("Preencha os campos primeiro")
            }
    }

    fun validarCampos (precoAlcool: String, precoGasolina: String) : Boolean {
        var camposValidados: Boolean = true

        if (precoAlcool ==null || precoAlcool.equals("")){
            camposValidados = false
        }
            else if (precoGasolina ==null || precoGasolina.equals("")){
                camposValidados = false
            }
                    return camposValidados
    }
    fun calcularMelhorPreco (precoAlcool: String, precoGasolina: String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadorPreco = valorAlcool / valorGasolina

             if (resultadorPreco >= 0.7){
                text_resultado.setText("Em geral a melhor opção é: Gasolina")
             }
                else {
                     text_resultado.setText("Em geral a melhor opção é: Álcool ")
                }

    }
}