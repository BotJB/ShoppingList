package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(),KodeinAware {
    override val kodein by kodein()
    private val factory:ShopingViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewmodel=ViewModelProvider(this,factory).get(ShopingViewModel::class.java)
        val adapter=ShopingAdapter(listOf(),viewmodel)
        rvItemDisp.layoutManager=LinearLayoutManager(this)
        rvItemDisp.adapter=adapter
        viewmodel.getalllist().observe(this, Observer {
            adapter.itemList=it
            adapter.notifyDataSetChanged()
        })
        fab.setOnClickListener {
            ShopingDialog(this,object :SaveItemDialog{
                override fun saveItem(item: Shopping_item) {
                    viewmodel.upsert(item)
                }

            }).show()
        }
    }
}