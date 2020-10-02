package co.joebirch.watertracker

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import co.joebirch.watertracker.di.GenericSavedStateViewModelFactory
import co.joebirch.watertracker.di.WaterTrackerViewModelFactory
import co.joebirch.watertracker.di.component.DaggerWaterTrackerFragmentComponent
import kotlinx.android.synthetic.main.fragment_water_tracker.*
import javax.inject.Inject

class WaterTrackerFragment: Fragment() {

    @Inject lateinit var factory: WaterTrackerViewModelFactory
    @Inject lateinit var logger: Logger

    val viewModel: WaterTrackingViewModel by viewModels {
        GenericSavedStateViewModelFactory(
            factory,
            this
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_water_tracker, container)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerWaterTrackerFragmentComponent
            .builder()
            .applicationComponent((activity?.applicationContext as WaterTrackerApplication).appComponent)
            .build()
            .inject(this)
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