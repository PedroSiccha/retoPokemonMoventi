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

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    // Proveer el interceptor de logging para monitorear los request y response
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Puedes cambiar el nivel a BASIC o HEADERS si prefieres menos detalle
        }
    }

    // Proveer OkHttpClient con el interceptor de logging
    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    // Proveer instancia de Retrofit para interactuar con la API de Pokémon
    @Provides
    @Singleton
    fun providePokemonApiService(okHttpClient: OkHttpClient): PokemonApiService {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)  // Usa OkHttpClient con el interceptor
            .build()
            .create(PokemonApiService::class.java)
    }

    // Proveer instancia de la base de datos local (Room)
    @Provides
    @Singleton
    fun providePokemonDatabase(context: Context): PokemonDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PokemonDatabase::class.java,
            "pokemon_db"
        ).build()
    }

    // Proveer instancia del DAO de Pokémon para acceder a la base de datos local
    @Provides
    @Singleton
    fun providePokemonDao(pokemonDatabase: PokemonDatabase): PokemonDao {
        return pokemonDatabase.pokemonDao()
    }

    // Proveer el repositorio de Pokémon usando la API y el DAO
    @Provides
    @Singleton
    fun providePokemonRepository(
        apiService: PokemonApiService,
        pokemonDao: PokemonDao
    ): PokemonRepository {
        return PokemonRepositoryImpl(apiService, pokemonDao)
    }
}