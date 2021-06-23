
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession, Column}
import org.apache.spark.sql.functions.{col, split, udf}
import java.text.SimpleDateFormat
import java.util.{TimeZone, UUID}

object Main {
  def main(args: Array[String]) {
    //TODO: Access table from GCP
    val tableName: String = "targeting_crm.dim_customer"
    val appName: String = "clc-etl"

    val sparkConf = new SparkConf(true).setAppName(appName).set("spark.sql.orc.enabled", "true")
      .set("spark.sql.hive.convertMetastoreOrc", "false")
      .set("spark.sql.orc.filterPushdown", "true")
    val sparkSession: SparkSession = SparkSession.builder().enableHiveSupport().config(sparkConf).getOrCreate()
    val sc: SparkContext = sparkSession.sparkContext
    val sqlContext = sparkSession.sqlContext
    sqlContext.setConf("fs.maprfs.impl", Parameters.getFsMaprfsImpl)
    sqlContext.setConf("hive.exec.compress.output", Parameters.getHiveExecCompressOutput)
    sqlContext.setConf("hive.merge.mapredfiles", Parameters.getHiveMergeMapredfiles)
    sqlContext.setConf("hive.merge.smallfiles.avgsize", Parameters.getHiveMergeSmallfilesAvgsize)
    sqlContext.setConf("hive.exec.reducers.bytes.per.reducer", Parameters.getHiveExecReducersBytesPerReducer)
    sqlContext.setConf("hive.exec.dynamic.partition", Parameters.getHiveExecDynamicPartition)
    sqlContext.setConf("hive.exec.dynamic.partition.mode", Parameters.getHiveExecDynamicPartitionMode)

    //TODO: Process/Clean relevant attributes

    //TODO: Store data in Hive
  }
}