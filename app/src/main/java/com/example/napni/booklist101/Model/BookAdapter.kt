package com.example.napni.booklist101.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.napni.booklist101.R
import kotlinx.android.synthetic.main.book_view.view.*

class BookAdapter(context: Context?, books: ArrayList<Book>?, resource: Int = R.layout.book_view) : ArrayAdapter<Book>(context, resource, books) {

    val activity = context
    val books = books
    val layout = resource

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(activity)
        val rowView = inflater.inflate(layout, null, true)
        var book = books!![position]
        rowView.title.text = "%s (%d)".format(book.title, book.publicationYear)
        rowView.price.text = "[%.2f Baht]".format(book.price)
        return rowView
    }

}