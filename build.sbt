val springBootVersion = "3.2.0"
val jacksonVersion = "2.16.0"

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = project
  .in(file("."))
  .settings(
    name := "spring-boot-scala-example",
    version := "1.0.0-SNAPSHOT",
    scalaVersion := "3.4.0-RC1-bin-20231218-ec2b8bc-NIGHTLY",
    assembly / mainClass := Some("spring.boot.scala.example.ExampleApp"),
    assembly / assemblyJarName := "spring-boot-scala-example.jar",
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion
      exclude("org.springframework.boot", "spring-boot-starter-tomcat"),
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-jetty" % springBootVersion,
    libraryDependencies += "jakarta.servlet" % "jakarta.servlet-api" % "5.0.0",
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-actuator" % springBootVersion,
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-test" % springBootVersion % Test,
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion,
    libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.13" % jacksonVersion,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.3.0-alpha.1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-alpha.1" % Test,
    libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "5.10.1" % Test,
    libraryDependencies += "net.aichler" % "jupiter-interface" % "0.11.1" % Test
  )

ThisBuild / javacOptions ++= Seq("-source", "21")
ThisBuild / resolvers += Resolver.jcenterRepo

ThisBuild / assemblyMergeStrategy := {
  case PathList(ps@_*) if ps.contains("module-info.class") => MergeStrategy.concat
  case PathList("META-INF", "spring-configuration-metadata.json") => MergeStrategy.concat
  case PathList("META-INF", "additional-spring-configuration-metadata.json") => MergeStrategy.concat
  case PathList("META-INF", "spring.handlers") => MergeStrategy.concat
  case PathList("META-INF", "spring.schemas") => MergeStrategy.concat
  case PathList("META-INF", "spring.factories") => MergeStrategy.concat
  case PathList("META-INF", "web-fragment.xml") => MergeStrategy.concat
  case PathList("META-INF", "spring-autoconfigure-metadata.properties") => MergeStrategy.concat
  case PathList("META-INF", "spring", "aot.factories") => MergeStrategy.concat
  case PathList("META-INF", "spring", "org.springframework.boot.autoconfigure.AutoConfiguration.imports") => MergeStrategy.concat
  case x => MergeStrategy.defaultMergeStrategy(x)
}
