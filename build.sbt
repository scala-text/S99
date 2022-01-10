name := "S99"

def Scala212 = "2.12.15"

val isScala3 = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)
)

scalaVersion := Scala212

crossScalaVersions := Seq(Scala212, "2.13.8", "3.1.0")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.10" % "test",
  "org.scalacheck" %% "scalacheck" % "1.15.4" % "test"
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
  if (isScala3.value) {
    Seq(
    )
  } else {
    unusedWarnings.value ++ Seq(
      "-Xlint"
    )
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
