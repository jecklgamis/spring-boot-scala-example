package spring.boot.scala.example.controller

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class BuildInfoControllerTest extends BaseAppTest:
  @Autowired
  val buildInfoController: BuildInfoController = null

  @Test
  def testGetBuildInfo(): Unit =
    val buildInfo = restTemplate.getForObject(s"http://localhost:$port/buildInfo", classOf[Map[String, Any]])
    assertTrue(!buildInfo("version").toString.isEmpty)
    assertTrue(!buildInfo("build-time").toString.isEmpty)
    assertTrue(!buildInfo("branch").toString.isEmpty)

