package com.br.teste_catho.domain.usecase

import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.domain.repository.SessionRepository
import com.br.teste_catho.test
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations.initMocks

internal class GetUserUseCaseTest {

    @Mock
    private lateinit var sessionRepository: SessionRepository

    private lateinit var useCase: GetUserUseCase

    @Before
    fun setup() {
        initMocks(this)
        useCase = Mockito.spy(GetUserUseCase(sessionRepository))
    }

    @Test
    fun `when user call invoke should return flowable User`() = test {

        val user = flow { emit(User()) }
        var userResponse :User? = null

        act {
            whenever(sessionRepository.getUser()).thenReturn(user)
        }
        arrange {
            useCase.invoke().collect { userResponse = it }
        }
        assert {
            verify(sessionRepository).getUser()
            assertNotNull(userResponse)
        }
    }
}