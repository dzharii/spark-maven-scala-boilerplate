import java.lang.management.ManagementFactory

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import utils.MyEnv

object BatchJob {

  def main (args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("Batch Job in Spark")

    // Check if running from IDE
    // See https://github.com/steveloughran/winutils
    if (MyEnv.isRunningUnderIDE) {

      if (MyEnv.isWindows) {
        System.setProperty("hadoop.home.dir", "C:\\Lib\\winutils\\hadoop-2.7.1") // required for winutils
      }
      conf.setMaster("local[*]")
    }

    // setup spark context
    val sc = new  SparkContext(conf)

    val line = "Hello, world"
    val rdd: RDD[Char] = sc.parallelize(line.toCharArray)
    rdd.foreach(c => Thread.sleep(1000))
    println(rdd.count())

  }
}
