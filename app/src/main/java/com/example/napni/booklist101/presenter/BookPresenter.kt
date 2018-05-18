package com.example.napni.booklist101.presenter

import com.example.napni.booklist101.Model.Book
import com.example.napni.booklist101.Model.BookRepository
import java.util.*

class BookPresenter(val view: BookView,
                    val repository:BookRepository): Observer {

    fun start() {
        repository.addObserver(this)
        repository.loadAllBooks()
    }

    override fun update(p0: Observable?, p1: Any?) {
        if( p0 == repository) {
            if( p1 != null) {
                val search = p1 as ArrayList<Book>
                view.setBookList(search)
            } else {
                view.setBookList(repository.getBook())
            }
        }
    }
}