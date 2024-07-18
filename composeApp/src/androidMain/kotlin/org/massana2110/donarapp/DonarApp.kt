package org.massana2110.donarapp

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class DonarApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@DonarApp)
            androidLogger()
        }
    }

}