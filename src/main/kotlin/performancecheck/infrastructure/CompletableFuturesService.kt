package performancecheck.infrastructure

import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class CompletableFuturesService(private val itemRepository: ItemRepository) {

    fun performTask(): CompletableFuture<String> {
        return CompletableFuture.supplyAsync {
            try {
                val item = itemRepository.findById(1).orElseThrow { IllegalArgumentException("Item not found") }
                "Task completed using CompletableFuture: ${item.name}"
            } catch (e: Exception) {
                "Task failed with error: ${e.message}"
            }
        }
    }
}