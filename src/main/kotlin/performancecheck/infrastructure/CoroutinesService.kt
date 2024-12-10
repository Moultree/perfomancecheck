package performancecheck.infrastructure

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class CoroutinesService(private val itemRepository: ItemRepository) {

    suspend fun performTask(): String {
        return try {
            val item = withContext(Dispatchers.IO) {
                itemRepository.findById(1).orElseThrow { IllegalArgumentException("Item not found") }
            }
            "Task completed using Coroutines: ${item.name}"
        } catch (e: Exception) {
            "Task failed with error: ${e.message}"
        }
    }
}