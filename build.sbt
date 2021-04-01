name := "S99"

def Scala212 = "2.12.13"

scalaVersion := Scala212

crossScalaVersions := Seq(Scala212, "2.13.5")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.7" % "test",
  "org.scalacheck" %% "scalacheck" % "1.15.3" % "test"
)

val unusedWarnings = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 11)) =>
      List("-Ywarn-unused-import")
    case _ =>
      List("-Ywarn-unused:imports")
  }
)

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions"
)

scalacOptions ++= {
  if (isDotty.value) {
    Seq(
      "-source",
      "3.0-migration"
    )
  } else {
    (unusedWarnings.value: @sbtUnchecked) ++ Seq(
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
    if (isDotty.value) {
      // TODO scalatest diagram assert does not work with Scala 3
      xs.filterNot(f => excludeScala3(f.getName))
        .filterNot(f => f.getName.endsWith("Spec.scala"))
    } else {
      xs
    }
  }
}
