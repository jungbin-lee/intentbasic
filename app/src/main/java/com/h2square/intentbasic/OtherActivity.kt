package com.h2square.intentbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

backBtn.setOnClickListener {
//    //other로 이동
//    val backIntent = Intent(this, MainActivity::class.java)
//    startActivity(backIntent)
    finish()
}
    }
}