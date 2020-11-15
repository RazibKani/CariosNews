package id.codepresso.cariosnews.shared.data.service

import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.data.mapper.Mapper
import id.codepresso.cariosnews.shared.domain.ApiEmptyResponse
import id.codepresso.cariosnews.shared.domain.ApiErrorResponse
import id.codepresso.cariosnews.shared.domain.ApiResponse
import id.codepresso.cariosnews.shared.domain.ApiSuccessResponse
import id.codepresso.cariosnews.shared.domain.model.ArticlesResponse
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

class ArticlesServiceImpl(
    private val apiKey: String,
    private val baseUrl: String,
    private val mapper: Mapper<ArticlesResponse, List<Article>>
) : ArticlesService {

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

    override suspend fun getArticles(): ApiResponse<List<Article>> {
        val httpRequest = client.get<HttpStatement> {
            apiUrl()
            parameter("country", "id")
        }

        val response = httpRequest.execute()

        val statusCode = response.status.value

        return if (response.status.isSuccess()) {
            val jsonStringResponse = response.readText()

            if (statusCode == 204) {
                ApiEmptyResponse()
            } else {
                val articleResponse = Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }.decodeFromString(ArticlesResponse.serializer(), jsonStringResponse)

                ApiSuccessResponse(
                    mapper.transform(articleResponse)
                )
            }
        } else {
            val errorMsg = response.status.description
            ApiErrorResponse(statusCode, errorMsg)
        }
    }

}