package com.fadhlika.finance.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fadhlika.finance.HistoryAdapter
import com.fadhlika.finance.R
import com.fadhlika.finance.ViewModel.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment : Fragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    private var historyRecyclerview: RecyclerView? = null
    private var historyAdapter: HistoryAdapter? = null
    private var dividerItemDecoration: DividerItemDecoration? = null

    private var viewModel: ViewModel? = null

    private var compositeDisposable: CompositeDisposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        viewModel = ViewModel.getInstance()!!

        dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)

        historyRecyclerview = view.history_rv
        historyRecyclerview?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        historyRecyclerview?.addItemDecoration(dividerItemDecoration)

        return view
    }

    override fun onResume() {
        super.onResume()

        compositeDisposable = CompositeDisposable()
        compositeDisposable?.add(viewModel?.getAllExpense()!!
                .asFlowable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    historyAdapter = HistoryAdapter(it.toList())
                    historyRecyclerview?.adapter = historyAdapter
                }))
    }

    override fun onPause() {
        compositeDisposable?.dispose()
        super.onPause()
    }


    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): HistoryFragment {
            val fragment = HistoryFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
