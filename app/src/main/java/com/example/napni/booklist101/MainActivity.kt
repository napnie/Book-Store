package com.example.napni.booklist101

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.napni.booklist101.Model.Book
import com.example.napni.booklist101.Model.BookRepository
import com.example.napni.booklist101.presenter.BookPresenter
import com.example.napni.booklist101.presenter.BookView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), BookView {

    lateinit var book_repo: BookRepository
    var adapter: ArrayAdapter<Book>? = null
    lateinit var presenter: BookPresenter

    override fun setBookList(books: ArrayList<Book>) {
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, books )
        list_item.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        book_repo = BookStore()
        presenter = BookPresenter(this, book_repo)
        presenter.start()
    }

    fun loadButtonClicked(view: View) {
        if( search_box.text.toString().isEmpty() ) {
            book_repo.loadAllBooks()
        } else {
            book_repo.seach(search_box.text.toString() )
        }
    }

    fun goAccountClicked(view:View) {
        val intent = Intent(this@MainActivity , AccountActivity::class.java)
        startActivity(intent)
    }

}
