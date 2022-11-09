package com.example.fcm.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.fcm.api.ShoppingAPI
import com.example.fcm.data.local.ShoppingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(Application::class)
object AppModule {
    @Singleton
    @Provides
    fun provideShoppingItemDatabase(context : Context) = Room.databaseBuilder(context,
        ShoppingDatabase::class.java,"shopping_db")

    @Singleton
    @Provides
    fun provideDao(database: ShoppingDatabase){
         database.shoppingDao()
    }
    @Singleton
    @Provides
    fun providePixbayApi() : ShoppingAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pixabay.com/")
            .build()
            .create(ShoppingAPI::class.java)
    }
}