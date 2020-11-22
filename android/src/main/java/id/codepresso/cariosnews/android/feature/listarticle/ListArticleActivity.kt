package id.codepresso.cariosnews.android.feature.listarticle

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.codepresso.cariosnews.android.databinding.ActivityListArticleBinding
import id.codepresso.cariosnews.android.feature.base.BaseActivity
import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.domain.Resource
import id.codepresso.cariosnews.shared.presentation.feature.ListArticleViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.inject

/**
 * Crafted by Razib Kani Maulidan on 22/11/20.
 **/

@ExperimentalCoroutinesApi
class ListArticleActivity : BaseActivity() {

    private val viewModel by inject<ListArticleViewModel>()
    private val listArticleAdapter by lazy { ListArticleAdapter() }
    private val linearLayoutManager by lazy { LinearLayoutManager(this) }

    private lateinit var binding: ActivityListArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subscribeListArticles()
        setupViews()
    }

    private fun setupViews() {
        with(binding) {
            rvListArticle.apply {
                layoutManager = linearLayoutManager
                adapter = listArticleAdapter
            }
        }
    }

    private fun subscribeListArticles() {
        viewModel.articlesResource.watch { resource ->
            when (resource.state) {
                Resource.State.LOADING -> {
                    showLoadingState()
                }
                Resource.State.SUCCESS -> {
                    hideLoadingState()
                    resource.data?.let { listArticle ->
                        showData(listArticle)
                    }
                }
                Resource.State.ERROR -> {
                    hideLoadingState()
                    resource.error?.let { error ->
                        showErrorMessage(error.code, error.message)
                    }
                }
            }
        }
    }

    private fun showLoadingState() {
        with(binding) {
            pbLoading.visibility = View.VISIBLE
            rvListArticle.visibility = View.GONE
        }
    }

    private fun hideLoadingState() {
        with(binding) {
            pbLoading.visibility = View.GONE
            rvListArticle.visibility = View.VISIBLE
        }
    }

    private fun showData(listArticle: List<Article>) {
        listArticleAdapter.articleList = listArticle
    }

    private fun showErrorMessage(code: Int, errorMessage: String?) {
        Toast.makeText(this,
            "ERROR -> Code: $code, Message: $errorMessage"
            , Toast.LENGTH_LONG)
            .show()
    }
}