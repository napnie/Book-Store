package com.example.napni.booklist101.Model

class Book(val title: String,
           val id : Int,
           val price : Double = 0.0,
           val publicationYear : Int = 0,
           val imageURL : String = "") {

    override fun toString() : String {
        return "${title} (${price})"
    }
}