package org.teamseven.ols.api

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.teamseven.ols.entities.requests.LoginRequest
import org.teamseven.ols.entities.responses.LoginResponse
import org.teamseven.ols.network.AuthService
import retrofit2.Call
import java.lang.Exception

class AuthApiInstrumentTest {

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun testLogin() {
        val authService = AuthService.create(instrumentationContext);
        val loginRequest = LoginRequest(
            email = "koross@gmail.com",
            password = "password"
        )

        val call : Call<LoginResponse> = authService.login(loginRequest)

        try {
            val response = call.execute()
            val authResponse = response.body()
            assertNotNull(authResponse)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}