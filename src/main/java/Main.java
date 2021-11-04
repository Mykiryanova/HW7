import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String cityName = sc.nextLine();
        String cityCode = RequestHandler.detectCity(cityName);
        System.out.println(RequestHandler.detectWeather(cityCode));


    Information weatherDay1 = new Information("Moscow", "03.11.2021", "облачно", 3);

    DbHandler dbHandler = new DbHandler();
    dbHandler.addWeather(weatherDay1);
    System.out.println(dbHandler.getAllWeather());

    }
}
