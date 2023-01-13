package com.example.composeproject.di

import com.example.composeproject.data.api.ProductApi
import com.example.composeproject.data.api.ProductApi.Companion.BASE_URL
import com.example.composeproject.repo.Repository
import com.example.composeproject.repo.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by OMK on 11/01/23.
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY) })
        .build()

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    @Provides
    fun provideProductApi(retrofit: Retrofit): ProductApi =
        retrofit.create(ProductApi::class.java)


    @Provides
    fun provideRepository(
       productApi: ProductApi
    ): RepositoryImpl {
        return Repository(productApi)
    }
}