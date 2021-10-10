package spring.boot.scala.example.controller

import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

import java.time.LocalDateTime

@RestController
class RootController:
  @Value("${application.name}")
  val appName: String = null

  @RequestMapping(path = Array("/"), method = Array(GET))
  @Timed
  def root(): Map[String, Any] = Map("name" -> appName, "message" -> "It works on my machine!")

