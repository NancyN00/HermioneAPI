package com.example.hermioneapi.di

import com.example.hermioneapi.data.HarryPotterApi
import com.example.hermioneapi.repository.GetCharactersRepository
import com.example.hermioneapi.repository.GetRepositoryImplRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


private const val BASE_URL = "https://hp-api.onrender.com/api/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

     @Provides
     @Singleton

     fun provideRetrofit(): HarryPotterApi{
         return Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
             .create(HarryPotterApi::class.java)
     }

      @Provides
      @Singleton
    fun provideRetrofitApi(api: HarryPotterApi): GetCharactersRepository{
        return GetRepositoryImplRepository(api)
    }
}