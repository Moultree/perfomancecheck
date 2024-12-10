package performancecheck.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/api")
@RestController
class FibonacciController {

    @GetMapping("/fibonacci")
    fun calculateFibonacci(@RequestParam n: Int): String {
        val result = fibonacci(n)
        return "Fibonacci($n) = $result"
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