name := """fantasyGame-play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava).enablePlugins(PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "9.4.1208.jre7",
  "commons-io" % "commons-io" % "2.4",
  javaJpa,
  cache,
  javaWs
)
