## LnL: Apache Spark

1. Download Apache Spark binary (select Pre-built for CDH)
   http://spark.apache.org/downloads.html

2. Unpack downloaded archive

3. Run the cluster manager (will be provided!)

    <pre>
    > cd &lt;spark directory&gt;
    > ./sbin/start-master.sh
    </pre>

4. Run worker connected to the cluster manager

    <pre>
    > cd &lt;spark directory&gt;
    > ./bin/spark-class org.apache.spark.deploy.worker.Worker spark://&lt;cluster manager ip&gt;:7077
    </pre>

5. Compile and run SimpleMapReduce example

    <pre>
    > cd &lt;project root&gt;
    > sbt package
    > &lt;spark directory&gt;/bin/spark-submit --class boldradius.spark.examples.SimpleMapReduce \
      --master spark://&lt;cluster manager ip&gt;:7077 target/scala-2.10/spark_examples_2.10-1.0.jar
    </pre>

To run other examples use:

 - boldradius.spark.examples.FilterCollect
 - boldradius.spark.examples.FilterCount
 - boldradius.spark.examples.LineNumbers