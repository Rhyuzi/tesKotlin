package teskotlin.example.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = findViewById(R.id.username) as EditText
        var password = findViewById(R.id.password) as EditText
        var btnLogin = findViewById(R.id.btnLogin) as Button

        val userSuccess = "dimas"
        val passwordSuccess = "dimasganteng"


        btnLogin.setOnClickListener {

            if (username.text.toString() == userSuccess && password.text.toString() == passwordSuccess){
                startActivity(Intent(this@MainActivity,Dashboard::class.java))
            }else if (username.text.toString() == "" || password.text.toString() == ""){
                Toast.makeText(applicationContext,"Username atau Password Tidak Boleh Kosong",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"Username atau Password Salah",Toast.LENGTH_LONG).show()
            }

        }
    }
}