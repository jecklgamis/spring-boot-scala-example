package spring.boot.scala.example

import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer
import org.springframework.stereotype.Component
import tools.jackson.databind.json.JsonMapper
import tools.jackson.module.scala.DefaultScalaModule

@Component
class ObjectMapperCustomizer extends JsonMapperBuilderCustomizer :
  override def customize(builder: JsonMapper.Builder): Unit =
    builder.addModule(DefaultScalaModule)
