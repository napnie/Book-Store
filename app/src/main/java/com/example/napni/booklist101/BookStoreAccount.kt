package com.example.napni.booklist101

import com.example.napni.booklist101.Model.Book

object BookStoreAccount {

    private var balance : Double
    private var cart : ArrayList<Book>
    private var bookshelf : ArrayList<Book>

    init {
        balance = 0.0
        cart = ArrayList()
        bookshelf = ArrayList()
    }

    fun deposit(fund : Double) {
        balance += fund
    }

    fun withdraw(withdraw: Double) : Boolean {
        if( balance >= withdraw) {
            balance -= withdraw
            return true
        }
        return false
    }

    fun getFund() : Double {
        return balance
    }

    fun addBook(book : Book) {
        cart.add(book)
    }

    fun checkOut(): Boolean {
        var totalPrice = 0.0
        cart.forEach { book -> totalPrice += book.price }
        if( balance >= totalPrice ) {
            balance -= totalPrice
            bookshelf.addAll(cart)
            cart.clear()
            return true
        }
        return false
    }

    fun getShelf(): ArrayList<Book> {
        var shelf_clone = ArrayList<Book>()
        shelf_clone.addAll(bookshelf)
        return shelf_clone
    }
}
