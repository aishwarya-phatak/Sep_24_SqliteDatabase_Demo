package com.bitcode.sep_24_sqlitedatabase_demo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var dbUtil = DBUtil(this)
//
//        dbUtil.insertProduct(101,"Mixer",2000)
//        dbUtil.insertProduct(102,"Grinder",3000)
//        dbUtil.insertProduct(103,"Cooker",1500)
//        dbUtil.insertProduct(104,"Pan",450)
//        dbUtil.insertProduct(105,"Microwave Oven",30000)

        var arr = dbUtil.getAllProducts()
        for (eachProduct in arr){
            Log.e("tag","Id -- ${eachProduct.id} Title -- ${eachProduct.title} -- " +
                    "Price -- ${eachProduct.price}")
        }


//        dbUtil.deleteProduct(103)
//
//        for (eachProduct in arr){
//            Log.e("tag","Id -- ${eachProduct.id} Title -- ${eachProduct.title} -- " +
//                    "Price -- ${eachProduct.price}")
//        }

//        dbUtil.updateProduct(105,"FryPan",1600)

//        for(eachProduct in arr){
//            Log.e("tag","Id -- ${eachProduct.id} Title -- ${eachProduct.title} " +
//                    "Price -- ${eachProduct.price}")
//        }
    }
}