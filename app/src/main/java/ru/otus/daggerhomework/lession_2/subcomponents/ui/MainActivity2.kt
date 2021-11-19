package ru.otus.daggerhomework.lession_2.subcomponents.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.lession_2.subcomponents.DaggerParentComponent
import ru.otus.daggerhomework.lession_2.subcomponents.MainActivityComponent2
import ru.otus.daggerhomework.lession_2.subcomponents.MainActivityPresenter2
import ru.otus.daggerhomework.lession_2.subcomponents.MemoryCache
import javax.inject.Inject

class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var presenterActivityPresenter: MainActivityPresenter2

    lateinit var activityComponent2: MainActivityComponent2

    @Inject
    lateinit var memoryCache: MemoryCache

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val appComponent = DaggerParentComponent.create()

        appComponent.mainActivityComponent()
            .create()
            .also { activityComponent2 = it }
            .inject(this)


        Log.i("11111", "onCreate: ${memoryCache.hashCode()}")
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, Fragment2(), Fragment2.TAG)
            .commit()
    }
}