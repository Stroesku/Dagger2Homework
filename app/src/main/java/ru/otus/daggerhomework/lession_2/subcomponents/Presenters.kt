package ru.otus.daggerhomework.lession_2.subcomponents

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
    fun doSomething()
}

class Fragment2PresenterImpl @Inject constructor() : Fragment2Presenter {
    override fun doSomething() {
        TODO("Not yet implemented")
    }
}
