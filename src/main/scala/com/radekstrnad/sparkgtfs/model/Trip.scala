package com.radekstrnad.sparkgtfs.model

/**
  * Trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
  *
  * @param route_id               The route_id field contains an ID that uniquely identifies a route. This value is
  *                               referenced from the routes.txt file.
  * @param service_id             The service_id contains an ID that uniquely identifies a set of dates when service
  *                               is available for one or more routes. This value is referenced from the calendar.txt
  *                               or calendar_dates.txt file.
  * @param trip_id                The trip_id field contains an ID that identifies a trip. The trip_id is dataset unique.
  * @param trip_headsign          The trip_headsign field contains the text that appears on a sign that identifies the
  *                               trip's destination to passengers. Use this field to distinguish between different
  *                               patterns of service in the same route. If the headsign changes during a trip, you
  *                               can override the trip_headsign by specifying values for the stop_headsign field in
  *                               stop_times.txt.
  * @param trip_short_name        The trip_short_name field contains the text that appears in schedules and sign boards
  *                               to identify the trip to passengers, for example, to identify train numbers for commuter
  *                               rail trips. If riders do not commonly rely on trip names, please leave this field blank.
  *                               A trip_short_name value, if provided, should uniquely identify a trip within a service
  *                               day; it should not be used for destination names or limited/express designations.
  * @param direction_id           The direction_id field contains a binary value that indicates the direction of travel
  *                               for a trip. Use this field to distinguish between bi-directional trips with the same
  *                               route_id. This field is not used in routing; it provides a way to separate trips by
  *                               direction when publishing time tables. You can specify names for each direction with
  *                               the trip_headsign field.
  *                               0 - travel in one direction (e.g. outbound travel)
  *                               1 - travel in the opposite direction (e.g. inbound travel)
  *
  *                               For example, you could use the trip_headsign and direction_id fields together to assign
  *                               a name to travel in each direction for a set of trips. A trips.txt file could contain
  *                               these rows for use in time tables:
  *                               trip_id,...,trip_headsign,direction_id
  *                               1234,...,Airport,0
  *                               1505,...,Downtown,1
  * @param block_id               The block_id field identifies the block to which the trip belongs. A block consists of
  *                               a single trip or many sequential trips made using the same vehicle, defined by shared
  *                               service day and block_id. A block_id can have trips with different service days,
  *                               making distinct blocks.
  * @param shape_id               The shape_id field contains an ID that defines a shape for the trip. This value is
  *                               referenced from the shapes.txt file. The shapes.txt file allows you to define how a
  *                               line should be drawn on the map to represent a trip.
  * @param wheelchair_accessible  0 (or empty) - indicates that there is no accessibility information for the trip
  *                               1 - indicates that the vehicle being used on this particular trip can accommodate at
  *                                   least one rider in a wheelchair
  *                               2 - indicates that no riders in wheelchairs can be accommodated on this trip
  * @param bikes_allowed          0 (or empty) - indicates that there is no bike information for the trip
  *                               1 - indicates that the vehicle being used on this particular trip can accommodate
  *                                   at least one bicycle
  *                               2 - indicates that no bicycles are allowed on this trip
  */
case class Trip(
  route_id: String,
  service_id: String,
  trip_id: String,
  trip_headsign: Option[String],
  trip_short_name: Option[String],
  direction_id: Option[Short],
  block_id: Option[String],
  shape_id: Option[String],
  wheelchair_accessible: Option[Short],
  bikes_allowed: Option[Short]
)

object Trip extends CsvFile[Trip] {
  override val fileName: String = "trips.txt"
}
