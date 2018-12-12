val scalaL = "2.11.12"
val scalaH = "2.12.7"

lazy val common = (project in file("common"))
  .settings(crossScalaVersions := Seq(scalaH, scalaL))

lazy val A = (project in file("A"))
  .settings(scalaVersion := scalaL)
  .dependsOn(common)

lazy val B = (project in file("B"))
  .settings(scalaVersion := scalaH)
  .dependsOn(common)

lazy val rootA = (project in file("rootA"))
  .aggregate(common, A)
  .settings(scalaVersion := scalaL)

lazy val rootB = (project in file("rootB"))
  .aggregate(common, B)
  .settings(scalaVersion := scalaH)
