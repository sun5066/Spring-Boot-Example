package kotiln.biz.book

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookV2Application

fun main(args: Array<String>) {
    runApplication<BookV2Application>(*args);
}
