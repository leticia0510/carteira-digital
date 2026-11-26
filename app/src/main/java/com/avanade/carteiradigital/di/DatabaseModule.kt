
package com.avanade.carteiradigital.di

import androidx.room.Room
import com.avanade.carteiradigital.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    single {
        get<AppDatabase>().usuarioDao()
    }
}
