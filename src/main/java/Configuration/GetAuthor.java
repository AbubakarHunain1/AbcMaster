package Configuration;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAuthor {
    public List<BookObj> getData(String authorname) {

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



            PreparedStatement pstmt = connection.prepareStatement("select b.ID,b.TITLE,a.NAME FROM BOOK b LEFT JOIN AUTHOR a ON b.AUTHOR_ID = a.ID where a.name = ?");
            pstmt.setString(1, (authorname));
            ResultSet results = pstmt.executeQuery();





// For each row of the result set ...
            List<BookObj> books = new ArrayList<>();
            while (results.next()) {


                // Get the data from the current row using the column index - column data are in the VARCHAR format

                String data = results.getString(1);

                System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);


                // Get the data from the current row using the column name - column data are in the VARCHAR format

                data = results.getString("TITLE");
                String author = results.getString("Name");
                Integer id = results.getInt("ID");

                BookObj a = new BookObj();
                a.setAuthor(author);
                a.setId(id);
                a.setTitle(data);
                books.add(a);


            }
            return books;

        } catch (SQLException e) {

            System.out.println("Could not retrieve data from the database " + e.getMessage());
            return null;
        }

    }
}