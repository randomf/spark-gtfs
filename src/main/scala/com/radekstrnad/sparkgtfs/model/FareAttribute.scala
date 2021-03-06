package com.radekstrnad.sparkgtfs.model

/**
  * Fare information for a transit organization's routes.
  *
  * @param fare_id            The fare_id field contains an ID that uniquely identifies a fare class. The fare_id
  *                           is dataset unique.
  * @param price              The price field contains the fare price, in the unit specified by currency_type.
  * @param currency_type      The currency_type field defines the currency used to pay the fare. Please use the ISO 4217
  *                           alphabetical currency codes which can be found at the following URL:
  *                           http://en.wikipedia.org/wiki/ISO_4217.
  * @param payment_method     The payment_method field indicates when the fare must be paid. Valid values for this field are:
  *                           0 - Fare is paid on board.
  *                           1 - Fare must be paid before boarding.
  * @param transfer           The transfers field specifies the number of transfers permitted on this fare. Valid values
  *                           for this field are:
  *                           0 - No transfers permitted on this fare.
  *                           1 - Passenger may transfer once.
  *                           2 - Passenger may transfer twice.
  *                           (empty) - If this field is empty, unlimited transfers are permitted.
  * @param agency_id          Required for feeds with multiple agencies defined in the agency.txt file. Each fare
  *                           attribute must specify an agency_id value to indicate which agency the fare applies to.
  * @param transfer_duration  The transfer_duration field specifies the length of time in seconds before a transfer
  *                           expires. When used with a transfers value of 0, the transfer_duration field indicates how
  *                           long a ticket is valid for a fare where no transfers are allowed. Unless you intend to use
  *                           this field to indicate ticket validity, transfer_duration should be omitted or empty when
  *                           transfers is set to 0.
  */
case class FareAttribute(
  fare_id: String,
  price: Float,
  currency_type: String,
  payment_method: Short,
  transfer: Short,
  agency_id: Option[String],
  transfer_duration: Option[Int]
)

object FareAttribute extends CsvFile[FareAttribute] {
  override val fileName: String = "fare_attributes.txt"
}