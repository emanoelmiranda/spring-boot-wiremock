package com.enterprise.mock.configs

import com.enterprise.mock.listeners.CustomRequestListener
import com.enterprise.mock.services.ConfigureProxiesService
import com.enterprise.mock.services.ConfigureStubsService
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WireMockConfigs(
	@Value("\${wiremock.server.port}")
	private val wireMockPort: Int,
	private val configureProxies: ConfigureProxiesService,
	private val configureStubs: ConfigureStubsService
) {
	companion object {
		private val logger = LoggerFactory.getLogger(WireMockConfigs::class.java)
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	fun wireMockServer(): WireMockServer {
		logger.info("Starting wiremock server in port $wireMockPort")

		val server = WireMockServer(wireMockServerConfig())

		server.addMockServiceRequestListener(CustomRequestListener())

		configureStubs(server)
		configureProxies(server)

		return server
	}

	private fun wireMockServerConfig() =
		WireMockConfiguration.wireMockConfig()
			.port(wireMockPort)
}