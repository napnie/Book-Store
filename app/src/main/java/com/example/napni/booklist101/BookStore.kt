package com.example.napni.booklist101

import android.os.AsyncTask
import com.example.napni.booklist101.Model.Book
import com.example.napni.booklist101.Model.BookRepository
import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.nio.charset.StandardCharsets

class BookStore: BookRepository() {
//    lateinit var books : ArrayList<Book>
    lateinit var json_string: String
    val book_url = "https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json"

    override fun loadAllBooks() {
        val bx = BxLoaderTask()
        bx.execute()
    }

    fun initBooks() {
        val result = JsonParser().parse(json_string).asJsonArray

        books = ArrayList()
        for( book_element in result) {
            val book_object = book_element.asJsonObject
            books.add( Book(book_object.get("title").asString,
                    book_object.get("id").asInt,
                    book_object.get("price").asDouble,
                    book_object.get("pub_year").asInt,
                    book_object.get("img_url").asString ) )
        }
    }

    override fun getBook(): ArrayList<Book> {
        if( books == null ) {
            books = ArrayList()
        }
        return books
    }

    inner class BxLoaderTask : AsyncTask<String, String, String>() {

        override fun doInBackground(vararg p0: String?): String {
            val url = URL(book_url)
            val json = url.readText()
            return json
        }

        override fun onPostExecute(result: String?) {
            if( result != null) {
                json_string = result
                initBooks()
            }
        }

    }

}
