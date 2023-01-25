package ru.stas.fitnesstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.stas.fitnesstest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lessonApi = RetrofitHelper.getInstance().create(LessonApi::class.java)
        GlobalScope.launch {
            val result = lessonApi.getLessons(clubId = 2)
            Log.d("ayush: ", result.body().toString())
        }
        val manager = LinearLayoutManager(this)
        val adapter = LessonsListAdapter(listOf())
        binding.lessonsGrid.adapter = adapter
        binding.lessonsGrid.layoutManager = manager

    }
}