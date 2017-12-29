package com.radekstrnad.sparkgtfs

import com.radekstrnad.sparkgtfs.model._
import org.apache.spark.sql.{Dataset, SparkSession}

object SparkGTFS {

  type Out = Either[SparkGTFSError, RawGTFS]

  def getFromDirectory(path: String, spark: SparkSession): Out = ???

  def getFromZipFile(path: String, spark: SparkSession): Out = ???

}

case class RawGTFS (
  agencies: Dataset[Agency],
  stops: Dataset[Stop],
  routes: Dataset[Route],
  trips: Dataset[Trip],
  stopTimes: Dataset[StopTime],
  calendar: Dataset[Calendar],

  calendarDates: Option[Dataset[CalendarDate]],
  fareAttributes: Option[Dataset[FareAttribute]],
  fareRules: Option[Dataset[FareRule]],
  shapes: Option[Dataset[Shape]],
  frequencies: Option[Dataset[Frequency]],
  transfers: Option[Dataset[Transfer]],
  feedInfo: Option[Dataset[FeedInfo]]
)

sealed trait SparkGTFSError