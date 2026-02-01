package spring.boot.scala.example.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.{CacheControl, MediaType, ResponseEntity}
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

import java.util.concurrent.TimeUnit
import scala.io.Source
import scala.util.Using

@RestController
class BuildInfoController:
  @Value("${application.name}")
  private val appName: String = null
  private val buildInfo = loadBuildInfo()

  def loadBuildInfo(): String =
    val stream = getClass.getClassLoader.getResourceAsStream("build-info.json")
    if stream == null then
      """{"error": "build-info.json not found"}"""
    else
      Using.resource(Source.fromInputStream(stream)) { source =>
        source.getLines.mkString
      }

  @RequestMapping(path = Array("/buildInfo"), method = Array(GET), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  def get(): ResponseEntity[String] =
    ResponseEntity.ok().cacheControl(CacheControl.maxAge(1, TimeUnit.HOURS)).body(buildInfo)
