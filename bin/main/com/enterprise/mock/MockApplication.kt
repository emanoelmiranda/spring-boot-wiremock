package com.enterprise.mock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MockApplication {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<MockApplication>(*args)
		}
	}
}
