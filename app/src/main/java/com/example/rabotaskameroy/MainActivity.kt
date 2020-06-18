package com.example.test

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.rb1
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {
    var a = 0
    val savedA = "SavedA"
    val savedBool = "SAVED_BOOLEAN"
    var activity_changed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun imgclck(view: View){
        val imageTakeIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(imageTakeIntent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1&&resultCode==Activity.RESULT_OK)
        {
            val exstras = data?.extras
            val bitmap = exstras?.get("data") as Bitmap?
            imgv.setImageBitmap(bitmap)
        }
    }
    fun Enter(view: View) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}
