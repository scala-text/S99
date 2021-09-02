name := "S99"

def Scala212 = "2.12.14"

val isScala3 = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)
)

scalaVersion := Scala212

crossScalaVersions := Seq(Scala212, "2.13.6", "3.0.2")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.9" % "test",
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
      "-source",
      "3.0-migration"
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

val excludeScala3 = Set[String](
)

Seq(Compile, Test).map { c =>
  c / sources := {
    val xs = (c / sources).value
    if (isScala3.value) {
      // TODO scalatest diagram assert does not work with Scala 3
      // https://github.com/scalatest/scalatest/issues/2019
      xs.filterNot(f => excludeScala3(f.getName))
        .filterNot(f => f.getName.endsWith("Spec.scala"))
    } else {
      xs
    }
  }
}
