package ru.stas.fitnesstest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.stas.fitnesstest.databinding.ItemListLessonsBinding

class LessonsListAdapter(
    private val lessonsItem: List<Data>,
    ):RecyclerView.Adapter<LessonsListAdapter.LessonViewHolder>() {

    inner class LessonViewHolder(
        private val binding: ItemListLessonsBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Data){
            val result = item.lessons.map { item -> item.startTime}.toString()
            binding.tvTimeStart.text = result
//            binding.tvTimeStart.text = item.lessons.

//            val rvItems = data.lessons.map { SomeRecylcerViewItem() }
//            adapter.addAll(rvItems)
//            binding.tvTimeFinish.text = item.endTime
//            binding.tvCoach.text = item.coach_id
//            binding.tvDate.text = item.date
//            binding.tvTypeOfWorkout.text = item.description
//            binding.tvClassTime.text = item.tab
//            binding.tvPlace.text = item.place
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListLessonsBinding.inflate(inflater,parent,false)
        return LessonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val item = lessonsItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = lessonsItem.size
}