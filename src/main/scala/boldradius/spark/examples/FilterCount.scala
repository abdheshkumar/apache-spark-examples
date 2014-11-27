package boldradius.spark.examples

import boldradius.spark.data.DataSource
import boldradius.spark.util.SparkUtils._

/**
 * @author Dmitri Carpov
 */
object FilterCount extends App {
  inSpark { context =>
    val result = context.
      parallelize(DataSource.sentences).
      filter(line => line.contains("dolor")).count()

    printFormatted(result)
  }
}
