package com.narrador.appestacaohack

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.narrador.appestacaohack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// Recuperar o email passado por meio da Intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        //Acessar o arquivo de preferncias compartilhadas
        val sharedPrefs = getSharedPreferences (
            "cadastro_$email",    //nome do arquivo
        Context.MODE_PRIVATE           //Modo de acesso
        )
//Recuperar dados no arquivo de preferencias compartilhadas
        //As aspas vazias definem o valor padrão em caso de erro
        val nome = sharedPrefs.getString ("NOME", " ")
        val sobrenome = sharedPrefs.getString ("SOBRENOME", " ")
        val continente = sharedPrefs.getString ("CONTINENTE", " ")

// Exibir os dados recuperrados da tela a
        binding.txvMainNome.text= "$nome $sobrenome"
        binding.txvMainEmail.text= email
        binding.txvMainContinente.text= continente

        binding.btSair.setOnClickListener {
            //
            val alert = AlertDialog.Builder (this)
            alert.setTitle("Atenção")
            alert.setMessage("Deseja mesmo sair?")
            // Definindo o rótulo do botão escutando o clique
            alert.setPositiveButton("Sair") { dialog, which ->
                val mIntent= Intent ( this, LoginActivity::class.java)
                startActivity(mIntent)
                finishAffinity()
            }

            alert.setNeutralButton("Não"){ dialog, which -> }
            //Desabilita a possibilidade do usuario cancelar a caixo do dialogo
            // ao clicar fora da mesma, assim obrigando o user a escolher uma das opções
            alert.setCancelable(false)

            alert.show()
        }

        //Escutando o btn cellep
        binding.btnCellep.setOnClickListener{
            val mIntent = Intent( this, WebActivity::class.java )
            startActivity(mIntent)
        }


 //       Toast.makeText(this, "O email é $email", Toast.LENGTH_LONG).show()
    }
}