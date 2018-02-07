package com.fadhlika.finance.DataModel

import com.fadhlika.finance.Model.Expense
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where

/**
 * Created by fadh on 06/02/2018.
 */
class DataModel : IDataModel {

    private var realm: Realm = Realm.getDefaultInstance()

    override fun getAllExpenses(): RealmResults<Expense> {
        return realm.where<Expense>().findAllAsync()
    }

    override fun insertExpense(exp: Expense) {
        realm.executeTransaction {
            it.copyToRealm(exp)
        }
    }

}