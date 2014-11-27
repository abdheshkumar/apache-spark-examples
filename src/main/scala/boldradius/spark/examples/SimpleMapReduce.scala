package boldradius.spark.examples

import boldradius.spark.data.DataSource
import boldradius.spark.util.SparkUtils._

/**
 * @author Dmitri Carpov
 */
object SimpleMapReduce extends App {
  inSpark { context =>
    val result = context.
      parallelize(DataSource.sentences).
      map(line => line.split(" ").size).
      reduce((a, b) => Math.max(a, b))

    printFormatted(result)
  }
}
