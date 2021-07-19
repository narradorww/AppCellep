package com.narrador.appestacaohack

import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.narrador.appestacaohack.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

       //* fun md5(input:String): String {
       //     val md = MessageDigest.getInstance("MD5")
        //    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
       // }


        //Criar uma lista de opções para o spinner
        val listaContinentes = arrayListOf("Continente", "Africa", "Antártida", "América", "Europa", "Oceania")


        //Criar um adaptador para o spinner
        val spinnerAdapter = ArrayAdapter(
            this,                                   //Contexto
            R.layout.simple_spinner_dropdown_item,          //Layout
            listaContinentes                                //Dados

        )

        //Plugando o adaptador ao Spinners
        binding.spnCadastroContinente.adapter= spinnerAdapter

        //Quando o botão cadastrar for clicadso , faça
        binding.btnCadastroCadastrar.setOnClickListener {
            // Os dados digitados são cadastrados e salvos em variáveis
            val nome = binding.edtCadastroNome.text.toString().trim()
            val sobrenome = binding.edtCadastroSobrenome.text.toString().trim()
            val email = binding.edtCadastroEmail.text.toString().trim()
            val senha = binding.edtCadastroSenha.text.toString().trim()
            val continente = binding.spnCadastroContinente.selectedItem.toString()

            //Aqui os campos sao validados
            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty() || continente == listaContinentes[0]) {
                // Se qq um do scampos não estiver preenchido uma msg de erro sera exibida

                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else {
                //se todos os campos forem preenchidos o escopo else é executado armazrnando as infos na memoria locales
                //aqui estamos criando um areferencia a um arquivo de preferncias compartilhadas

                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)
                val editPrefs = sharedPrefs.edit()



                //Aqui os dados são preparados para serem salvos no arquivo
                // Os dados são slvos no formato chave -> valor
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("CONTINENTE", continente)



                //Aqui os dados são salvos no arquivo
                editPrefs.apply()

                Toast.makeText(this, "Usuário Cadastrado", Toast.LENGTH_LONG).show()
                val mIntent = Intent(this, MainActivity::class.java)
                mIntent.putExtra("INTENT_EMAIL", email)
                startActivity(mIntent)


                //Aqui é mostrado como passar dados entre activities
                // O email será utilizado pela MainActivity para acessar o arquivo
                //de preferencias compartilhadas
                mIntent.putExtra("INTENT_EMAIL", email)
                // Método responsável por executar a Intent.
                startActivity(mIntent)

                finishAffinity()

            }
        }}}