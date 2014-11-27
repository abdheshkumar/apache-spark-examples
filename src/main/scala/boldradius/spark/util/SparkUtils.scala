package boldradius.spark.util

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Dmitri Carpov
 */
object SparkUtils {
  def inSpark(f: SparkContext => Unit): Unit = {
    val configuration = new SparkConf().setAppName("spark-demo")
    val context = new SparkContext(configuration)

    f(context)

    context.stop()
  }

  def printFormatted(string: Any) = println(s"\n\n\nResult: $string\n\n\n")
}
