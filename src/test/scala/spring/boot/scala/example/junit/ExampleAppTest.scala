package spring.boot.scala.example.junit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spring.boot.scala.example.controller.RootController

@SpringBootTest
class ExampleAppTest {
  @Autowired
  var rootController: RootController = _

  @Test
  def contextLoads(): Unit = {
    assertThat(rootController).isNotNull()
  }

}