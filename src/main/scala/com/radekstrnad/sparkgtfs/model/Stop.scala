package com.radekstrnad.sparkgtfs.model

/**
  * Individual locations where vehicles pick up or drop off passengers.
  *
  * @param stop_id        The stop_id field contains an ID that uniquely identifies a stop, station, or station entrance.
  *                       Multiple routes may use the same stop. The stop_id is used by systems as an internal identifier
  *                       of this record (e.g., primary key in database), and therefore the stop_id must be dataset unique.
  * @param stop_code      The stop_code field contains short text or a number that uniquely identifies the stop for
  *                       passengers. Stop codes are often used in phone-based transit information systems or printed
  *                       on stop signage to make it easier for riders to get a stop schedule or real-time arrival
  *                       information for a particular stop. The stop_code field contains short text or a number that
  *                       uniquely identifies the stop for passengers. The stop_code can be the same as stop_id if it
  *                       is passenger-facing. This field should be left blank for stops without a code presented to
  *                       passengers.
  * @param stop_name      The stop_name field contains the name of a stop, station, or station entrance. Please use
  *                       a name that people will understand in the local and tourist vernacular.
  * @param stop_desc      The stop_desc field contains a description of a stop. Please provide useful, quality
  *                       information. Do not simply duplicate the name of the stop.
  * @param stop_lat       The stop_lat field contains the latitude of a stop, station, or station entrance. The field
  *                       value must be a valid WGS 84 latitude.
  * @param stop_lon       The stop_lon field contains the longitude of a stop, station, or station entrance. The field
  *                       value must be a valid WGS 84 longitude value from -180 to 180.
  * @param zone_id        The zone_id field defines the fare zone for a stop ID. Zone IDs are required if you want
  *                       to provide fare information using fare_rules.txt. If this stop ID represents a station,
  *                       the zone ID is ignored.
  * @param stop_url       The stop_url field contains the URL of a web page about a particular stop. This should be
  *                       different from the agency_url and the route_url fields. The value must be a fully qualified
  *                       URL that includes http:// or https://, and any special characters in the URL must be correctly
  *                       escaped. See http://www.w3.org/Addressing/URL/4_URI_Recommentations.html for a description
  *                       of how to create fully qualified URL values.
  * @param location_type  The location_type field identifies whether this stop ID represents a stop, station, or station
  *                       entrance. If no location type is specified, or the location_type is blank, stop IDs are treated
  *                       as stops. Stations may have different properties from stops when they are represented on a map
  *                       or used in trip planning. The location type field can have the following values:
  *                       0 or blank - Stop. A location where passengers board or disembark from a transit vehicle.
  *                       1 - Station. A physical structure or area that contains one or more stop.
  *                       2 - Station Entrance/Exit. A location where passengers can enter or exit a station from
  *                           the street. The stop entry must also specify a parent_station value referencing the stop
  *                           ID of the parent station for the entrance.
  */
case class Stop(
  stop_id: String,
  stop_code: Option[String],
  stop_name: String,
  stop_desc: Option[String],
  stop_lat: Double,
  stop_lon: Double,
  zone_id: Option[String],
  stop_url: Option[String],
  location_type: Option[Short]
)

// TODO add parent_station, stop_timezone, wheelchair_boarding

object Stop extends CsvFile[Stop] {
  override val fileName: String = "stops.txt"
}