package com.enterprise.mock.listeners

import com.github.tomakehurst.wiremock.http.Request
import com.github.tomakehurst.wiremock.http.RequestListener
import com.github.tomakehurst.wiremock.http.Response
import org.slf4j.LoggerFactory

internal class CustomRequestListener : RequestListener {
	companion object {
		private val logger = LoggerFactory.getLogger(CustomRequestListener::class.java)
	}

	override fun requestReceived(request: Request?, response: Response?) {
		logger.info("[WireMock] - request at URL: ${request?.absoluteUrl}")
		logger.info("[WireMock] - request headers: ${request?.headers}")
		logger.info("[WireMock] - response body: ${request?.bodyAsString}")
		logger.info("[WireMock] - response headers: ${request?.headers}")
	}
}