package co.joebirch.watertracker.di

import android.content.Context
import co.joebirch.watertracker.PreferencesHelper
import co.joebirch.watertracker.di.scope.ApplicationContext
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class WaterTrackingModule {

    @Provides
    fun providesPreferencesHelper(
        @ApplicationContext context: Context
    ) = PreferencesHelper(context)

}