package boldradius.spark.examples

import boldradius.spark.data.DataSource
import boldradius.spark.util.SparkUtils._

/**
 * @author Dmitri Carpov
 */
object LineNumbers extends App {
  inSpark { context =>
    val result = context.
      parallelize(DataSource.sentences).
      mapPartitionsWithIndex((index, lines) => getLinesNumbers("dolor", index)(lines)).collect()

    result.foreach(printFormatted(_))
  }

  private def getLinesNumbers(word: String, chunkIndex: Int)(sentences: Iterator[String]): Iterator[Int] = {
    sentences.zipWithIndex.foldLeft(Seq.empty[Int]) {
      case (result, (line, index)) =>
        if (line.contains(word)) {
          result :+ index + chunkIndex
        } else {
          result
        }
    }.toIterator
  }
}
