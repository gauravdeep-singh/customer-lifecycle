name := "customer-lifecycle"

version := "0.1"

scalaVersion := "2.13.6"
val sparkVersion = "2.3.0"

libraryDependencies ++= Seq(
  "commons-codec" % "commons-codec" % "1.10",
  "com.datastax.spark" % "spark-cassandra-connector_2.11" % "2.4.1",
  "org.apache.spark" % "spark-core_2.11" % sparkVersion,
  "org.apache.spark" % "spark-streaming_2.11" % sparkVersion,
  "org.apache.spark" % "spark-sql_2.11" % sparkVersion,
  "org.apache.spark" % "spark-hive_2.11" % sparkVersion,
  "com.datastax.cassandra" % "cassandra-driver-core" % "3.3.0"
)