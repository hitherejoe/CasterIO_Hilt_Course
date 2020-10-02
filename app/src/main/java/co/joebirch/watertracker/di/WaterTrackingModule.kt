package co.joebirch.watertracker.di

import android.content.Context
import co.joebirch.watertracker.PreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class WaterTrackingModule {

    @Provides
    fun providesPreferencesHelper(
        context: Context
    ) = PreferencesHelper(context)

}