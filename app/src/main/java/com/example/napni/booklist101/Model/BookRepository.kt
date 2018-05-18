package com.example.napni.booklist101.Model

import java.util.*
import kotlin.collections.ArrayList

abstract class BookRepository : Observable() {

    lateinit var books: ArrayList<Book>

    abstract fun loadAllBooks()

    open fun getBook(): ArrayList<Book> {
        if( books == null ) {
            books = ArrayList()
        }
        return books
    }

    fun seach(name: String): ArrayList<Book> {
        val searched = ArrayList<Book>()
        books.forEach { it ->
            var year = -1
            try {
                year = name.toInt()
            } catch (ex: Exception) {
//                doing nothing
            }
            if (it.title.toLowerCase().contains(name.toLowerCase()) || it.publicationYear == year ) {
                searched.add(it)
            }
        }
        return searched
    }
}