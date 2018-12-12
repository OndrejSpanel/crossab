val mainSettings = Seq(
  name := "CrossAB",
  version := "0.1"
)


val scalaL = "2.11.12"
val scalaH = "2.12.7"

def sourceDirectories(name: String) = Seq(
  unmanagedSourceDirectories in Compile += (baseDirectory in ThisBuild).value / name / "src" / "main" / "scala",
  unmanagedSourceDirectories in Test += (baseDirectory in ThisBuild).value / name / "src" / "test" / "scala",
  unmanagedResourceDirectories in Compile += (baseDirectory in ThisBuild).value / name / "src" / "main" / "resources",
  unmanagedResourceDirectories in Test += (baseDirectory in ThisBuild).value / name / "src" / "test" / "resources"
)

lazy val commonSources = sourceDirectories("common")

lazy val aSources = sourceDirectories("A")

lazy val bSources = sourceDirectories("B")

lazy val rootA = project.in(file("rootA")).settings(commonSources ++ aSources ++ mainSettings ++ Seq(
  scalaVersion := scalaL
))

lazy val rootB = project.in(file("rootB")).settings(commonSources ++ bSources ++ mainSettings ++ Seq(
  scalaVersion := scalaH
))

lazy val root = rootA