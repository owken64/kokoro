ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"
mainClass in assembly := Some("Main")

lazy val root = (project in file("."))
  .settings(
    name := "Automail",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.9.0",
      "org.typelevel" %% "cats-effect" % "3.5.0"
    )
  )
