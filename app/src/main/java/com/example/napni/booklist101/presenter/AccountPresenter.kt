package com.example.napni.booklist101.presenter

import com.example.napni.booklist101.BookStoreAccount
import java.util.*

class AccountPresenter( val view: AccountView, 
                        val act: BookStoreAccount): Observer {

    fun start() {
        act.addObserver(this)
        act.deposit(0.0)
    }

    override fun update(p0: Observable?, p1: Any?) {
        if( p0 == act ) {
            view.updateFund(act.getFund())
            view.updateShelf(act.getShelf())
            view.updateCart(act.getCart())
        }
    }

}