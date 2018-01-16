package br.com.renanbarbieri.bemobichallenge.presentation.ui.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.renanbarbieri.bemobichallenge.GlideApp
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.presentation.model.AppModel
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_app.view.*

/**
 * Created by renan on 16/01/18.
 */
class AppAdapter(private val context: Context, val data: ArrayList<AppModel>): RecyclerView.Adapter<AppAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_app, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val currApp = data[position]
        val currAppPrice = currApp.currency+" "+currApp.price
        val origAppPrice = currApp.currency+" "+currApp.originalPrice

        holder?.setInfo(currApp.name, currAppPrice, origAppPrice, currApp.icon.url)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun setInfo(appName: String, appPrice: String, appOrigPrice: String, appIconUrl: String?){
            itemView.tvAppName.text = appName
            itemView.tvAppPrice.text = appPrice
            itemView.tvAppOriginalPrice.text = appOrigPrice

            GlideApp.with(context)
                    .load(appIconUrl)
                    .placeholder(R.drawable.placeholder_300x300)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemView.ivAppIcon)
        }
    }
}