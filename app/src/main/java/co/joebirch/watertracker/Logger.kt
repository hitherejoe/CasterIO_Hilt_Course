package co.joebirch.watertracker

import timber.log.Timber

class Logger {

    fun configure() = Timber.plant(Timber.DebugTree())

    fun log(message: String) = Timber.d(message)

}