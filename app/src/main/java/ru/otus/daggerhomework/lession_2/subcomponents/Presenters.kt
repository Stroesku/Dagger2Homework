package ru.otus.daggerhomework.lession_2.subcomponents

import android.util.Log
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import javax.inject.Inject

//---------------------------MainActivityPresenter2------------------------------------------
interface MainActivityPresenter2 {
    fun doSomething()
}

class MainActivityPresenter2Impl @Inject constructor(
    memoryCache: MemoryCache
) : MainActivityPresenter2 {

    init {
        memoryCache.put("first", "100")
    }

    override fun doSomething() {
        TODO("Not yet implemented")
    }
}

//---------------------------Fragment2Presenter------------------------------------------

interface Fragment2Presenter {
    fun save()
}

class Fragment2PresenterImpl @AssistedInject constructor(
    @Assisted private val id: String,
    private val cache: MemoryCache
) : Fragment2Presenter {

    override fun save() {
        Log.i("11111", "save: $id")
        cache.put("second", id)
    }
}
