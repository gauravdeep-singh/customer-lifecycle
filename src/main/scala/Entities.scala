import java.sql.Timestamp
import java.util.UUID

import com.datastax.spark.connector.CassandraRow

case class CustomerPreference(prefType: java.lang.Integer, optedIn: String)

case class CustomerPreferences(customer: Option[Customer], preferences: Option[List[CustomerPreference]])

case class Customer(customerId: Option[java.lang.Long], cId: Option[String], email: Option[Email])

case class Email(email: Option[String])

case class StampedCustomerPreferences(dated: Option[Timestamp], creator: Option[String], customerPreferences: Option[CustomerPreferences])

case class ConnectionDetails(hosts: String, user: String, password: String, local_dc: Option[String], keyspace: String)

case class Connection(clm_prod: ConnectionDetails, crm_prod: ConnectionDetails, clm_stg: ConnectionDetails, clm_dev: ConnectionDetails, crm_dev: ConnectionDetails)

case class SlackPost(channel: String, mrkdwn: Boolean, text: String, link_names: Int)

case class NewConnectionDetails(sys: String, name: String, hosts: String, user: String, password: String, local_dc: Option[String], keyspace: String, consistency_level: String)

case class TestConnection(environment: List[NewConnectionDetails])

case class Param(enableLogging: Boolean, crmCassandraDeltaWindowInHours: Int, sleepTime: Long,
                 cassandraInputReadsPerSec: String, cassandraInputFetchSizeInRows: String, cassandraConnectionTimeoutMs: String,
                 cassandraReadTimeoutMs: String, cassandraConnectionKeepAliveMs: String,
                 fsMaprfsImpl: String, hiveExecCompressOutput: String, hiveMergeMapredfiles: String,
                 hiveMergeSmallfilesAvgsize: String, hiveExecReducersBytesPerReducer: String,
                 hiveExecDynamicPartition: String, hiveExecDynamicPartitionMode: String,
//                 ignoreEmailPatterns: IgnorableEmailPatterns,
                 deltaPreferencesExtract: Boolean, deltaInvalidExtract: Boolean, deltaNeverMarketExtract: Boolean,
                 totalDeltaExtract: Boolean, totalPreferencesExtract: Boolean, totalCidExtract: Boolean,
                 totalOmsCustomerIdExtract: Boolean, hiveDCOmsCustId: Boolean, hiveDCSourceIdDist: Boolean,
                 hiveDCDomainDist: Boolean, hiveTotalSubscription: Boolean, hiveSubscriptionOptInOut: Boolean,
                 hiveDailySourceIdOptin: Boolean, hiveDailySourceIdOptout: Boolean, cassandraSourceIdDist: Boolean,
                 cassandraDomainDist: Boolean)
