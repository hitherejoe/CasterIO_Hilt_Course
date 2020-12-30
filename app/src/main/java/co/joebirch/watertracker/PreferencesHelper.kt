package co.joebirch.watertracker

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

open class PreferencesHelper @Inject constructor(@ApplicationContext context: Context) {

    private val preferences = context.getSharedPreferences("water_tracker_prefs", MODE_PRIVATE)
    private val KEY_WATER_INTAKE = "KEY_WATER_INTAKE"
    private var waterIntakePreferenceListener: WaterIntakePreferenceListener? = null

    open fun getWaterIntake() = preferences.getInt(KEY_WATER_INTAKE, 0)

    fun incrementWaterIntake() {
        val waterIntake = preferences.getInt(KEY_WATER_INTAKE, 0)
        preferences.edit().putInt(KEY_WATER_INTAKE, waterIntake + 1).apply()
    }

    open fun subscribeToWaterIntakeChanges(listener: WaterIntakePreferenceListener) {
        this.waterIntakePreferenceListener = listener
        preferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener)
    }

    fun unsubscribeFromWaterIntakeChanges() {
        this.waterIntakePreferenceListener = null
        preferences.unregisterOnSharedPreferenceChangeListener(sharedPreferencesListener)
    }

    private val sharedPreferencesListener =
        SharedPreferences.OnSharedPreferenceChangeListener { preferences, key ->

            if (key == KEY_WATER_INTAKE) {
                waterIntakePreferenceListener?.onWaterIntakeChanged(
                    preferences.getInt(key, 0)
                )
            }
    }

}