package co.joebirch.watertracker.di

import android.content.Context
import co.joebirch.watertracker.PreferencesHelper
import co.joebirch.watertracker.di.scope.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class WaterTrackingModule {

    @Provides
    fun providesPreferencesHelper(
        @ApplicationContext context: Context
    ) = PreferencesHelper(context)

}