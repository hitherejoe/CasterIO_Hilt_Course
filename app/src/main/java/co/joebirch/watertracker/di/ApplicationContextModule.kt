package co.joebirch.watertracker.di

import android.content.Context
import co.joebirch.watertracker.di.scope.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface ApplicationContextModule {

    @Binds
    @ApplicationContext
    fun bindApplicationContent(@dagger.hilt.android.qualifiers.ApplicationContext context: Context): Context

}