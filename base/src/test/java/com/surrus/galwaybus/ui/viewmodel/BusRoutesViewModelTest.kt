package com.surrus.galwaybus.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.surrus.galwaybus.domain.interactor.GetBusRoutesUseCase
import com.surrus.galwaybus.domain.model.BusRouteSchedule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock

@RunWith(JUnit4::class)
class BusRoutesViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock lateinit var getBusRoutesUseCase: GetBusRoutesUseCase

    private lateinit var busRoutesViewModel: BusRoutesViewModel

    @Before
    fun setUp() {
        getBusRoutesUseCase = mock()

        Dispatchers.setMain(Dispatchers.Unconfined)
        busRoutesViewModel = BusRoutesViewModel(getBusRoutesUseCase)
    }


    @Test
    fun getRoutes() = runBlocking {
        val busRouteList = mutableListOf<BusRouteSchedule>()
        busRouteList.add(BusRouteSchedule("1", "route 1 long", "route 1", "route 1 pdf"))
        busRouteList.add(BusRouteSchedule("2", "route 2 long", "route 2", "route 2 pdf"))

        whenever(getBusRoutesUseCase.getBusRoutes()).thenReturn(busRouteList)
        val br = busRoutesViewModel.fetchRoutes()
        assert(busRoutesViewModel.getBusRoutes().value == busRouteList)
    }

}
