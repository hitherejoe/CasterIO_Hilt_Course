package co.joebirch.watertracker.di

import android.app.Application
import android.content.Context
import co.joebirch.watertracker.Logger
import co.joebirch.watertracker.di.scope.ApplicationContext
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @ApplicationContext
    @Provides
    internal fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun providesLogger() = Logger()

}