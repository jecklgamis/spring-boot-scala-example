package spring.boot.scala.example

import org.eclipse.jetty.server.{NetworkTrafficServerConnector, Server}
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Bean, Profile}


@SpringBootApplication
class ExampleApp

@main
def main(): Unit = SpringApplication.run(classOf[ExampleApp])