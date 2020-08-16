package com.example.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.core.app.DialogCompat
import kotlinx.android.synthetic.main.dialog.*

class ShopingDialog(context: Context,var savedialogitem:SaveItemDialog) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog)
        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()
            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Name or amount field cannot be empty", Toast.LENGTH_LONG)
                    .show()


            }
            val item=Shopping_item(name,amount.toInt())
            savedialogitem.saveItem(item)
            dismiss()
        }
        btncancel.setOnClickListener {
            cancel()
        }


    }
}