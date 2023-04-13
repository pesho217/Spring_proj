package spring.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CSVUtils {
    public static void parseCSV(String filePath) throws IOException {
        Reader in = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        for (CSVRecord record : records) {
            List<String> firstColumn = record.toList();
            for (String value : firstColumn) {
                System.out.println(value);
            }

        }
    }
}
