package com.fadhlika.finance.ViewModel

import com.fadhlika.finance.DataModel.DataModel
import com.fadhlika.finance.DataModel.IDataModel
import com.fadhlika.finance.Model.Expense
import io.realm.RealmResults

/**
 * Created by fadh on 06/02/2018.
 */
class ViewModel {
    private val dataModel: IDataModel = DataModel()

    fun getAllExpense(): RealmResults<Expense> {
        return dataModel.getAllExpenses()
    }

    fun insertExpense(exp: Expense) {
        dataModel.insertExpense(exp)
    }

    companion object {
        private var viewModel: ViewModel? = null

        fun init() {
            viewModel = ViewModel()
        }

        fun getInstance(): ViewModel? {
            return viewModel
        }
    }
}