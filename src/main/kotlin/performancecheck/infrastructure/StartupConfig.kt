package performancecheck.infrastructure

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import performancecheck.domain.Item

@Configuration
class StartupConfig(private val itemRepository: ItemRepository) {

    @Bean
    fun initializeDatabase(): CommandLineRunner {
        return CommandLineRunner {
            if (!itemRepository.existsById(1)) {
                val item = Item(id = 1, name = "Sample Item")
                itemRepository.save(item)
            }
        }
    }
}