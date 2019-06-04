package springboot.scala.example.controller

import java.time.LocalDateTime

import io.micrometer.core.annotation.Timed
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class RootController {

  @RequestMapping(path = Array("/"), method = Array(GET))
  @Timed
  def root(): Map[String, Any] = {
    Map("message" -> "It works!", "today" -> LocalDateTime.now())
  }

}
