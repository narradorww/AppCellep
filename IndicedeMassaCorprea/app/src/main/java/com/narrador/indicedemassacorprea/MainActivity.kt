package com.narrador.indicedemassacorprea

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.narrador.indicedemassacorprea.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    //utilizado para inicializar uma varivel somente com sua classe
    private lateinit var binding: ActivityMainBinding

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Quando o botão for clicado, faça:
        binding.btnCalc.setOnClickListener {
            //recebe na variavel peso o conteudo da textview tv_peso
            val peso= binding.tvPeso.toString().toFloat()
            //recebe na variavel altura o conteudo da textview tv_altura
            val altura= binding.tvAltura.toString().toFloat()

            val imc= (peso/(altura*altura))


            Toast.makeText(this, "$imc", Toast.LENGTH_LONG).show()
/*
            if (imc<18.5) {
                binding.tvClassificacao.text=getString(R.string.txt_baixo)
            } else if (imc>=18.6 && imc<=24.9) {
            binding.tvClassificacao.text=getString(R.string.txt_normal)
            } else if (imc>=25 && imc<=29.9) {
            binding.tvClassificacao.text=getString(R.string.txt_sobrepeso)
            } else if (imc>=30 && imc<=34.9) {
            binding.tvClassificacao.text=getString(R.string.txt_obesidadeg1)
            }else if (imc>=35 && imc<=39.9) {
            binding.tvClassificacao.text=getString(R.string.txt_obesidadeg2)
            } else { binding.tvClassificacao.text=getString(R.string.txt_obesidadeg3)}


            val imctexto= imc.toString()
            binding.tvImc.text=imctexto
*/
        }


    }
}