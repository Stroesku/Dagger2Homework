package ru.otus.daggerhomework.lession_2.subcomponents.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.lession_2.subcomponents.Fragment2Presenter
import ru.otus.daggerhomework.lession_2.subcomponents.MemoryCache
import javax.inject.Inject

class Fragment2 : Fragment() {

    companion object {
        const val TAG = "Fragment2"
    }

    @Inject
    lateinit var memoryCache: MemoryCache

    @Inject
    lateinit var presenter: Fragment2Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as MainActivity2)
            .activityComponent2
            .fragmentComponent()
            .create("1111")
            .inject(this)

        Log.i("11111", memoryCache.hashCode().toString() ?: "null empty")

        presenter.save()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_2, container, false)
    }
}