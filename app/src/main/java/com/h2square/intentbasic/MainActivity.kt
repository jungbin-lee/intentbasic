package com.h2square.intentbasic

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQ_FOR_EDIT_NOCKNAME=1005
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        dialBtn.setOnClickListener{
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent =  Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)

        }

        callBtn.setOnClickListener{
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent =  Intent(Intent.ACTION_CALL, myUri)

            startActivity(myIntent)

        }
        smsBtn.setOnClickListener{
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")

            val myIntent =  Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body","미리내용입력")
            startActivity(myIntent)

        }
naverBtn.setOnClickListener {
    val myUri =Uri.parse("https://naver.com")
    val myIntent = Intent(Intent.ACTION_VIEW, myUri)
    startActivity(myIntent)

}
        kakaoStoreBtn.setOnClickListener {
            val myUri =Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        editNickNameBtn.setOnClickListener {
            val myIntent =  Intent(this, EditNickNameActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_EDIT_NOCKNAME)



        }

        editBtn.setOnClickListener{
            val  inputMessage =messageEdit.text.toString()
            val editIntent= Intent(this, MessageActivity::class.java)
            editIntent.putExtra("message",inputMessage)

            startActivity(editIntent)
        }

        moveToOtherBtn.setOnClickListener {
            //other로 이동
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_EDIT_NOCKNAME){
            if (resultCode == Activity.RESULT_OK){
                val newName = data?.getStringExtra("newNicName")
                nickNameTxt.text = newName
            }
        }
    }

}