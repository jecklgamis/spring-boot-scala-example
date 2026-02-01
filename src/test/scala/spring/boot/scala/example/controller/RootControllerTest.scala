package spring.boot.scala.example.controller

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class RootControllerTest extends BaseAppTest:
  @Autowired
  val rootController: RootController = null

  @Test
  def testRootEndpoint(): Unit =
    val entity = restTemplate.getForObject(s"http://localhost:$port/", classOf[Map[String, Any]])
    assertTrue(entity.contains("name"))
    assertTrue(entity.contains("message"))

