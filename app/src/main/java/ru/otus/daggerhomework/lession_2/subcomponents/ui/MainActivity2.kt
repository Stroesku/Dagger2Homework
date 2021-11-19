package ru.otus.daggerhomework.lession_2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.lession_2.subcomponents.DaggerParentComponent
import ru.otus.daggerhomework.lession_2.subcomponents.MainActivityComponent2
import ru.otus.daggerhomework.lession_2.subcomponents.MainActivityPresenter2
import ru.otus.daggerhomework.lession_2.subcomponents.ui.Fragment2
import javax.inject.Inject

class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var presenterActivityPresenter: MainActivityPresenter2

    lateinit var activityComponent2: MainActivityComponent2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        DaggerParentComponent.create()
            .mainActivityComponent()
            .build()
            .also { activityComponent2 = it }
            .inject(this)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, Fragment2(), Fragment2.TAG)
            .commit()
    }
}