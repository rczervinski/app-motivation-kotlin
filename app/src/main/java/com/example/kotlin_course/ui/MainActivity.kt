package com.example.kotlin_course.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_course.R
import com.example.kotlin_course.business.SecurityPreferences
import com.example.kotlin_course.databinding.ActivityMainBinding
import com.example.kotlin_course.utils.AppConstants

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var securityPreferences: SecurityPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        securityPreferences = SecurityPreferences(this)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        verifyUserName()
        setListeners()

    }

    private fun verifyUserName(){
        val name = securityPreferences.getString(AppConstants.KEY.NAME_KEY)
        if(name.isNotEmpty()){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_save_motivation) {
            val name = binding.edittextWriteStart.text.toString()

            if (name.isNotEmpty()) {
                securityPreferences.storeString(AppConstants.KEY.NAME_KEY, name)
                startActivity(Intent(this, HomeActivity::class.java))

            } else {
                Toast.makeText(this, "Informe um nome", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun setListeners(){
        binding.buttonSaveMotivation.setOnClickListener(this)
    }

}