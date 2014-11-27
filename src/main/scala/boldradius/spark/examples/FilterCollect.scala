package boldradius.spark.examples

import boldradius.spark.data.DataSource
import boldradius.spark.util.SparkUtils._

/**
 * @author Dmitri Carpov
 */
object FilterCollect extends App {
  inSpark { context =>
    val result = context.
      parallelize(DataSource.sentences).
      filter(line => line.contains("dolor")).
      collect()

    result.foreach(printFormatted(_))
  }
}
