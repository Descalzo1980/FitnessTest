package ru.stas.fitnesstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lessonApi = RetrofitHelper.getInstance().create(LessonApi::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = lessonApi.getLessons(clubId = 2)
            Log.d("ayush: ", result.body().toString())
        }
    }
}