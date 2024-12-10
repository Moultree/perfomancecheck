package performancecheck

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@ComponentScan("performancecheck")
@EnableAsync
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}