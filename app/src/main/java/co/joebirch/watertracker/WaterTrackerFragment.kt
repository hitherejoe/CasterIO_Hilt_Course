package co.joebirch.watertracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_water_tracker.*
import javax.inject.Inject

class WaterTrackerFragment: Fragment(), WaterIntakePreferenceListener {

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_water_tracker, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        waterCountText.text = preferencesHelper.getWaterIntake().toString()

        trackWaterButton.setOnClickListener {
            preferencesHelper.incrementWaterIntake()
        }
        preferencesHelper.subscribeToWaterIntakeChanges(this)
    }

    override fun onDestroyView() {
        preferencesHelper.unsubscribeFromWaterIntakeChanges()
        super.onDestroyView()
    }

    override fun onWaterIntakeChanged(waterIntake: Int) {
        waterCountText.text = waterIntake.toString()
    }

}