package spring.boot.scala.example.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

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
