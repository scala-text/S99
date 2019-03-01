organization := "jp.co.dwango"

name := "S99"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test"
)

val unusedWarnings = (
  "-Ywarn-unused" ::
    "-Ywarn-unused-import" ::
    Nil
)

scalacOptions ++= (
  "-deprecation" ::
    "-unchecked" ::
    "-Xlint" ::
    "-Xfuture" ::
    "-language:existentials" ::
    "-language:higherKinds" ::
    "-language:implicitConversions" ::
    "-Yno-adapted-args" ::
    Nil
) ::: unusedWarnings

Seq(Compile, Test).flatMap(
  c => scalacOptions in (c, console) --= unusedWarnings
)
