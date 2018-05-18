package com.example.napni.booklist101.presenter

import com.example.napni.booklist101.BookStoreAccount
import com.example.napni.booklist101.Model.Book
import com.example.napni.booklist101.Model.BookRepository
import java.util.*
import kotlin.collections.ArrayList

class BookPresenter(val view: BookView,
                    val repository:BookRepository): Observer {

    fun start() {
        repository.addObserver(this)
        repository.loadAllBooks()
    }

    override fun update(p0: Observable?, p1: Any?) {
        if( p0 == repository) {
            lateinit var books : ArrayList<Book>
            if( p1 != null) {
                books = p1 as ArrayList<Book>
            } else {
                books = repository.getBook()
            }

            view.setBookList(books)
            BookStoreAccount.setStore(books)
        }
    }
}