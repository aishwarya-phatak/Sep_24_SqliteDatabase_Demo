package com.bitcode.sep_24_sqlitedatabase_demo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class DBUtil(private var context: Context) {

    private val db : SQLiteDatabase = DBHelper(context,"db_products",null,1)
        .writableDatabase

    fun insertProduct(id : Int, title : String, price : Int) : Boolean{
        val values = ContentValues()
        values.put("id",id)
        values.put("title",title)
        values.put("price",price)

        val rowNum = db.insert("Product",null,values)
        Log.e("row number", "$rowNum")

        return rowNum.toInt() != -1
    }

    fun deleteProduct(id : Int){
        val count = db.delete("Product","id=?", arrayOf(id.toString()))
        Log.e("tag", "$count")
    }

    fun updateProduct(id : Int, title : String, price : Int) : Boolean{
        val values = ContentValues()
        values.put("id", id)
        values.put("title",title)
        values.put("price",price)

        val count = db.update("Product",values,"id=?", arrayOf(id.toString()))
        return count != 0
    }

    fun getAllProducts():ArrayList<Product>{

        var products = ArrayList<Product>()
        val c = db.query("Product",null,null,null,null,null,"id desc")

        while (c.moveToNext()){
            val id = c.getInt(0)
            val title = c.getString(1)
            val price = c.getInt(2)

            val newProduct = Product(id,title,price)
            products.add(newProduct)
        }
        c.close()

        return products
    }
}