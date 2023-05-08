package com.h2square.intentbasic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        nickNameOk.setOnClickListener{
            val newNickName= nickNameEdit.text.toString()
            val resultIntent=Intent()
            resultIntent.putExtra("newNicName",newNickName)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()


        }

    }
}