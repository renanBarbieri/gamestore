package br.com.renanbarbieri.gamestore.presentation.ui.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.renanbarbieri.gamestore.GlideApp
import br.com.renanbarbieri.gamestore.R
import br.com.renanbarbieri.gamestore.presentation.model.BadgeModel
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_badge.view.*


/**
 * Created by renan on 17/01/18.
 */
class BadgeAdapter(private val context: Context, val data: ArrayList<BadgeModel>):
        RecyclerView.Adapter<BadgeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_badge, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val currBadge = data[position]
        holder?.bind(currBadge.description, currBadge.iconURL)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(badgeDescription: String, badgeIconUrl: String?){
            itemView.tvItemBadgeDescription.text = badgeDescription

            GlideApp.with(context)
                    .load(badgeIconUrl)
                    .placeholder(R.drawable.placeholder_300x300)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemView.ivItemBadgeIcon)
        }
    }
}