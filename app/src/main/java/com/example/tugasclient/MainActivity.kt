package com.example.tugasclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.tugasclient.helper.MyRetrofit
import com.example.tugasclient.model.MyModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textMain = findViewById<TextView>(R.id.text_main)

        val myServ = MyRetrofit.create()

        myServ.getPosts().enqueue(object : Callback<List<MyModel>> {
            override fun onFailure(call: Call<List<MyModel>>, err: Throwable) {
                Log.e("Error", "Ada Error ini gan : ${err.message}")
            }

            override fun onResponse(call: Call<List<MyModel>>, response: Response<List<MyModel>>) {
                if(response.isSuccessful){
                    val data = response.body()
                    val builder = StringBuilder()

                    data?.map {
                        builder.append(it.body)
                    }
                    textMain.setText(builder.toString())

                }
            }
        })

    }
}
