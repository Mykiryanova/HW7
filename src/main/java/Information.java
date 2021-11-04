public class Information {
    String city;
    String data;
    String weather_text;
    int temperature;

    public Information(String city, String data, String weather_text, int temperature) {
        this.city = city;
        this.data = data;
        this.weather_text = weather_text;
        this.temperature = temperature;

   }

   @Override
    public String toString(){
        return city + " " + data + " " + weather_text + " " + temperature;
   }
}
