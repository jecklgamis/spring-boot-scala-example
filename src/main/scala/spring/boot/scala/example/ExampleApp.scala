package spring.boot.scala.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class ExampleApp

object ExampleApp {
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[ExampleApp])
}