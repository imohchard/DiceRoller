package com.richard.diceroller

import android.content.Context
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.seismic.ShakeDetector
import java.util.*

class MainActivity : AppCompatActivity(),ShakeDetector.Listener {


    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        diceImage1 = findViewById(R.id.dice_image_1)
        diceImage2 = findViewById(R.id.dice_image_2)
        rollButton.setOnClickListener {
            rollDice()
        }




        var sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        var sh = ShakeDetector(this)
        sh.start(sensorManager)

    }

    private fun rollDice() {
        val randomInt1 =  Random().nextInt(6) + 1
        val randomInt2 = Random().nextInt(6)+1
        val drawableResource1 = when(randomInt1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
           else -> R.drawable.dice_6

        }
        val drawableResource2 = when(randomInt2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //val  diceImage : ImageView = findViewById(R.id.dice_image)
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)


    }



    override fun hearShake() {
        rollDice()
    }
}

