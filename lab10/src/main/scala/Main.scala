import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object Main {
  def main(args: Array[String]): Unit = {


    val conf = new SparkConf().setAppName("CounterDemo").setMaster("local[*]")
    val sc = new SparkContext(conf);
    val spark = SparkSession.builder.appName("Test app").getOrCreate()

    println("Hello world!")

    val datafile = spark.read
      .format("com.databricks.spark.csv")
      .option("header", true)
      .load("/home/ismoil/projects/IdeaProjects/lab10/russian_demography.csv")
    // datafile.show()
    datafile.createOrReplaceTempView("demography")
//    spark.sql("SELECT COUNT(*) FROM demography").show()
    spark.sql("select * from demography").show()
//    // 1
    spark.sql("SELECT * FROM demography WHERE year = 2014").show()
//    // 2
    spark.sql("SELECT * FROM demography WHERE year = 2015 AND region = 'Moscow'").show()
    // 3
    spark.sql("SELECT * FROM demography WHERE year = 2017 ORDER BY npg DESC LIMIT 5").show()
//    // 4
    spark.sql("SELECT year, AVG(birth_rate) AS avg_birth_rate, AVG(death_rate) AS avg_death_rate FROM demography WHERE year = 2000 GROUP BY year").show()
//    // 5
    spark.sql("SELECT * FROM demography WHERE year = 2001 AND npg < 0").show()
//    // 6
    spark.sql("SELECT * FROM demography WHERE year = 2002 ORDER BY gdw DESC LIMIT 1").show()
//    // 7
    spark.sql("SELECT AVG(urbanization) AS avg_urbanization FROM demography").show()
//    // 8
    spark.sql("SELECT year, MAX(birth_rate) AS max_birth_rate FROM demography GROUP BY year").show()
//    // 9
    spark.sql("SELECT year, death_rate, region FROM demography ORDER BY death_rate DESC LIMIT 5").show()
//    // 10
    spark.sql("SELECT * FROM demography WHERE year = 2004 ORDER BY urbanization DESC LIMIT 1").show()

    spark.stop()
  }
}