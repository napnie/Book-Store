package com.example.napni.booklist101

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.napni.booklist101.Model.Book
import com.example.napni.booklist101.Model.BookRepository
import com.example.napni.booklist101.Model.MockBookRepository
import com.example.napni.booklist101.presenter.BookPresenter
import com.example.napni.booklist101.presenter.BookView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var book_repo: BookRepository
    var adapter: ArrayAdapter<Book>? = null
//    lateinit var presenter: BookPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        book_repo = BookStore()
        book_repo.loadAllBooks()
//        presenter = BookPresenter(this, book_repo)
    }

    fun loadButtonClicked(view: View) {
        lateinit var book_list : ArrayList<Book>
        if( search_book.text.toString().isEmpty() ) {
            book_list = book_repo.getBook()
        } else {
            book_list = book_repo.seach(search_book.text.toString() )
        }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, book_list )
        list_item.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

}
