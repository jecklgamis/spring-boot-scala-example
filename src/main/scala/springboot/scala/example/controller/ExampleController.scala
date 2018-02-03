package springboot.scala.example.controller

import java.time.LocalDateTime

import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class ExampleController {

  @RequestMapping(path = Array("/"), method = Array(GET))
  def example(): Map[String, Any] = {
    Map("message" -> "Scala rocks!", "today" -> LocalDateTime.now().toString)
  }

}
