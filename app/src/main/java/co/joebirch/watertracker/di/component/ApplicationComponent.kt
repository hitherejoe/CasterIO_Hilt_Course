package co.joebirch.watertracker.di.component

import android.app.Application
import android.content.Context
import co.joebirch.watertracker.WaterTrackerApplication
import co.joebirch.watertracker.di.ApplicationModule
import co.joebirch.watertracker.di.scope.ApplicationContext
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(activity: WaterTrackerApplication)

    @ApplicationContext
    fun context(): Context
}