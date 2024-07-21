package org.massana2110.donarapp

import android.app.Application
import di.getSharedModules
import di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.massana2110.donarapp.di.appModule

class DonarApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(appModule + getSharedModules()) {
            androidContext(this@DonarApplication)
            androidLogger()
        }
    }

}