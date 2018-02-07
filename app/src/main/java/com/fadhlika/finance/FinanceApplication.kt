package com.fadhlika.finance

import android.app.Application
import com.fadhlika.finance.ViewModel.ViewModel
import io.realm.Realm
import io.realm.RealmConfiguration


/**
 * Created by fadh on 06/02/2018.
 */

class FinanceApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder().build()
        Realm.deleteRealm(realmConfiguration) // Clean slate
        Realm.setDefaultConfiguration(realmConfiguration) // Make this Realm the default

        ViewModel.init()
    }
}