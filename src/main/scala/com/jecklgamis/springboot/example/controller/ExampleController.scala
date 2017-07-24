package com.jecklgamis.springboot.example.controller

import java.time.LocalDateTime

import com.jecklgamis.springboot.example.service.ExampleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class ExampleController @Autowired()(exampleService: ExampleService) {

  @RequestMapping(path = Array("/"), method = Array(GET))
  def example(): Map[String, Any] = {
    exampleService.someServiceMethod()
    Map("message" -> "Scala rocks!", "today" -> LocalDateTime.now().toString)
  }

}
