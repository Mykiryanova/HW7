import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {
    private final String PATH_TO_DB = "jdbc:sqlite:C:\\Users\\Lenovo\\Downloads\\Java_Core\\HW7\\src\\main\\resources\\Weather.db";
    private Connection connection;
    public DbHandler() throws SQLException{
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_TO_DB);
    }


    public void addWeather(Information infoWeather) throws SQLException {
try (PreparedStatement statement = this.connection.prepareStatement(
        "INSERT INTO TableOfWeather('city', 'data', 'weather_text', 'temperature') "+
                "VALUES(?, ?, ?, ?)"
)){
    statement.setObject(1, infoWeather.city);
    statement.setObject(2, infoWeather.data);
    statement.setObject(3, infoWeather.weather_text);
    statement.setObject(4, infoWeather.temperature);
    statement.execute();
}catch (SQLException exception){
    exception.printStackTrace();
}

    }
public List<Information> getAllWeather(){
    List <Information> infos = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {

    ResultSet resultSet = statement.executeQuery("SELECT city, data, weather_text, temperature FROM TableOfWeather");
    while ((resultSet.next())){
        infos.add(new Information
                (resultSet.getString("city"),
                        resultSet.getString("data"),
                        resultSet.getString("weather_text"),
                        resultSet.getInt("temperature")));
    }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return infos;
}

}
