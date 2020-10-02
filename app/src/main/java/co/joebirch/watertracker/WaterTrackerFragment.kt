package co.joebirch.watertracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_water_tracker.*
import javax.inject.Inject

@AndroidEntryPoint
class WaterTrackerFragment: Fragment() {

    @Inject lateinit var logger: Logger

    val viewModel: WaterTrackingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_water_tracker, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            waterCountText.text = it.toString()
        })

        trackWaterButton.setOnClickListener {
            viewModel.incrementWaterIntake()
        }
    }
}