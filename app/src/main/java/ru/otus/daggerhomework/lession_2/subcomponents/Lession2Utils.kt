package ru.otus.daggerhomework.lession_2.subcomponents

import javax.inject.Inject
import javax.inject.Scope

interface MemoryCache {
    fun put(key: String, value: Any)
    fun <T> get(key: String): T?
}

class MemoryCacheImpl @Inject constructor() : MemoryCache {

    private val cacheStorage: MutableMap<String, Any> = LinkedHashMap(40)

    override fun put(key: String, value: Any) {
        cacheStorage[key] = value
    }

    override fun <T> get(key: String): T? {
        return cacheStorage[key] as? T
    }
}

//________________________________________________________________________________________________

@Scope
annotation class ActivityScope2

@Scope
annotation class FragmentScope2