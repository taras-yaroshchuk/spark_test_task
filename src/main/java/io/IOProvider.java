package io;

import model.CountryYearToSuicideAmountToGdp;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.List;


public class IOProvider {
  private static final String OUT_PATH = "C:/Users/enric/IdeaProjects/study/"
          + "humanlves/spark/output";

  public void writeAsParquetFile(List<CountryYearToSuicideAmountToGdp> toWrite) {
    Dataset<Row> data = getSparkSession().createDataFrame(
            toWrite,
            CountryYearToSuicideAmountToGdp.class
    );
    data.write().parquet(OUT_PATH);
  }

  private SparkSession getSparkSession() {
    return SparkSession.builder()
            .appName("humanlves")
            .config("spark.master", "local")
            .getOrCreate();
  }
}
