package springboot.scala.example.api

import javax.xml.bind.annotation.{XmlAccessType, XmlAccessorType, XmlElement, XmlRootElement}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
case class User(@XmlElement() username: String, @XmlElement() email: String) {
  def this() = this("me", "me@example.com")
}

