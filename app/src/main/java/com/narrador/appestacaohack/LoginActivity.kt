package com.narrador.appestacaohack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.narrador.appestacaohack.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //utilizado para inicializar uma varivel somente com sua classe
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //encapsulando os elementos da tela na variavel binding
        binding = ActivityLoginBinding.inflate(layoutInflater)

         //mexemos aqui também
        setContentView(binding.root)
        //Quando o botão for clicado, faça:
        binding.btnLoginEntrar.setOnClickListener {
            //recebe o na variavel email o conteudo da textview em formato de texto, converte para String, corta os espaçoas antes e depois do texto e converte tudo para minusculo
            val email= binding.edtLoginEmail.text.toString().trim().lowercase()
            //recebe na variavel email o conteudo da textview em formato de texto, converte para String, corta os espaçoas antes e depois do texto e
            val senha= binding.edtLoginSenha.text.toString().trim()


        // Faz a verificação de erro para entrada vazia, notifica o usuário e dá foco ao campo a ser preenchido

            if (email.isEmpty()){
                binding.edtLoginEmail.error = "Campo Obrigatório"
                binding.edtLoginEmail.requestFocus()
            }
            else if (senha.isEmpty()){
                binding.edtLoginSenha.error = "Campo Obrigatório"
                binding.edtLoginSenha.requestFocus()
            }
            else {
                // acessando arquivo de preferencias compsrtilhadas (shared preferences)
                    val sharedPrefs= getSharedPreferences ("cadastro_$email", Context.MODE_PRIVATE)
             //recuperrar os dados no arquivos
                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")


                if(email == emailPrefs && senha == senhaPrefs) {
                    // Se tudo estiver certo uma mensagem de sucesso será exibida
                    Toast.makeText(this, "Usuário Logado", Toast.LENGTH_LONG).show()
                 val mIntent = Intent(this, MainActivity::class.java)
                 // Método responsável por executar a Intent.
                 startActivity(mIntent)
                 finish()

                } else {
                    // Se o email ou senha não baterem, então uma mensagem de erro será exibida
                    Toast.makeText(this, "Email ou senha inválida!", Toast.LENGTH_LONG).show()
                }
            }
        }
            binding.btnLoginCadastrar.setOnClickListener {
                //ao clicar vai na tela de cadastro
                val mIntent = Intent(this, CadastroActivity::class.java)
                // Método responsável por executar a Intent.
                startActivity(mIntent)
            }

    }

                }

