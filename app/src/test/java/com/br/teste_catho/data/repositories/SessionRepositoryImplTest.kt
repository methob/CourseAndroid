package com.br.teste_catho.data.repositories

import com.br.teste_catho.data.local.source.SessionLocalDataSource
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.data.remote.source.SessionRemoteDataSource
import com.br.teste_catho.domain.repository.SessionRepository
import com.br.teste_catho.test
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations.initMocks

class SessionRepositoryImplTest {

    @Mock
    private lateinit var sessionLocalDataSource: SessionLocalDataSource

    @Mock
    private lateinit var sessionRemoteDataSource: SessionRemoteDataSource

    @Mock
    private lateinit var collector: FlowCollector<Any>

    private lateinit var sessionRepository: SessionRepository

    private val user: User by lazy { User() }
    private val keys : Keys by lazy { Keys() }

    @Before
    fun setup() {
        initMocks(this)
        sessionRepository = Mockito.spy(SessionRepositoryImpl(sessionLocalDataSource, sessionRemoteDataSource))
    }

    @InternalCoroutinesApi
    @Test
    fun `when session repositories keys is called, the methods of get remote and save database should be called`() = test {
        act {
            whenever(sessionRemoteDataSource.getKeys()).doReturn(keys)
            whenever(sessionLocalDataSource.getKeys()).doReturn(keys)
        }
        arrange {
            sessionRepository.getKeys().collect(collector)
        }
        assert {
            verify(sessionRemoteDataSource).getKeys()
            verify(sessionLocalDataSource).saveKeys(any())
            verify(collector, times(1)).emit(any())
        }
    }

    @InternalCoroutinesApi
    @Test
    fun `when session repositories user is called, the methods of get remote and save database should be called`()= test {
        act {
            whenever(sessionRemoteDataSource.getUser()).doReturn(user)
            whenever(sessionLocalDataSource.getUser()).doReturn(user)
        }
        arrange {
            sessionRepository.getUser().collect(collector)
        }
        assert {
            verify(sessionRemoteDataSource).getUser()
            verify(sessionLocalDataSource).saveUser(any())
            verify(collector, times(1)).emit(any())
        }
    }
}