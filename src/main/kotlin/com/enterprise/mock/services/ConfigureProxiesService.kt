package com.enterprise.mock.services

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ConfigureProxiesService {

	companion object {
		private val logger = LoggerFactory.getLogger(ConfigureProxiesService::class.java)
	}

	operator fun invoke(server: WireMockServer) {
		logger.info("[WireMock] - Configuring proxies...")

		server.stubFor(WireMock.get(WireMock.urlMatching("/other/service/.*"))
			.willReturn(WireMock.aResponse().proxiedFrom("https://google.com")));
	}
}