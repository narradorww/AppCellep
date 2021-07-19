package com.narrador.appestacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //executando instruções após 3 segundos (3000 ms)
        Handler(Looper.getMainLooper()).postDelayed({
            //Uma das utilidades da classe Intent é usa-la para abrir uma nova activity.
        val mIntent = Intent(this, LoginActivity::class.java)
        // Método responsável por executar a Intent.
            startActivity(mIntent)

            //Remover a tela da pilha de memória
            finish()

        },3000)
    }
}