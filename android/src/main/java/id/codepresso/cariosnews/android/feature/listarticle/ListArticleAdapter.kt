package id.codepresso.cariosnews.android.feature.listarticle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.codepresso.cariosnews.android.databinding.ItemArticleBinding
import id.codepresso.cariosnews.shared.data.entity.Article

/**
 * Crafted by Razib Kani Maulidan on 22/11/20.
 **/

class ListArticleAdapter : RecyclerView.Adapter<ListArticleViewHolder>() {

    var articleList = listOf<Article>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListArticleViewHolder {
        val itemBinding =
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return ListArticleViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ListArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount() = articleList.size
}