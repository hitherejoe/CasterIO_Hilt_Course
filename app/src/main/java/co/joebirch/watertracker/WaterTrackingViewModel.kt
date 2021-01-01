package co.joebirch.watertracker

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class WaterTrackingViewModel @ViewModelInject constructor(
    private val preferencesHelper: PreferencesHelper,
    @Assisted private val savedStateHandle: SavedStateHandle,
): ViewModel(), WaterIntakePreferenceListener {

    private val _liveData = MutableLiveData<Int>()
    val liveData: LiveData<Int> = _liveData

    init {
        preferencesHelper.subscribeToWaterIntakeChanges(this)
        _liveData.postValue(preferencesHelper.getWaterIntake())
    }

    override fun onCleared() {
        preferencesHelper.unsubscribeFromWaterIntakeChanges()
        super.onCleared()
    }

    fun incrementWaterIntake() {
        preferencesHelper.incrementWaterIntake()
    }

    fun retrieveWaterIntake(): Int {
        return preferencesHelper.getWaterIntake()
    }

    override fun onWaterIntakeChanged(waterIntake: Int) {
        _liveData.postValue(waterIntake)
    }

}