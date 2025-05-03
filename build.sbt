name := "S99"

def Scala212 = "2.12.20"

scalaVersion := Scala212

crossScalaVersions := Seq(Scala212, "2.13.16", "3.6.4")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest-funspec" % "3.2.19" % "test",
  "org.scalacheck" %% "scalacheck" % "1.18.1" % "test"
)

val unusedWarnings = Def.setting(
  List("-Ywarn-unused:imports")
)

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions"
)

scalacOptions ++= {
  scalaBinaryVersion.value match {
    case "2.12" =>
      unusedWarnings.value ++ Seq(
        "-Xsource:3",
        "-Xlint"
      )
    case "2.13" =>
      unusedWarnings.value ++ Seq(
        "-Xsource:3-cross",
        "-Xlint"
      )
    case _ =>
      Nil
  }
}

scalacOptions ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 11 | 12)) =>
      Seq("-Yno-adapted-args", "-Xfuture")
    case _ =>
      Nil
  }
}

Seq(Compile, Test).flatMap(c =>
  (c / console / scalacOptions) --= unusedWarnings.value
)
