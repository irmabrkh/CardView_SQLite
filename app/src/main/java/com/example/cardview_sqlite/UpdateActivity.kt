package com.example.cardview_sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class UpdateActivity : AppCompatActivity() {
    lateinit var userDBHelper : DBHelper
    lateinit var inputemail: EditText
    lateinit var inputpass: EditText
    lateinit var inputusername: EditText
    lateinit var inputfullname: EditText
    lateinit var btnUpdate : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        inputemail = findViewById(R.id.input_emailu)
        inputpass = findViewById(R.id.input_passwordu)
        inputusername = findViewById(R.id.input_usernameu)
        inputfullname = findViewById(R.id.input_namau)
        btnUpdate = findViewById(R.id.btn_update)
        userDBHelper = DBHelper(this)
        val bundle = intent.extras
        if (bundle!=null){
            inputemail.setText(bundle.getString("emailk"))
            inputusername.setText(bundle.getString("usernamek"))
            inputpass.setText(bundle.getString("passk"))
            inputfullname.setText(bundle.getString("fullnamek"))

        }
    }

    fun updateData(v : View){
        val inEmail = findViewById<EditText>(R.id.input_emailu)
        val inuserName = findViewById<EditText>(R.id.input_usernameu)
        val infullName = findViewById<EditText>(R.id.input_namau)
        val inpass = findViewById<EditText>(R.id.input_passwordu)

        var emailin = inEmail.text.toString()
        var passin = inpass.text.toString()
        var usernamein = inuserName.text.toString()
        var fullnamein = infullName.text.toString()
        userDBHelper.updateData(emailin, passin, usernamein, fullnamein)
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }

    fun cancelData(v: View){
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }

}