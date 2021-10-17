package com.example.randomfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var films : Array<String>;
    val r = Random()
    var is_seen  = emptyArray<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        films = resources.getStringArray(R.array.films)
        for(i in films.indices){
            is_seen += 0
        }
    }

    fun onNextClick(view: android.view.View) {
        val tvTitle = findViewById<TextView>(R.id.title)

        for (i in films.indices){
            //Log.d("mytag", i.toString())
            if (i == films.size-1){
                Toast.makeText(applicationContext, "That's the end. Please, reset", Toast.LENGTH_SHORT).show()
            }
            val randint = r.nextInt(films.size)
            if (is_seen[randint] == 0){
                tvTitle.text= films[randint]
                is_seen[randint] = 1
                break
            }
        }

    }
    fun onClearClick(view: android.view.View) {
        for(i in films.indices){
            is_seen[i] = 0
        }
        Toast.makeText(applicationContext, "THERE WILL BE ONLY DAVID LYNCH FILMS", Toast.LENGTH_LONG).show()
    }
}