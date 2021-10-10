package spring.boot.scala.example.controller

import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.http.{MediaType, ResponseEntity}
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMethod.{GET, PUT}

import java.time.LocalDateTime

@RestController
@RequestMapping(path = Array("/probe"), produces = Array(MediaType.APPLICATION_JSON_VALUE))
class ProbeController:

  @Timed
  @RequestMapping(path = Array("/live"), method = Array(GET))
  def live(): ResponseEntity[Map[String, Any]] =
    ResponseEntity.ok().body(Map("message" -> "I'm alive!"))

  @Timed
  @RequestMapping(path = Array("/ready"), method = Array(GET))
  def ready(): ResponseEntity[Map[String, Any]] =
    ResponseEntity.ok().body(Map("message" -> "I'm ready!"))



