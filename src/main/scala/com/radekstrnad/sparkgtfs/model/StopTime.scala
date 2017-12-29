package com.radekstrnad.sparkgtfs.model

import java.sql.Time

/**
  * Times that a vehicle arrives at and departs from individual stops for each trip.
  *
  * @param trip_id              The trip_id field contains an ID that identifies a trip. This value is referenced from
  *                             the trips.txt file.
  * @param arrival_time         The arrival_time specifies the arrival time at a specific stop for a specific trip on a
  *                             route. The time is measured from "noon minus 12h" (effectively midnight, except for days
  *                             on which daylight savings time changes occur) at the beginning of the service day. For
  *                             times occurring after midnight on the service day, enter the time as a value greater
  *                             than 24:00:00 in HH:MM:SS local time for the day on which the trip schedule begins. If
  *                             you don't have separate times for arrival and departure at a stop, enter the same value
  *                             for arrival_time and departure_time.
  *
  *                             Scheduled stops where the vehicle strictly adheres to the specified arrival and
  *                             departure times are timepoints. For example, if a transit vehicle arrives at a stop
  *                             before the scheduled departure time, it will hold until the departure time. If this stop
  *                             is not a timepoint, use either an empty string value for the arrival_time field or
  *                             provide an interpolated time. Further, indicate that interpolated times are provided via
  *                             the timepoint field with a value of zero. If interpolated times are indicated with
  *                             timepoint=0, then time points must be indicated with a value of 1 for the timepoint
  *                             field. Provide arrival times for all stops that are time points.
  * @param departure_time       The departure_time specifies the departure time from a specific stop for a specific trip
  *                             on a route. The time is measured from "noon minus 12h" (effectively midnight, except for
  *                             days on which daylight savings time changes occur) at the beginning of the service day.
  *                             For times occurring after midnight on the service day, enter the time as a value greater
  *                             than 24:00:00 in HH:MM:SS local time for the day on which the trip schedule begins. If
  *                             you don't have separate times for arrival and departure at a stop, enter the same value
  *                             for arrival_time and departure_time.
  * @param stop_id              The stop_id field contains an ID that uniquely identifies a stop. Multiple routes may
  *                             use the same stop. The stop_id is referenced from the stops.txt file. If location_type
  *                             is used in stops.txt, all stops referenced in stop_times.txt must have location_type
  *                             of 0. Where possible, stop_id values should remain consistent between feed updates.
  *                             In other words, stop A with stop_id 1 should have stop_id 1 in all subsequent data
  *                             updates. If a stop is not a time point, enter blank values for arrival_time and
  *                             departure_time.
  * @param stop_sequence        The stop_sequence field identifies the order of the stops for a particular trip. The
  *                             values for stop_sequence must be non-negative integers, and they must increase along
  *                             the trip. For example, the first stop on the trip could have a stop_sequence of 1,
  *                             the second stop on the trip could have a stop_sequence of 23, the third stop could have
  *                             a stop_sequence of 40, and so on.
  * @param stop_headsign        The stop_headsign field contains the text that appears on a sign that identifies the
  *                             trip's destination to passengers. Use this field to override the default trip_headsign
  *                             when the headsign changes between stops. If this headsign is associated with an entire
  *                             trip, use trip_headsign instead.
  * @param pickup_type          The pickup_type field indicates whether passengers are picked up at a stop as part of
  *                             the normal schedule or whether a pickup at the stop is not available. This field also
  *                             allows the transit agency to indicate that passengers must call the agency or notify the
  *                             driver to arrange a pickup at a particular stop. Valid values for this field are:
  *                             0 - Regularly scheduled pickup
  *                             1 - No pickup available
  *                             2 - Must phone agency to arrange pickup
  *                             3 - Must coordinate with driver to arrange pickup
  *                             The default value for this field is 0.
  * @param drop_off_type        The drop_off_type field indicates whether passengers are dropped off at a stop as part
  *                             of the normal schedule or whether a drop off at the stop is not available. This field
  *                             also allows the transit agency to indicate that passengers must call the agency or notify
  *                             the driver to arrange a drop off at a particular stop. Valid values for this field are:
  *                             0 - Regularly scheduled drop off
  *                             1 - No drop off available
  *                             2 - Must phone agency to arrange drop off
  *                             3 - Must coordinate with driver to arrange drop off
  *                             The default value for this field is 0.
  * @param shape_dist_traveled  When used in the stop_times.txt file, the shape_dist_traveled field positions a stop
  *                             as a distance from the first shape point. The shape_dist_traveled field represents a real
  *                             distance traveled along the route in units such as feet or kilometers. For example, if
  *                             a bus travels a distance of 5.25 kilometers from the start of the shape to the stop,
  *                             the shape_dist_traveled for the stop ID would be entered as "5.25". This information
  *                             allows the trip planner to determine how much of the shape to draw when showing part
  *                             of a trip on the map. The values used for shape_dist_traveled must increase along with
  *                             stop_sequence: they cannot be used to show reverse travel along a route. The units used
  *                             for shape_dist_traveled in the stop_times.txt file must match the units that are used
  *                             for this field in the shapes.txt file.
  * @param timepoint            The timepoint field can be used to indicate if the specified arrival and departure times
  *                             for a stop are strictly adhered to by the transit vehicle or if they are instead
  *                             approximate and/or interpolated times. The field allows a GTFS producer to provide
  *                             interpolated stop times that potentially incorporate local knowledge, but still indicate
  *                             if the times are approximate. For stop-time entries with specified arrival and departure
  *                             times, valid values for this field are:
  *                             empty - Times are considered exact.
  *                             0 - Times are considered approximate.
  *                             1 - Times are considered exact.
  *                             For stop-time entries without specified arrival and departure times, feed consumers must
  *                             interpolate arrival and departure times. Feed producers may optionally indicate that
  *                             such an entry is not a timepoint (value=0) but it is an error to mark a entry as a
  *                             timepoint (value=1) without specifying arrival and departure times.
  */
case class StopTime(
  trip_id: String,
  arrival_time: Time,
  departure_time: Time,
  stop_id: String,
  stop_sequence: Int,
  stop_headsign: Option[String],
  pickup_type: Option[Short],
  drop_off_type: Option[Short],
  shape_dist_traveled: Option[Float],
  timepoint: Option[Short]
)

object StopTime extends CsvFile[StopTime] {
  override val fileName: String = "stop_times.txt"
}