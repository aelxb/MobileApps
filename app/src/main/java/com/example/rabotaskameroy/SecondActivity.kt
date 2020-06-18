package com.example.test


import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.rb1
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    var a = 0
    val savedA = "A"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
    fun Clck2(view: View) {
        if ((edittext.text.toString() == "Linear") || (edittext.text.toString() == "linear")) {
            a += 1;
        }
        if (rb1.isChecked) {
            a += 1;
        }
        if (cl2.isChecked) {
            a += 1;
        }
        btnFin.text = "Правильных ответов:"+a.toString()
    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(savedA,a)
        outState.putString("BTN_TXT", btnFin.text.toString())
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        a = savedInstanceState.getInt(savedA)
        btnFin.text = savedInstanceState.getString("BTN_TXT")
    }
}
