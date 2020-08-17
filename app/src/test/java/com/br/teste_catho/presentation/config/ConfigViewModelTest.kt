package com.br.teste_catho.presentation.config

import androidx.lifecycle.MutableLiveData
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.domain.usecase.GetKeysUseCase
import com.br.teste_catho.domain.usecase.GetUserUseCase
import com.br.teste_catho.model.Loading
import com.br.teste_catho.model.Success
import com.br.teste_catho.model.ViewStatus
import com.br.teste_catho.test
import com.nhaarman.mockitokotlin2.*
import junit.framework.Assert
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations.initMocks


class ConfigViewModelTest  {

    @Mock
    private lateinit var getKeysUseCase: GetKeysUseCase

    @Mock
    private lateinit var getUserUseCase: GetUserUseCase

    @Mock
    private lateinit var liveData: MutableLiveData<ViewStatus<User>>

    private lateinit var viewModel: ConfigViewModel

    private val user  by lazy { flow { emit(User()) } }
    private val keys  by lazy { flow { emit(Keys()) } }

    @Before
    fun setup() {
        initMocks(this)
        viewModel = Mockito.spy(ConfigViewModel(getKeysUseCase, getUserUseCase)).apply {
            liveDataResponse = liveData
        }
    }

    @Test
    fun `when view model request is called the status of response should be loading and success`() = test {
        act {
            whenever(getKeysUseCase.invoke()).doReturn(keys)
            whenever(getUserUseCase.invoke()).doReturn(user)
        }
        arrange {
            viewModel.getSessionInfo()
        }
        assert {
            val captor = argumentCaptor<ViewStatus<User>>()
            verify(liveData, times(2)).postValue(captor.capture())
            assert(captor.firstValue is Loading<*>)
            assert(captor.lastValue is Success<*>)
            assertNotNull((captor.lastValue as Success<User>).response)
        }
    }
}