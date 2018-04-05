package com.example.napni.booklist101.Model

class MockBookRepository : BookRepository() {
    val bookList = ArrayList<Book>()

    override fun getBook(): ArrayList<Book> {
        return bookList
    }

    override fun loadAllBooks() {
        bookList.clear()
        bookList.add(Book("How to win election",1,  500.0))
        bookList.add(Book("How to Walk",2,  200.0))
        bookList.add(Book("How to Ate",3,  100.0))
        setChanged()
        notifyObservers()
    }

}