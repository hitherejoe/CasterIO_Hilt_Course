package co.joebirch.watertracker.di

import androidx.lifecycle.SavedStateHandle
import co.joebirch.watertracker.PreferencesHelper
import co.joebirch.watertracker.WaterTrackingViewModel
import javax.inject.Inject

class WaterTrackerViewModelFactory @Inject constructor(
    private val preferencesHelper: PreferencesHelper
) : SavedStateViewModelFactory<WaterTrackingViewModel> {

    override fun create(handle: SavedStateHandle): WaterTrackingViewModel {
        return WaterTrackingViewModel(
            handle,
            preferencesHelper
        )
    }
}
