package PageObjectModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Csvutil {

    public static Object[][] getCSVData(String path) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        List<Object[]> data = new ArrayList<>();

        // Skip header row
        br.readLine();

        while ((line = br.readLine()) != null) {

            String[] values = line.split(",");

            data.add(new Object[]{
                    values[0],   // username
                    values[1]    // password
            });
        }

        br.close();

        Object[][] result = new Object[data.size()][2];

        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }

        return result;
    }
}
