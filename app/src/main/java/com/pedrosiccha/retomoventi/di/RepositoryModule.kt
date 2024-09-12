package com.pedrosiccha.retomoventi.di

import android.content.Context
import androidx.room.Room
import com.pedrosiccha.retomoventi.data.local.dao.PokemonDao
import com.pedrosiccha.retomoventi.data.local.database.PokemonDatabase
import com.pedrosiccha.retomoventi.data.remote.PokemonApiService
import com.pedrosiccha.retomoventi.data.repository.PokemonRepositoryImpl
import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonApiService(okHttpClient: OkHttpClient): PokemonApiService {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(PokemonApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PokemonDatabase::class.java,
            "pokemon_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providePokemonDao(pokemonDatabase: PokemonDatabase): PokemonDao {
        return pokemonDatabase.pokemonDao()
    }

    @Provides
    @Singleton
    fun providePokemonRepository(
        apiService: PokemonApiService,
        pokemonDao: PokemonDao
    ): PokemonRepository {
        return PokemonRepositoryImpl(apiService, pokemonDao)
    }
}