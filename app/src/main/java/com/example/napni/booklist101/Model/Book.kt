package com.example.napni.booklist101.Model

import android.os.Bundle

class Book(val title: String,
           val id : Int,
           val price : Double = 0.0,
           val publicationYear : Int = 0,
           val imageURL : String = "") {

    override fun toString() : String {
        return "${title} (${price})"
    }

    fun toBuddle() : Bundle {
        val bundle = Bundle()

        bundle.putString("title", title)
        bundle.putInt("id", id)
        bundle.putDouble("price", price)
        bundle.putInt("publicationYear", publicationYear)
        bundle.putString("imageURL", imageURL)

        return bundle
    }
}