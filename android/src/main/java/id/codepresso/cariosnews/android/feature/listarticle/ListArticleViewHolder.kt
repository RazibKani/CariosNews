package id.codepresso.cariosnews.android.feature.listarticle

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.codepresso.cariosnews.android.databinding.ItemArticleBinding
import id.codepresso.cariosnews.shared.data.entity.Article

/**
 * Crafted by Razib Kani Maulidan on 22/11/20.
 **/

class ListArticleViewHolder(
    private val itemBinding: ItemArticleBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(article: Article) {
        with(itemBinding) {
            ivImage.load(article.urlToImage)
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvAuthorAndDate.text = "${article.author} - ${article.publishedAt}"
        }
    }

    private fun ImageView.load(url: String?) {
        Picasso.get().load(url).into(this)
    }
}