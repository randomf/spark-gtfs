package com.radekstrnad.sparkgtfs.model

/**
  * Dates for service IDs using a weekly schedule. Specify when service starts and ends, as well as days of the week
  * where service is available.
  *
  * @param service_id The service_id contains an ID that uniquely identifies a set of dates when service is available
  *                   for one or more routes. Each service_id value can appear at most once in a calendar.txt file.
  *                   This value is dataset unique. It is referenced by the trips.txt file.
  * @param monday     The monday field contains a binary value that indicates whether the service is valid for all Mondays.
  *                   A value of 1 indicates that service is available for all Mondays in the date range.
  *                     (The date range is specified using the start_date and end_date fields.)
  *                   A value of 0 indicates that service is not available on Mondays in the date range.
  * @param tuesday    The tuesday field contains a binary value that indicates whether the service is valid for all Tuesdays.
  * @param wednesday  The wednesday field contains a binary value that indicates whether the service is valid for all
  *                   Wednesdays.
  * @param thursday   The thursday field contains a binary value that indicates whether the service is valid for all
  *                   Thursdays.
  * @param friday     The friday field contains a binary value that indicates whether the service is valid for all
  *                   Fridays.
  * @param saturday   The saturday field contains a binary value that indicates whether the service is valid for all
  *                   Saturdays.
  * @param sunday     The sunday field contains a binary value that indicates whether the service is valid for all
  *                   Sundays.
  * @param start_date The start_date field contains the start date for the service. The start_date field's value should
  *                   be in YYYYMMDD format.
  * @param end_date   The end_date field contains the end date for the service. This date is included in the service
  *                   interval. The end_date field's value should be in YYYYMMDD format.
  */
case class Calendar(
  service_id: String,
  monday: Short,
  tuesday: Short,
  wednesday: Short,
  thursday: Short,
  friday: Short,
  saturday: Short,
  sunday: Short,
  start_date: String,
  end_date: String
)

object Calendar extends CsvFile[Calendar] {
  override val fileName: String = "calendar.txt"
}
