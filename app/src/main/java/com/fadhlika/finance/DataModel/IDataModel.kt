package com.fadhlika.finance.DataModel

/**
 * Created by fadh on 06/02/2018.
 */

import com.fadhlika.finance.Model.Expense
import io.realm.RealmResults

interface IDataModel {

    fun getAllExpenses(): RealmResults<Expense>

    fun insertExpense(exp: Expense)
}