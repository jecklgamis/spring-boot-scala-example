package spring.boot.scala.example.junit

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import spring.boot.scala.example.controller.RootController

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class RootControllerTest {
  @Autowired
  var rootController: RootController = _
  @Autowired
  var restTemplate: TestRestTemplate = _

  @Test
  def rootEndPointShouldContainJavaVersion(): Unit = {
    val entity = restTemplate.getForObject(s"http://localhost:8080/", classOf[Map[String, Any]])
    assertTrue(entity.contains("java.version"))
  }

}