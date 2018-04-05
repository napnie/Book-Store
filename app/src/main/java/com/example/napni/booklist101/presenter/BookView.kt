package com.example.napni.booklist101.presenter

import com.example.napni.booklist101.Model.Book

interface BookView {

    fun setBookList(books: ArrayList<Book>)
}