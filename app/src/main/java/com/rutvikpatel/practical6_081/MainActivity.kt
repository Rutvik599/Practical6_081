package com.rutvikpatel.practical6_081

import MyService
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var toggleplaybutton = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playbutton = findViewById<FloatingActionButton>(R.id.playbutton)
        val stopbutton = findViewById<FloatingActionButton>(R.id.stopbutton)
        playbutton.setOnClickListener{
            if (toggleplaybutton){
                Intent(applicationContext,MyService::class.java).putExtra("Service1","PauseButton").apply { startService(this) }
                toggleplaybutton = false
                playbutton.setImageResource(R.drawable.baseline_pause_24)
            }
            else{
                Intent(applicationContext,MyService::class.java).putExtra("Service1","PlayButton").apply { startService(this) }
                toggleplaybutton = true
                playbutton.setImageResource(R.drawable.play)
            }
        }
        stopbutton.setOnClickListener{
            Intent(applicationContext,MyService::class.java).apply { stopService(this) }
            if(!toggleplaybutton){
                toggleplaybutton = true
                playbutton.setImageResource(R.drawable.play)
            }
        }
    }
}
