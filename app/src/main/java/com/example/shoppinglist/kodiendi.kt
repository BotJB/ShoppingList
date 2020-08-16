package com.example.shoppinglist

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class kodiendi: Application(),KodeinAware {
    override val kodein: Kodein= Kodein.lazy {
        import(androidXModule(this@kodiendi))
        bind() from singleton{Shoping_Database(instance())  }
    bind() from singleton { ShopingRepository(instance())
    }
        bind() from provider{
            ShopingViewModelFactory(instance())
        }
    }

}