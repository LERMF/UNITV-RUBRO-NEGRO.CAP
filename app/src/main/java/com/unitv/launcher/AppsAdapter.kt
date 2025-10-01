package com.unitv.launcher

import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class AppsAdapter(
    private val apps: List<AppInfo>,
    private val onAppClick: (AppInfo) -> Unit
) : RecyclerView.Adapter<AppsAdapter.AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bind(apps[position], onAppClick)
    }

    override fun getItemCount(): Int = apps.size

    class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val appIcon: ImageView = itemView.findViewById(R.id.appIcon)
        private val appName: TextView = itemView.findViewById(R.id.appName)
        private val cardView: CardView = itemView as CardView

        fun bind(appInfo: AppInfo, onAppClick: (AppInfo) -> Unit) {
            appIcon.setImageDrawable(appInfo.icon)
            appName.text = appInfo.label

            cardView.setOnClickListener {
                onAppClick(appInfo)
            }

            cardView.setOnKeyListener { _, keyCode, event ->
                if (event.action == KeyEvent.ACTION_DOWN && 
                    (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER)) {
                    onAppClick(appInfo)
                    true
                } else {
                    false
                }
            }

            cardView.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(itemView.context, R.color.red)
                    )
                    cardView.cardElevation = 12f
                } else {
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(itemView.context, R.color.card_background)
                    )
                    cardView.cardElevation = 4f
                }
            }
        }
    }
}
