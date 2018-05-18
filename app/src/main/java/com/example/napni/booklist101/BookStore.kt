package com.example.napni.booklist101

import android.os.AsyncTask
import com.example.napni.booklist101.Model.Book
import com.example.napni.booklist101.Model.BookRepository
import org.json.JSONArray
import java.net.URL

class BookStore: BookRepository() {
//    lateinit var books : ArrayList<Book>
    lateinit var json_string: String
    val book_url = "https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json"
    var isLoad = false

    override fun loadAllBooks() {
        val bx = BookLoader()
        if(!isLoad) {
            bx.execute()
            isLoad = true
        } else {
            setChanged()
            notifyObservers()
        }
    }

    fun initBooks() {
        val result = JSONArray(json_string)

        books = ArrayList()
        (0..(result.length()-1)).forEach { it ->
            var jo = result.getJSONObject(it)
            books.add(Book(jo.getString("title"), jo.getInt("id"), jo.getDouble("price"),
                    jo.getInt("pub_year"), jo.getString("img_url")))
        }
    }

    inner class BookLoader : AsyncTask<String, String, String>() {

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
