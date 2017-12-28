package com.radekstrnad.sparkgtfs.model

import org.apache.spark.sql.{Dataset, Encoder, SparkSession}

trait CsvFile[T] {

  val fileName: String

  def load(directory: String)(implicit spark: SparkSession, encoder: Encoder[T]): Dataset[T] = {
    val fullPath = if (directory.endsWith("/")) s"$directory$fileName" else s"$directory/$fileName"
    spark.read
      .option("header", true)
      .option("charset", "utf-8")
      .csv(fullPath)
      .as[T]
  }

}
