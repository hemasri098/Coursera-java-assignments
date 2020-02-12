import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1
{
    public CSVRecord coldestHourFile(CSVParser parser) {
       float coldTemp = 100;
       CSVRecord record = null;
       for(CSVRecord currRecord: parser) {
           if(Float.parseFloat(currRecord.get("TemperatureF")) < coldTemp && Float.parseFloat(currRecord.get("TemperatureF")) != -9999) {
            coldTemp = Float.parseFloat(currRecord.get("TemperatureF"));
            record = currRecord;
           }
       }
       return record;
    }
    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(coldestHourFile(parser).get("TemperatureF"));
    }
    public String fileWithColdestTemperature() {
        File temp = null;    
        DirectoryResource dr = new DirectoryResource();
        float coldTemp = 100;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord record = null;
            for(CSVRecord currRecord: parser) {
               if(Float.parseFloat(currRecord.get("TemperatureF")) < coldTemp && Float.parseFloat(currRecord.get("TemperatureF")) != -9999) {
                coldTemp = Float.parseFloat(currRecord.get("TemperatureF"));
                record = currRecord;
                temp = f;
               }
            }
        }
        return temp.getName();
    }
    public void testfileWithColdestTemperature() {
        String fileName = fileWithColdestTemperature();
        System.out.println("Coldest day in the file: " + fileName);
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Coldest day of temperature: " + coldestHourFile(parser).get("TemperatureF"));
        parser = fr.getCSVParser();
        System.out.println("All the temperatures on coldest day were: "); 
        for(CSVRecord record: parser) {
           System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
           
       }
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
       float lowHum = 100;
       CSVRecord record = null;
       for(CSVRecord currRecord: parser) {
           //System.out.println(currRecord);
           if(currRecord.get("Humidity").equals("N/A") == false && Float.parseFloat(currRecord.get("Humidity")) < lowHum ) {
            //System.out.println(currRecord.get("Humidity"));
            //System.out.println(currRecord);
            lowHum = Float.parseFloat(currRecord.get("Humidity"));
            record = currRecord;
           }
       }
       System.out.println(record.get("Humidity"));
       return record;
    }
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord record = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + record.get("Humidity") + " at " + record.get("DateUTC") );
    }
    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord record = null;
        DirectoryResource dr = new DirectoryResource();
        float lowHum = 100;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            for(CSVRecord currRecord: parser) {
               if(!currRecord.get("Humidity").equals("N/A") && Float.parseFloat(currRecord.get("Humidity")) < lowHum ) {
                    lowHum = Float.parseFloat(currRecord.get("Humidity"));
                    record = currRecord;
                    
               }
            }
        }
        return record;
    }
    public void testLowestHumidityInManyFiles() {
        CSVRecord record = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + record.get("Humidity") + " at " + record.get("DateUTC"));
    }
    public double averageTemperatureInFile(CSVParser parser) {
       double avgTemp = 0;
       int count = 0; 
       CSVRecord record = null;
       for(CSVRecord currRecord: parser) {
           if(Double.parseDouble(currRecord.get("TemperatureF")) != -9999) {
            avgTemp += Double.parseDouble(currRecord.get("TemperatureF"));
           }
           count += 1;
       }
       return avgTemp / count;
    }
    public void testAverageTemperatureInFile() {
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       System.out.println("Average temperatures in that file is " + averageTemperatureInFile(parser));
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
       double avgTemp = 0;
       int count = 0; 
       boolean notFound = true;
       CSVRecord record = null;
       for(CSVRecord currRecord: parser) {
           if(Double.parseDouble(currRecord.get("TemperatureF")) != -9999 && value <= Double.parseDouble(currRecord.get("Humidity"))) {
            avgTemp += Double.parseDouble(currRecord.get("TemperatureF"));
            notFound = false;
            count += 1;
           }
           
       }
       if(!notFound) {
        return avgTemp / count;
       }
       return -1;
    }
    public void testAverageTemperatureWithHighHumidityInFile() {
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       double val = averageTemperatureWithHighHumidityInFile(parser, 80);
       if(val == -1) {
        System.out.println("No temperatures with that humidity");
       }
       else {
        System.out.println("Average temperatures with that humidity is " + val);
       }
    }
}
