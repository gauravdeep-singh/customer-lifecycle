import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.read

import scala.io.Source

object Parameters{

  implicit val formats = DefaultFormats

  val settingsNFiltersFile: String = "/home/targeting_crm/util/parameters.json"
  val settingsNFiltersJson: String = Source.fromFile(settingsNFiltersFile).mkString
  val settingsNFilters = read[Param](settingsNFiltersJson)

  val emailPreferencesTable: String = "email_preferences"
  val emailCustomerTable: String = "email_customer"
  val emailInvalidTable: String = "email_validation"
  val emailNvrMktTable: String = "email_never_market"
  val custTable: String = "customer"

  /**
   * Allow/disable verbose logging
   * @return
   */
  def getLogging: Boolean = {
    settingsNFilters.enableLogging
  }

  /**
   * Time in hours to go back from the start time in the delta window
   * @return
   */
  def getDeltaRunBufferInHours: Int = {
    settingsNFilters.crmCassandraDeltaWindowInHours
  }

  /**
   * Sleep Time (milliseconds) before fecthing preferences/other data
   * @return
   */
  def getSleepTime: Long = {
    settingsNFilters.sleepTime
  }

  /**
   * cassandra.input.reads_per_sec property
   * @return
   */
  def getCassandraInputReadsPerSec: String = {
    settingsNFilters.cassandraInputReadsPerSec
  }

  /**
   * cassandra.input.fetch.size_in_rows property
   * @return
   */
  def getCassandraInputFetchSizeInRows: String = {
    settingsNFilters.cassandraInputFetchSizeInRows
  }

  /**
   * cassandra.connection.timeout_ms property
   * @return
   */
  def getCassandraConnectionTimeoutMs: String = {
    settingsNFilters.cassandraConnectionTimeoutMs
  }

  /**
   * cassandra.read.timeout_ms property
   * @return
   */
  def getCassandraReadTimeoutMs: String = {
    settingsNFilters.cassandraReadTimeoutMs
  }

  /**
   * cassandra.connection.keep_alive_ms property
   * @return
   */
  def getCassandraConnectionKeepAliveMs: String = {
    settingsNFilters.cassandraConnectionKeepAliveMs
  }

  /**
   * fs.maprfs.impl property
   * @return
   */
  def getFsMaprfsImpl: String = {
    settingsNFilters.fsMaprfsImpl
  }

  /**
   * hive.exec.compress.output property
   * @return
   */
  def getHiveExecCompressOutput: String = {
    settingsNFilters.hiveExecCompressOutput
  }

  /**
   * hive.merge.mapredfiles property
   * @return
   */
  def getHiveMergeMapredfiles: String = {
    settingsNFilters.hiveMergeMapredfiles
  }

  /**
   * hive.merge.smallfiles.avgsize property
   * @return
   */
  def getHiveMergeSmallfilesAvgsize: String = {
    settingsNFilters.hiveMergeSmallfilesAvgsize
  }

  /**
   * hive.exec.reducers.bytes.per.reducer property
   * @return
   */
  def getHiveExecReducersBytesPerReducer: String = {
    settingsNFilters.hiveExecReducersBytesPerReducer
  }

  /**
   * hive.exec.dynamic.partition property
   * @return
   */
  def getHiveExecDynamicPartition: String = {
    settingsNFilters.hiveExecDynamicPartition
  }

  /**
   * hive.exec.dynamic.partition.mode property
   * @return
   */
  def getHiveExecDynamicPartitionMode: String = {
    settingsNFilters.hiveExecDynamicPartitionMode
  }

  /* def getConnectionDetails(env: String): NewConnectionDetails = {

     // val connections: String = "/home/targeting_crm/util/connections.json"
     //  val json: String = Source.fromFile(connections).mkString
     // val connection = read[TestConnection](json)
     //  val details = connection.environment.filter(f => f.name.equals(env)).head

     val details = settingsNFilters.connections.environment.filter(f => f.name.equals(env)).head
     details
   }
 */

  /**
   * List of patterns/emails to ignore during load
   * @return
   */
//  def getIgnorableEmailPatterns: IgnorableEmailPatterns = {
//    settingsNFilters.ignoreEmailPatterns
//  }

  /**
   *
   * @return
   */
  def getDeltaPreferencesAlert: Boolean = {
    settingsNFilters.deltaPreferencesExtract
  }

  /**
   *
   * @return
   */
  def getDeltaInvalidAlert: Boolean = {
    settingsNFilters.deltaInvalidExtract
  }

  /**
   *
   * @return
   */
  def getDeltaNvrMktAlert: Boolean = {
    settingsNFilters.deltaNeverMarketExtract
  }

  /**
   *
   * @return
   */
  def getTotalDeltaAlert: Boolean = {
    settingsNFilters.totalDeltaExtract
  }

  /**
   *
   * @return
   */
  def getTotalPreferencesAlert: Boolean = {
    settingsNFilters.totalPreferencesExtract
  }

  /**
   *
   * @return
   */
  def getTotalCidAlert: Boolean = {
    settingsNFilters.totalCidExtract
  }

  /**
   *
   * @return
   */
  def getTotalOmsCustIdAlert: Boolean = {
    settingsNFilters.totalOmsCustomerIdExtract
  }

  /**
   *
   * @return
   */
  def getHiveOmsCustAlert: Boolean = {
    settingsNFilters.hiveDCOmsCustId
  }

  /**
   *
   * @return
   */
  def getHiveDCSourceIdAlert: Boolean = {
    settingsNFilters.hiveDCSourceIdDist
  }

  /**
   *
   * @return
   */
  def getHiveDCDomainAlert: Boolean = {
    settingsNFilters.hiveDCDomainDist
  }

  /**
   *
   * @return
   */
  def getHiveTotalSubsAlert: Boolean = {
    settingsNFilters.hiveTotalSubscription
  }

  /**
   *
   * @return
   */
  def getHiveSubsOptInOutAlert: Boolean = {
    settingsNFilters.hiveSubscriptionOptInOut
  }

  /**
   *
   * @return
   */
  def getHiveDailySourceIdOptinAlert: Boolean = {
    settingsNFilters.hiveDailySourceIdOptin
  }

  /**
   *
   * @return
   */
  def getHiveDailySourceIdOptoutAlert: Boolean = {
    settingsNFilters.hiveDailySourceIdOptout
  }

  /**
   *
   * @return
   */
  def getCassandraSourceIdDAlert: Boolean = {
    settingsNFilters.cassandraSourceIdDist
  }

  /**
   *
   * @return
   */
  def getCassandraDomainDistAlert: Boolean = {
    settingsNFilters.cassandraDomainDist
  }

  /**
   * Email_preferences Table
   * @return
   */
  def getEmailPreferencesTable: String = {
    emailPreferencesTable
  }

  /**
   * Email_customer table
   * @return
   */
  def getEmailCidTable: String = {
    emailCustomerTable
  }

  /**
   * Email_validation table
   * @return
   */
  def getEmailValidationTable: String = {
    emailInvalidTable
  }

  /**
   * Email_never_market table
   * @return
   */
  def getEmailNvrMktTable: String = {
    emailNvrMktTable
  }

  /**
   * Customer table
   * @return
   */
  def getCustomerTable: String = {
    custTable
  }
}
