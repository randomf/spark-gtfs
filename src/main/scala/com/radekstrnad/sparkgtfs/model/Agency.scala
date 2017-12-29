package com.radekstrnad.sparkgtfs.model

/**
  * One or more transit agencies that provide the data in this feed.
  *
  * @param agency_id	      The agency_id field is an ID that uniquely identifies a transit agency.
  *                         A transit feed may represent data from more than one agency. The agency_id is dataset unique.
  *                         This field is optional for transit feeds that only contain data for a single agency.
  * @param agency_name	    The agency_name field contains the full name of the transit agency.
  * @param agency_url	      The agency_url field contains the URL of the transit agency. The value must be a fully
  *                         qualified URL that includes http:// or https://, and any special characters in the URL must
  *                         be correctly escaped. See http://www.w3.org/Addressing/URL/4_URI_Recommentations.html for
  *                         a description of how to create fully qualified URL values.
  * @param agency_timezone	The agency_timezone field contains the timezone where the transit agency is located.
  *                         Timezone names never contain the space character but may contain an underscore. Please
  *                         refer to http://en.wikipedia.org/wiki/List_of_tz_zones for a list of valid values.
  *                         If multiple agencies are specified in the feed, each must have the same agency_timezone.
  * @param agency_lang	    The agency_lang field contains a two-letter ISO 639-1 code for the primary language used
  *                         by this transit agency. The language code is case-insensitive (both en and EN are accepted).
  *                         This setting defines capitalization rules and other language-specific settings for all text
  *                         contained in this transit agency's feed. Please refer to
  *                         http://www.loc.gov/standards/iso639-2/php/code_list.php for a list of valid values.
  * @param agency_phone	    The agency_phone field contains a single voice telephone number for the specified agency.
  *                         This field is a string value that presents the telephone number as typical for the agency's
  *                         service area. It can and should contain punctuation marks to group the digits of the number.
  *                         Dialable text (for example, TriMet's "503-238-RIDE") is permitted, but the field must not
  *                         contain any other descriptive text.
  * @param agency_fare_url	The agency_fare_url specifies the URL of a web page that allows a rider to purchase tickets
  *                         or other fare instruments for that agency online. The value must be a fully qualified URL
  *                         that includes http:// or https://, and any special characters in the URL must be correctly
  *                         escaped. See http://www.w3.org/Addressing/URL/4_URI_Recommentations.html for a description
  *                         of how to create fully qualified URL values.
  * @param agency_email	    Contains a single valid email address actively monitored by the agency’s customer service
  *                         department. This email address will be considered a direct contact point where transit
  *                         riders can reach a customer service representative at the agency.
  */
case class Agency(
  agency_id: Option[String],
  agency_name: String,
  agency_url: String,
  agency_timezone: String,
  agency_lang: Option[String],
  agency_phone: Option[String],
  agency_fare_url: Option[String],
  agency_email: Option[String]
)

object Agency extends CsvFile[Agency] {
  override val fileName: String = "agency.txt"
}
