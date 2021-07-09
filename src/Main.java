import java.lang.reflect.Field;
import java.sql.*;

public class Main {

    public static Connection dbConnection() throws SQLException {
        String url ="jdbc:mysql://127.0.0.1:3306/JDBC2";
        Connection connection = DriverManager.getConnection(url, "root", "Misha123");
        return connection;
    }

    public static void populateCountries(Connection connection) throws SQLException, NoSuchFieldException, IllegalAccessException {
        PreparedStatement getAllCountries = null;
        String getAllCountriesSql = "SELECT * FROM countries";
        getAllCountries = connection.prepareStatement(getAllCountriesSql);
        ResultSet resultSet = getAllCountries.executeQuery();

        while (resultSet.next()){
            /*Country.addCountry(new Country(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("capital")));*/
            Country country = new Country();
            Field idField = country.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(country, resultSet.getInt("id"));

            Field nameField = country.getClass().getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(country, resultSet.getString("name"));

            Field capitalField = country.getClass().getDeclaredField("capital");
            capitalField.setAccessible(true);
            capitalField.set(country, resultSet.getString("capital"));

            Country.addCountry(country);
        }

        Country.showCountry();
    }

    public static void populatePresidents(Connection connection) throws SQLException{
        PreparedStatement getAllPresidents = null;
        String getAllPresidentsSql = "SELECT * FROM presidents";
        getAllPresidents = connection.prepareStatement(getAllPresidentsSql);
        ResultSet resultSet = getAllPresidents.executeQuery();

        while(resultSet.next()){
            President.addPresident(new President((resultSet.getInt("id")),
                    resultSet.getString("name"),
                    resultSet.getInt("country")));
        }

        //President.showPresidents();
    }



    public static void main(String[] args) throws SQLException, NoSuchFieldException, IllegalAccessException {
        Connection connection = dbConnection();
        populateCountries(connection);
        populatePresidents(connection);

        President.showPresidents(President.nameLengthOver11());
    }
}
