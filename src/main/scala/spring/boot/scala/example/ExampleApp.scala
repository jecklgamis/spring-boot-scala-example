package spring.boot.scala.example

import org.eclipse.jetty.server.{NetworkTrafficServerConnector, Server}
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ExampleApp {

  @Bean
  def webServerFactory(@Value("${server.http.port}") httpPort: Int): ConfigurableServletWebServerFactory = {
    val factory = new JettyServletWebServerFactory
    factory.addServerCustomizers((server: Server) => {
      val connector = new NetworkTrafficServerConnector(server)
      connector.setPort(httpPort)
      server.addConnector(connector)
    })
    factory
  }
}

object ExampleApp {
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[ExampleApp], args: _*)

}
