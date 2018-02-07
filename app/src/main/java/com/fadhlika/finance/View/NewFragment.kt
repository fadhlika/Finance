package com.fadhlika.finance.View


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fadhlika.finance.Model.Expense
import com.fadhlika.finance.R
import com.fadhlika.finance.ViewModel.ViewModel
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_new.*
import kotlinx.android.synthetic.main.fragment_new.view.*
import java.text.DateFormat
import java.util.*


class NewFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var viewModel: ViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }

        viewModel = ViewModel.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view: View = inflater.inflate(R.layout.fragment_new, container, false)

        view.date_input.text = DateFormat.getDateInstance().format(Date())
        RxView.clicks(view.add_button)
                .subscribe({
                    val expense = Expense()
                    expense.description = description_input.text.toString()
                    expense.amount = amount_input.text.toString().toFloat()
                    expense.createdDate = DateFormat.getDateInstance().parse(date_input.text.toString())
                    viewModel?.insertExpense(expense)
                })


        // Inflate the layout for this fragment
        return view
    }

    companion object {

        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): NewFragment {
            val fragment = NewFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}
