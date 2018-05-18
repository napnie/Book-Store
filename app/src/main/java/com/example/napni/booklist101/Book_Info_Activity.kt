package com.example.napni.booklist101

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.book_info.*

class Book_Info_Activity : AppCompatActivity() {

    var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_info)

        val book = intent.extras.getBundle("book")

        id = book.getInt("id")

        book_id.text = "ID: " + id
        book_title.text = "Title: " + book.getString("title")
        book_price.text = "Price: " + book.getDouble("price") + " Baht"
        book_public.text = "Publication Year: " + book.getInt("publicationYear")

        val loader = ImageLoader(book_image, book.getString("imageURL"))
    }

    fun addCartClicked(view : View) {
        BookStoreAccount.addBook(id)
    }

    inner class ImageLoader(val view: ImageView, val url : String) : AsyncTask<String, String, Bitmap>() {


        override fun doInBackground(vararg p0: String?): Bitmap {
            val load = java.net.URL(url).openStream()
            return BitmapFactory.decodeStream(load)
        }

        override fun onPostExecute(result: Bitmap?) {
            view.setImageBitmap(result)
        }

    }

}
