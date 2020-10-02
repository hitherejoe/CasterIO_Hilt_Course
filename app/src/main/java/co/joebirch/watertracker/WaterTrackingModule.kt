package co.joebirch.watertracker

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class WaterTrackingModule {

    @Provides
    fun providesPreferencesHelper(
        context: Context
    ) = PreferencesHelper(context)

}