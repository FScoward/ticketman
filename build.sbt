name := """ticketman"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,

  // scalikejdbc
  "org.scalikejdbc" %% "scalikejdbc"                  % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-config"           % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.5.1",

  // flyway
  "org.flywaydb" %% "flyway-play" % "3.0.1",

  // jdbc
  "mysql" % "mysql-connector-java" % "6.0.3",

  // twitter4j
  "org.twitter4j" % "twitter4j-core" % "4.0.5"
)

