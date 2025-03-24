package com.example.kotlin_course.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_course.R
import com.example.kotlin_course.business.SecurityPreferences
import com.example.kotlin_course.databinding.ActivityHomeBinding
import com.example.kotlin_course.utils.AppConstants

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var securityPreferences: SecurityPreferences
    private val phraseRepository = PhraseRepository()
    private var filter = AppConstants.PHRASEFILTER.PHRASE_ALL

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        securityPreferences = SecurityPreferences(this)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getName()
        handleFilter(R.id.image_button1)
        refreshPhrase()
        setListeners()



    }

    private fun getName(){
        val name = securityPreferences.getString(AppConstants.KEY.NAME_KEY)
        val formatedString = "Olá, $name!"
        binding.textviewName.text = formatedString
    }

    override fun onClick(v: View?) {
        val listId = listOf(
            R.id.image_button1, R.id.image_button2, R.id.image_button3
        )

        if (v != null) {
            if(v.id == R.id.button_new_phrase){
                refreshPhrase()

            }else if(v.id in listId){
                handleFilter(v.id)
            }
        }
    }

    private fun refreshPhrase(){
        binding.textviewPhrase.text = phraseRepository.getPhrase(filter)
    }



    private fun handleFilter(id : Int){
        binding.imageButton1.setColorFilter(ContextCompat.getColor(this,R.color.black))
        binding.imageButton2.setColorFilter(ContextCompat.getColor(this,R.color.black))
        binding.imageButton3.setColorFilter(ContextCompat.getColor(this,R.color.black))
        when(id){


            R.id.image_button1 -> {
                filter = AppConstants.PHRASEFILTER.PHRASE_ALL
                binding.imageButton1.setColorFilter(ContextCompat.getColor(this,R.color.purple))
            }
            R.id.image_button2 -> {
                filter = AppConstants.PHRASEFILTER.PHRASE_HAPPY
                binding.imageButton2.setColorFilter(ContextCompat.getColor(this,R.color.purple))
            }
            R.id.image_button3 -> {
                filter = AppConstants.PHRASEFILTER.PHRASE_SUNNY
                binding.imageButton3.setColorFilter(ContextCompat.getColor(this,R.color.purple))
            }
        }
    }

    private fun setListeners(){
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageButton1.setOnClickListener(this)
        binding.imageButton2.setOnClickListener(this)
        binding.imageButton3.setOnClickListener(this)


    }
}