package PageObjectModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLutill {

    public static Object[][] getDBData() throws Exception {

        String url = "jdbc:mysql://localhost:3306/automationdb";
        String user = "root";
        String password = "Vb#251566"; // your mysql password

        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username, password FROM login_data");

        List<Object[]> data = new ArrayList<>();

        while (rs.next()) {
            data.add(new Object[]{
                    rs.getString("username"),
                    rs.getString("password")
            });
        }

        rs.close();
        stmt.close();
        con.close();

        Object[][] result = new Object[data.size()][2];

        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }

        return result;
    }
}
