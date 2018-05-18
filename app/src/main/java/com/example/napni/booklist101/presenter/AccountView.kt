package com.example.napni.booklist101.presenter

import com.example.napni.booklist101.Model.Book

interface AccountView {

    fun updateFund(fund: Double)

    fun updateCart(cart: ArrayList<Book>)

    fun updateShelf(shelf: ArrayList<Book>)
}