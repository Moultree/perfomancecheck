package performancecheck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableAsync
import performancecheck.infrastructure.StartupConfig

@SpringBootApplication
@ComponentScan("performancecheck")
@Import(StartupConfig::class)
@EnableAsync
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}