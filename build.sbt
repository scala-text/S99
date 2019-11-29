name := "S99"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.1.0" % "test",
  "org.scalacheck" %% "scalacheck" % "1.14.2" % "test"
)

val unusedWarnings = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 11)) =>
      List("-Ywarn-unused-import")
    case _ =>
      List("-Ywarn-unused:imports")
  }
)

scalacOptions ++= (
  "-deprecation" ::
    "-unchecked" ::
    "-Xlint" ::
    "-language:existentials" ::
    "-language:higherKinds" ::
    "-language:implicitConversions" ::
    Nil
) ::: unusedWarnings.value

scalacOptions ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 11 | 12)) =>
      Seq("-Yno-adapted-args", "-Xfuture")
    case _ =>
      Nil
  }
}

Seq(Compile, Test).flatMap(
  c => scalacOptions in (c, console) --= unusedWarnings.value
)
