package br.com.renanbarbieri.bemobichallenge.presentation.ui.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.renanbarbieri.bemobichallenge.GlideApp
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.presentation.model.ImageModel
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_preview.view.*


/**
 * Created by renan on 17/01/18.
 */
class PreviewAdapter(private val context: Context, val data: ArrayList<ImageModel>):
        RecyclerView.Adapter<PreviewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_preview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val currPreview = data[position]
        holder?.bind(currPreview.url)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(previewUrl: String?){

            GlideApp.with(context)
                    .load(previewUrl)
                    .placeholder(R.drawable.placeholder_300x300)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemView.ivItemPreviewImage)
        }
    }
}