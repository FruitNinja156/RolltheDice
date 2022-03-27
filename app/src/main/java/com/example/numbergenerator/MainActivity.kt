package com.example.numbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.numbergenerator.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonGenerate.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice()
        val diceRoll = dice.roll()
        val diceImage = when(diceRoll){
            1->R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5->R.drawable.dice_5
            else-> R.drawable.dice_6
        }
        binding.imageView.setImageResource(diceImage)
        binding.imageView.contentDescription = diceRoll.toString()
    }

}

class Dice(val sides:Int=6){
    fun roll():Int{
        return (1..sides).random()
    }
}