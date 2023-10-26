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


class BuildInfoControllerTest extends BaseAppTest :
  @Autowired
  val buildInfoController: BuildInfoController = null

  @Test
  def testGetBuildInfo(): Unit =
    val buildInfo = restTemplate.getForObject(s"http://localhost:$port/buildInfo", classOf[Map[String, Any]])
    assertTrue(!buildInfo("version").toString.isEmpty)
    assertTrue(!buildInfo("build-time").toString.isEmpty)
    assertTrue(!buildInfo("branch").toString.isEmpty)

