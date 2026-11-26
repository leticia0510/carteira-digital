package com.avanade.carteiradigital

import com.avanade.carteiradigital.di.databaseModule
import com.avanade.carteiradigital.di.repositoryModule
import com.avanade.carteiradigital.di.useCaseModule
import com.avanade.carteiradigital.di.viewModelModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.getValue

class CarteiraDigitalApplication : android.app.Application() {

    override fun onCreate() {

        super.onCreate()

        startKoin {
            androidContext(this@CarteiraDigitalApplication)
            modules(
                databaseModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }

        CoroutineScope(Dispatchers.IO).launch {
            // databaseSeeder.seed()
        }
    }
}