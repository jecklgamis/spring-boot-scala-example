package springboot.scala.example.controller

import java.util.UUID

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMethod.{GET, POST, PUT}
import org.springframework.web.bind.annotation.{PathVariable, RequestBody, RequestMapping, RestController}
import springboot.scala.example.api.User

@RestController
@RequestMapping(path = Array("/user"))
class UserController {
  private val log = LoggerFactory.getLogger(classOf[UserController])

  @RequestMapping(path = Array("/{id}"), method = Array(GET), produces = Array("application/json", "application/xml"))
  def get(@PathVariable id: String): User = User("me", "me@example.com")

  @RequestMapping(method = Array(PUT, POST), produces = Array("application/json", "application/xml"),
    consumes = Array("application/json", "application/xml"))
  def put(@RequestBody user: User): String = {
    log.info(s"Received ${user}")
    UUID.randomUUID().toString
  }
}
