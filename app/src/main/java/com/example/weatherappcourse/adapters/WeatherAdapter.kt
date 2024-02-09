package com.example.weatherappcourse.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappcourse.R
import com.example.weatherappcourse.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class WeatherAdapter(val listener: Listener?) : ListAdapter<WeatherModel, WeatherAdapter.Holder>(Comparator()) {

    //класс Холдер принимает вью которое будет заполнять
    class Holder(view: View, listener: Listener?) : RecyclerView.ViewHolder(view) {
        val binding = ListItemBinding.bind(view)
        var itemTemp: WeatherModel? = null

        //прослушиваем нажатие на элемент в этой функции
        init {
            itemView.setOnClickListener {
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }
        //функция которая принимает элемент из списка в холдер и заполняет
        fun bind(item: WeatherModel) = with(binding) {
            itemTemp = item
            tvDate.text = item.time
            tvItemCond.text = item.condition
            tvTemp.text = item.currentTemp.ifEmpty { "${item.maxTemp}°C / ${item.minTemp}°C" }
            Picasso.get().load("https:" + item.imageUrl).into(im)

        }

    }
//следит за новыми элементами нужно ли перезаполнить вью
    class Comparator : DiffUtil.ItemCallback<WeatherModel>() {
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == oldItem
        }

    }


//создание вью из контекста парент который использует разметку list_item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view, listener)
    }

    //заполнение Вью холдером
    override fun onBindViewHolder(holder: Holder, position: Int) {
        //берем из WeatherModel позицию item'a
        holder.bind(getItem(position))
    }

    interface Listener {
        fun onClick(item: WeatherModel) {
        }
    }
}