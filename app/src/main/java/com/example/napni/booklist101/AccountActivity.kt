package com.example.napni.booklist101

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.account.*

class AccountActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account)
    }

    fun addFundButtonClicked(view : View) {
        var fund : Double
        try {
            fund = money_edit_text.text.toString().toDouble()
        } catch (ex : Exception) {
            Toast.makeText(this@AccountActivity, "Please input number!", Toast.LENGTH_LONG).show()
            return
        }

        BookStoreAccount.deposit(fund)
    }

    fun doneClicked(view: View) {
        setResult(Activity.RESULT_OK)
        finish()
    }

}
