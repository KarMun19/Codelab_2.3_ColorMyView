/**********************
 * author:LimKarMun
 * date:03/07/2020
 **********************/

package com.example.colormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(getColor())
            R.id.box_two_text -> view.setBackgroundColor(getColor())
            R.id.box_three_text -> view.setBackgroundColor(getColor())
            R.id.box_four_text -> view.setBackgroundColor(getColor())
            R.id.box_five_text -> view.setBackgroundColor(getColor())
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun getColor() : Int {
        return Color.argb(255,(0..256).random(),(0..256).random(),(0..256).random())
    }

    private fun setListeners() {

        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val redButton = findViewById<TextView>(R.id.red_button)
        val greenButton = findViewById<TextView>(R.id.green_button)
        val yellowButton = findViewById<TextView>(R.id.yellow_button)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout,
                redButton, greenButton, yellowButton)

        for (item in clickableViews) {
            item.setOnClickListener {
                makeColored(it)
                val toast = Toast.makeText(applicationContext, "Lim Kar Mun\n18WMR12145", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER,0,500)
                toast.show()
            }
        }
    }

}
