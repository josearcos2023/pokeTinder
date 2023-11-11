package com.jose.arcos.poketinder.ui.view
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.jose.arcos.poketinder.databinding.ActivityLoginBinding
import com.jose.arcos.poketinder.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnLogin.setOnClickListener{
            startLogin()
        }
        binding.btnRegister.setOnClickListener {
            startRegister()
        }
        loginViewModel = LoginViewModel(this)
        loginViewModel.onCreate()
        loginViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this, "Ingrese los datos de Usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldsAuthenticateError.observe(this){
            Toast.makeText(this,"Error de Usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSuccessActivity.observe(this){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun startLogin() {
        loginViewModel.validateInputs(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )
    }
    fun startRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}