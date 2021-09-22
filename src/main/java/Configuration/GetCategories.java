package Configuration;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetCategories {

    public List<BookObj> getData(int categoryid) {

        Connection connection = null;
        try {

            String serverName = "localhost:3306";

            String schema = "book";

            String url = "jdbc:mysql://" + serverName + "/" + schema;

            String username = "root";

            String password = "admin123";

            connection = DriverManager.getConnection(url, username, password);


            System.out.println("Successfully Connected to the database!");


        } catch (SQLException e) {

            System.out.println("Could not connect to the database " + e.getMessage());
            return null;
        }

        try {


// Get a result set containing all data from test_table


            PreparedStatement pstmt = connection.prepareStatement("select a.NAME, c.ID,c.CATEGORIES,b.TITLE FROM categories c LEFT JOIN book b ON c.ID = b.CATEGORIES_ID LEFT JOIN author a on a.ID = b.AUTHOR_ID where c.ID = ?");
            pstmt.setInt(1, categoryid);
            ResultSet results = pstmt.executeQuery();


// For each row of the result set ...
            List<BookObj> books = new ArrayList<>();
            while (results.next()) {


                // Get the data from the current row using the column index - column data are in the VARCHAR format

                String data = results.getString(1);

                System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);


                // Get the data from the current row using the column name - column data are in the VARCHAR format

                data = results.getString("TITLE");
                String author = results.getString("NAME");
                Integer id = results.getInt("ID");
                String categories = results.getString("CATEGORIES");

                BookObj a = new BookObj();
                a.setAuthor(author);
                a.setId(id);
                a.setTitle(data);
                a.setcategories(categories);
                books.add(a);


            }
            return books;

        } catch (SQLException e) {

            System.out.println("Could not retrieve data from the database " + e.getMessage());
            return null;
        }

    }
}