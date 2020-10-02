package co.joebirch.watertracker.di.component

import co.joebirch.watertracker.WaterTrackerFragment
import co.joebirch.watertracker.di.WaterTrackingModule
import co.joebirch.watertracker.di.scope.FragmentScope
import dagger.Component

@FragmentScope
@Component(
    modules = [WaterTrackingModule::class],
    dependencies = [ApplicationComponent::class]
)
interface WaterTrackerFragmentComponent {

    @Component.Builder
    interface Builder {
        fun build(): WaterTrackerFragmentComponent
        fun applicationComponent(module: ApplicationComponent): Builder
    }

    fun inject(fragment: WaterTrackerFragment)
}