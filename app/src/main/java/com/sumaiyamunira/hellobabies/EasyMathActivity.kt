package com.sumaiyamunira.hellobabies

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class EasyMathActivity : AppCompatActivity() {
    private lateinit var mediaPlayerSuccess: MediaPlayer
    private lateinit var mediaPlayerError: MediaPlayer
    lateinit var sumTxt1: TextView
    lateinit var sumTxt2: TextView

    lateinit var txt1: TextView
    lateinit var txt2: TextView
    lateinit var txt3: TextView
    lateinit var txt4: TextView
    lateinit var textViewArray: Array<TextView>
    var resID_success by Delegates.notNull<Int>()
    var resID_fail by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_math)
        sumTxt1 = findViewById(R.id.sum_first_number)
        sumTxt2 = findViewById(R.id.sum_second_number)

        resID_success = resources.getIdentifier("success_sound", "raw", packageName)
        resID_fail = resources.getIdentifier("error_sound", "raw", packageName)


        mediaPlayerSuccess = MediaPlayer.create(this, resID_success)
        mediaPlayerError = MediaPlayer.create(this, resID_fail)


        txt1 = findViewById(R.id.txt_1)
        txt2 = findViewById(R.id.txt_2)
        txt3 = findViewById(R.id.txt_3)
        txt4 = findViewById(R.id.txt_4)
        textViewArray = arrayOf(sumTxt1,
            txt1,
            txt2,
            txt3,
            txt4,
        )

        doMath(textViewArray)
    }

    fun doMath(array: Array<TextView>) {
        var result: Int
        var answer: Int

        var num1: Int
        var num2: Int

        num1 = (1..5).random()
        num2 = (1..5).random()
        result = num1 + num2
        sumTxt1.setText("" + num1)
        sumTxt2.setText("" + num2)

        result = num1 + num2

        val correctPosition = (1..4).random()
        var option: Int

        for (i in 1..4) {
            if (i == correctPosition) {
                option = result
            } else {
                option = (1..10).random()
                while (option == result) {
                    option = (1..10).random()
                }
            }
            array[i].setText("" + option)
            array[i].setOnClickListener(View.OnClickListener {
                if (array[i].text == "" + result) {
                    Toast.makeText(this, "Yes Right Answer!", Toast.LENGTH_SHORT).show()
                    doMath(textViewArray)
                    mediaPlayerSuccess.start()
                } else {
                    mediaPlayerError.start()
                    Toast.makeText(this, "Sorry Try again", Toast.LENGTH_SHORT).show()
                }

            })
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        // Release the media player's resources
        mediaPlayerSuccess.release()
        mediaPlayerError.release()
    }

}

