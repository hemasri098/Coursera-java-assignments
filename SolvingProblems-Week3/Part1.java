import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1
{
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser, "Germany");
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "gold"));
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    }
    public void countryInfo(CSVParser parser, String country) {
        boolean notFound = true;
        for(CSVRecord record : parser) {
            if(record.get("Country").equals(country)) {
                System.out.print(record.get("Country") + ": ");
                System.out.print(record.get("Exports") + ": ");
                System.out.println(record.get("Value (dollars)"));
                notFound = false;
            } 
        }
        if(notFound == true) 
            System.out.println("NOT FOUND");
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        boolean notFound = true;
        for(CSVRecord record : parser) {
            //System.out.println(record.get("Exports"));
            int exportIndex1 = record.get("Exports").indexOf(exportItem1);
            int exportIndex2 = record.get("Exports").indexOf(exportItem2);
            if(exportIndex1 != -1 && exportIndex2 != -1) {
                System.out.println(record.get("Country"));
                notFound = false;
            } 
            
        }
        if(notFound == true) 
            System.out.println("NOT FOUND");
    }
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int countCountries = 0;
        for(CSVRecord record : parser) {
            //System.out.println(record.get("Exports"));
            int exportIndex = record.get("Exports").indexOf(exportItem);
            if(exportIndex != -1) {
                countCountries += 1;
            } 
           
        }
        return countCountries;
    }
    public void bigExporters(CSVParser parser, String amount) {
        boolean notFound = true;
        for(CSVRecord record : parser) {
            //System.out.println(record.get("Exports"));
            String currAmount = record.get("Value (dollars)");
            if(currAmount.length() > amount.length()) {
                System.out.print(record.get("Country") + " ");
                System.out.println(record.get("Value (dollars)"));
                notFound = false;
            }
            else if(currAmount.length() == amount.length()) {
                int i = 1;
                while(i < currAmount.length()) {
                    if((int)currAmount.charAt(i) > (int)amount.charAt(i)) {
                        System.out.print(record.get("Country") + " ");
                        System.out.println(record.get("Value (dollars)"));
                        break;
                    }
                    else if((int)currAmount.charAt(i) < (int)amount.charAt(i)) {
                        notFound = false;
                        break;
                    }
                    else 
                        i = i + 1;
                }
                
            }
        }
        if(notFound == true) 
            System.out.println("NOT FOUND");
    }
}
