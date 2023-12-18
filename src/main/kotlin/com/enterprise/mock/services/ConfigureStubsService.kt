package com.enterprise.mock.services

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ConfigureStubsService {
	companion object {
        private val logger = LoggerFactory.getLogger(ConfigureStubsService::class.java)
    }

	operator fun invoke(server: WireMockServer) {
		logger.info("[WireMock] - Configuring stubs...")

		// @Todo Deve iterar sobre a lista de stubs configurados das properties...

		server.stubFor(WireMock.any(WireMock.urlPathMatching("/simulation/123"))
			.willReturn(WireMock.aResponse().withBody("Stub response for id 123")));

		server.stubFor(WireMock.any(WireMock.urlPathMatching("/simulation/234"))
			.willReturn(WireMock.aResponse().withBody("Global...")));
	}
}