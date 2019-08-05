package com.tehnovek.coderswag.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tehnovek.coderswag.Adapters.CategoryAdapter
import com.tehnovek.coderswag.Adapters.CategoryRecycleAdapter
import com.tehnovek.coderswag.Model.Category
import com.tehnovek.coderswag.R
import com.tehnovek.coderswag.Services.DataService
import com.tehnovek.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) {
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, it.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layoutManger = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManger
        categoryListView.setHasFixedSize(true)
    }
}
