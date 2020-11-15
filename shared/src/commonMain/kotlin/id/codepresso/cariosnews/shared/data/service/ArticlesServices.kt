package id.codepresso.cariosnews.shared.data.service

import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.domain.model.ArticlesResponse
import id.codepresso.cariosnews.shared.data.mapper.Mapper
import id.codepresso.cariosnews.shared.domain.Error
import id.codepresso.cariosnews.shared.domain.Resource
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

class ArticlesServices(
    private val apiKey: String,
    private val baseUrl: String,
    private val mapper: Mapper<ArticlesResponse, List<Article>>) {

    private fun HttpRequestBuilder.apiUrl(path: String? = null) {
        url {
            takeFrom(baseUrl).parameters.append("apiKey", apiKey)
            path?.let { encodedPath = it }
        }
    }

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getArticles(): Resource<List<Article>> {
        val httpRequest = client.get<HttpStatement> {
            apiUrl()
            parameter("country", "id")
        }

        val response = httpRequest.execute()

        return if (response.status.isSuccess()) {
            val json = response.readText()

            val articleResponse = Json {
                isLenient = true
                ignoreUnknownKeys = true
            }.decodeFromString(ArticlesResponse.serializer(), json)

            Resource.success(mapper.transform(articleResponse))
        } else {
            Resource.error(
                Error(response.status.value, response.status.description), null
            )
        }
    }

}