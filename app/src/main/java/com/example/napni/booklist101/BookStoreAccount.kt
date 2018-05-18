package com.example.napni.booklist101

import com.example.napni.booklist101.Model.Book
import java.util.*
import kotlin.collections.ArrayList

object BookStoreAccount : Observable() {

    private var balance : Double
    private var cart : ArrayList<Book>
    private var bookshelf : ArrayList<Book>
    private var store : ArrayList<Book>

    init {
        balance = 0.0
        cart = ArrayList()
        bookshelf = ArrayList()
        store = ArrayList()
    }

    fun setStore(store : ArrayList<Book>) {
        this.store = store
    }

    fun deposit(fund : Double) {
        balance += fund
        setChanged()
        notifyObservers()
    }

    fun withdraw(withdraw: Double) : Boolean {
        if( balance >= withdraw) {
            balance -= withdraw
            setChanged()
            notifyObservers()
            return true
        }
        return false
    }

    fun getFund() : Double {
        return balance
    }

    fun addBook(id : Int) {
        lateinit var book : Book
        for(b in store ) {
            if( b.id == id) {
                book = b
                break
            }
        }

        cart.add(book)
        setChanged()
        notifyObservers()
    }

    fun checkOut(): Boolean {
        var totalPrice = 0.0
        cart.forEach { book -> totalPrice += book.price }
        if( balance >= totalPrice ) {
            balance -= totalPrice
            bookshelf.addAll(cart)
            cart.clear()

            setChanged()
            notifyObservers()
            return true
        }
        return false
    }

    fun getCart() : ArrayList<Book> {
        var cart_clone = ArrayList<Book>()
        cart_clone.addAll(cart)
        return cart_clone
    }

    fun getShelf(): ArrayList<Book> {
        var shelf_clone = ArrayList<Book>()
        shelf_clone.addAll(bookshelf)
        return shelf_clone
    }
}
