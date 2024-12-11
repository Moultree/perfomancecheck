package performancecheck.presentation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture


@RequestMapping("/api")
@RestController
class FibonacciController {

    @GetMapping("/fibonacci/completable-future")
    fun calculateFibonacciCompletableFuture(@RequestParam n: Int): CompletableFuture<String> {
        return CompletableFuture.supplyAsync {
            val result = fibonacci(n)
            "Fibonacci($n) = $result"
        }
    }

    @GetMapping("/fibonacci/coroutines")
    suspend fun calculateFibonacciCoroutines(@RequestParam n: Int): String {
        return withContext(Dispatchers.Default) {
            val result = fibonacci(n)
            "Fibonacci($n) = $result"
        }
    }

    private fun fibonacci(n: Int): Long {
        if (n < 2) return n.toLong()
        var a = 0L
        var b = 1L
        for (i in 2..n) {
            val temp = a + b
            a = b
            b = temp
        }
        return b
    }
}