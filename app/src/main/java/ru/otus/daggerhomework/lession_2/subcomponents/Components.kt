package ru.otus.daggerhomework.lession_2.subcomponents

import dagger.*
import ru.otus.daggerhomework.lession_2.subcomponents.ui.Fragment2
import ru.otus.daggerhomework.lession_2.subcomponents.ui.MainActivity2
import javax.inject.Singleton


//______________________________ParentComponent(Application)________________________________________
/**
 * Предсавляет из себя обычный компонент, который будет неким entryPoint в нашей иерархии зависомостей
 * Ни от кого не зависит
 * Является родителем для MainActivityComponent2
 */

@Component(modules = [ParentModule::class])
@Singleton
interface ParentComponent {

    fun mainActivityComponent(): MainActivityComponent2.Factory

}

@Module(subcomponents = [MainActivityComponent2::class])
interface ParentModule {

    /**
     * MemoryCache получаем на уровне ParentComponent, так как он нужен нам на протяжении жизни всего приложения
     */
    @Binds
    @Singleton
    fun bindsMemoryCache(memoryCacheImpl: MemoryCacheImpl): MemoryCache

}


//_______________________MainActivityComponent (MainActivity2)______________________________________

/**
 * Более низкий по иерархии компонент
 * Является Subcomponent от нашего ParentComponent
 * Создается тогда, когда создается activity
 * Потенциально может захотеть юзать memoryCache
 * Является родителем для FragmentComponent2
 */
@ActivityScope2
@Subcomponent(modules = [MainActivityModule2::class])
interface MainActivityComponent2 {

    fun inject(mainActivity: MainActivity2)

    fun fragmentComponent(): FragmentComponent2.Factory

    @Subcomponent.Builder
    interface Factory {

        fun create(): MainActivityComponent2
    }
}

@Module(subcomponents = [FragmentComponent2::class])
interface MainActivityModule2 {

    @Binds
    @ActivityScope2
    fun bindsMainPresenter(mainActivityPresenterImpl: MainActivityPresenter2Impl): MainActivityPresenter2
}

//_______________________FragmentComponent(Fragment2)______________________________________________


@FragmentScope2
@Subcomponent(modules = [FragmentModule2::class])
interface FragmentComponent2 {

    fun inject(fragment: Fragment2)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance id: String): FragmentComponent2
    }
}

/**
 * Я могу во fragmentComponent инжектить те значения, которые у меня присутствуют в моей иерархии
 */
@Module
interface FragmentModule2 {

    @Binds
    @FragmentScope2
    fun bindsFragmentPresenter(fragment2PresenterImpl: Fragment2PresenterImpl): Fragment2Presenter
}


//----------------------------------------------------------------------------------------------------

