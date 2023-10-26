package spring.boot.scala.example.controller

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.*
import org.springframework.test.context.ActiveProfiles
import spring.boot.scala.example.controller.RootController

import java.util.{Collections, UUID}


class ProbeControllerTest extends BaseAppTest:
  @Autowired
  val probeController: ProbeController = null

  @Test
  def testLivenessProbe(): Unit =
    val response = restTemplate.getForObject(s"http://localhost:$port/probe/live", classOf[Map[String, Any]])
    assertEquals("I'm alive!", response("message"))

  @Test
  def testReadinessProbe(): Unit =
    val response = restTemplate.getForObject(s"http://localhost:$port/probe/ready", classOf[Map[String, Any]])
    assertEquals("I'm ready!", response("message"))
