package performancecheck.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlinx.coroutines.Deferred
import org.springframework.web.bind.annotation.RequestMapping
import performancecheck.infrastructure.CompletableFuturesService
import performancecheck.infrastructure.CoroutinesService
import java.util.concurrent.CompletableFuture

@RequestMapping("/api")
@RestController
class AsyncController(
    private val completableFuturesService: CompletableFuturesService,
    private val coroutinesService: CoroutinesService
){
    @GetMapping("/completable-futures")
    fun completableFutures(): CompletableFuture<String> {
        return completableFuturesService.performTask()
    }

    @GetMapping("/coroutines")
    suspend fun coroutines(): String {
        return coroutinesService.performTask()
    }
}
