package com.example.napni.booklist101.Model

import java.util.*
import kotlin.collections.ArrayList

abstract class BookRepository : Observable() {

    abstract fun loadAllBooks()
    abstract fun getBook(): ArrayList<Book>
}