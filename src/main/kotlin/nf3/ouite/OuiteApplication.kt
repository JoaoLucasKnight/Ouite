package nf3.ouite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OuiteApplication

fun main(args: Array<String>) {
	runApplication<OuiteApplication>(*args)
}
