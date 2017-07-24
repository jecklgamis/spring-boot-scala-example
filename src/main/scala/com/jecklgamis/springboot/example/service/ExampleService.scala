package com.jecklgamis.springboot.example.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

trait ExampleService {
  def someServiceMethod(): Unit
}

@Service
class ExampleServiceImpl extends ExampleService {
  private val log = LoggerFactory.getLogger(classOf[ExampleServiceImpl])

  override def someServiceMethod(): Unit = {
    log.info("someServiceMethod()")
  }
}
