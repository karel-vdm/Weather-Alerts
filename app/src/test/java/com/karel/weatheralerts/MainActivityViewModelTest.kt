package com.karel.weatheralerts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.karel.weatheralerts.domain.UseCaseGetWeatherAlerts
import com.karel.weatheralerts.presentation.MainActivityViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@OptIn(ExperimentalCoroutinesApi::class)
class MainActivityViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val sut = MainActivityViewModel(
        useCaseGetWeatherAlerts = UseCaseGetWeatherAlerts(
            weatherRepository = WeatherRepositoryMock()
        )
    )

    @Test
    fun `given loading state, when get alerts called, then update loading state`() = runTest {
        //given
        sut.setLoading(true)

        //when
        sut.onCreate()

        //then
        assertEquals(false, sut.isLoading.getOrAwaitValue())
    }

    @Test
    fun `given loading state, when get alerts called, then update error state`() = runTest {
        //given
        sut.setLoading(true)

        //when
        sut.onCreate()

        //then
        assertEquals("", sut.error.getOrAwaitValue())
    }

    @Test
    fun `given loading state, when get alerts called, then alerts error state`() = runTest {
        //given
        sut.setLoading(true)

        //when
        sut.onCreate()

        //then
        assertEquals(1, sut.weatherAlerts.getOrAwaitValue().weatherAlerts.size)
    }
}

fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(o: T) {
            data = o
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }

    this.observeForever(observer)

    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("value was not set")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}