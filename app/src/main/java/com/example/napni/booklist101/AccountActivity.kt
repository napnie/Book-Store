package com.example.napni.booklist101

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.napni.booklist101.Model.Book
import com.example.napni.booklist101.presenter.AccountPresenter
import com.example.napni.booklist101.presenter.AccountView
import kotlinx.android.synthetic.main.account.*
import kotlinx.android.synthetic.main.activity_main.*

class AccountActivity : AppCompatActivity(), AccountView {

    lateinit var presenter : AccountPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account)

        presenter = AccountPresenter(this, BookStoreAccount)
        presenter.start()
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

    override fun updateFund(fund: Double) {
        fund_text.text = fund.toString() + " Baht"
    }

    override fun updateCart(cart: ArrayList<Book>) {
        val adapter = ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, cart )
        cart_view.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    override fun updateShelf(shelf: ArrayList<Book>) {
        val adapter = ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, shelf )
        shelf_view.adapter = adapter
        adapter?.notifyDataSetChanged()
    }


    fun doneClicked(view: View) {
        setResult(Activity.RESULT_OK)
        finish()
    }

}
