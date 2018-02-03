package springboot.scala.example

import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.stereotype.Component

@Component
class ObjectMapperCustomizer extends Jackson2ObjectMapperBuilderCustomizer {
  override def customize(builder: Jackson2ObjectMapperBuilder): Unit = {
    builder.modules(DefaultScalaModule, new JodaModule)
  }
}
