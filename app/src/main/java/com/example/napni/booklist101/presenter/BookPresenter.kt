package com.example.napni.booklist101.presenter

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
            view.setBookList(repository.getBook())
        }
    }
}