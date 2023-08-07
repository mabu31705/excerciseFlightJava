import java.time.LocalDateTime;

public class OverseaFlight extends Flight{
    private String destinationCity;
    private String destinationCountry;
    private String destinationContinent;

    public OverseaFlight() {
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public OverseaFlight(int number,
                         LocalDateTime startTime,
                         LocalDateTime endTime,
                         String departureCity,
                         String departureCountry,
                         String departureContinent,
                         String destinationCity,
                         String destinationCountry,
                         String destinationContinent) {
        super(number, startTime, endTime, departureCity, departureCountry, departureContinent);
        this.destinationCity = destinationCity;
        this.destinationCountry = destinationCountry;
        this.destinationContinent = destinationContinent;
    }

    //        Quốc tế:
//        - Nếu 2 quốc gia cùng châu lục: 1490 * khoảng cách (km)
//        - Nếu 2 quốc gia khác châu lục: 1780 * khoảng cách (km)
    @Override
    public int calculatePrice(Location depart, Location dest) {
        double lat = depart.getLatitude() - dest.getLatitude();
        double loi = depart.getLongitude() - dest.getLongitude();
        double distance = Math.sqrt(lat * lat + loi * loi);
        int price = 0 ;
        if (depart.getContinent().equals(dest.getContinent())){
            price = (int) (1490*distance);

        } else {
            price=(int) (1780*distance);
        }
        return price;
    }
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationContinent() {
        return destinationContinent;
    }

    public void setDestinationContinent(String destinationContinent) {
        this.destinationContinent = destinationContinent;
    }

    @Override
    public String toString() {
        return "OverseaFlight{" +
                "destinationCity='" + destinationCity + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", destinationContinent='" + destinationContinent + '\'' +
                '}';
    }
}

