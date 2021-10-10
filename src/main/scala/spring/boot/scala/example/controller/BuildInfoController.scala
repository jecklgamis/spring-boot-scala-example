package spring.boot.scala.example.controller

import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.{CacheControl, MediaType, ResponseEntity}
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

import java.time.LocalDateTime
import scala.io.Source

@RestController
class BuildInfoController:
  @Value("${application.name}")
  private val appName: String = null
  private val buildInfo = loadBuildInfo()

  def loadBuildInfo(): String =
    Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("build-info.json")).getLines.mkString

  @RequestMapping(path = Array("/buildInfo"), method = Array(GET), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  def get(): ResponseEntity[String] =
    ResponseEntity.ok().cacheControl(CacheControl.noStore()).body(buildInfo)
