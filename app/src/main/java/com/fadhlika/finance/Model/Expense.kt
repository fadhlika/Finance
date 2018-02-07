package com.fadhlika.finance.Model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by fadh on 06/02/2018.
 */
open class Expense(@PrimaryKey var id: String = UUID.randomUUID().toString(),
                   var createdDate: Date = Date(),
                   var description: String = "",
                   var amount: Float = 0.0f) : RealmObject()