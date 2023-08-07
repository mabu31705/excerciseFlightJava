import java.time.LocalDateTime;

public class DomesticFlight extends Flight {
    private String destinationCity;

    public DomesticFlight() {
    }

    public DomesticFlight(int number, LocalDateTime startTime, LocalDateTime endTime, String departureCity, String departureCountry, String departureContinent, String destinationCity) {
        super(number, startTime, endTime, departureCity, departureCountry, departureContinent);
        this.destinationCity = destinationCity;
    }
//    Nội địa: 1120 * khoảng cách (km)


    @Override
    public int calculatePrice(Location depart,Location dest) {
        double lat = depart.getLatitude() - dest.getLatitude();
        double loi = depart.getLongitude() - dest.getLongitude();
        double distance = Math.sqrt(lat * lat + loi * loi);
        int price = (int) (1120 * distance);
        return price;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Override
    public String toString() {
        return "DomesticFlight{" +
                "destinationCity='" + destinationCity + '\'' +
                '}';
    }
}
