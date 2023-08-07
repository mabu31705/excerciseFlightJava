import java.time.LocalDateTime;

public class Flight {
    private int number;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String departureCity;
    private String departureCountry;
    private String departureContinent;

    public Flight() {
    }

    public Flight(int number, LocalDateTime startTime, LocalDateTime endTime, String departureCity, String departureCountry, String departureContinent) {
        this.number = number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.departureCity = departureCity;
        this.departureCountry = departureCountry;
        this.departureContinent = departureContinent;
    }
    public int calculatePrice(Location depart,Location destination){
        return 0;
    };

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDepartureContinent() {
        return departureContinent;
    }

    public void setDepartureContinent(String departureContinent) {
        this.departureContinent = departureContinent;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", departureCity='" + departureCity + '\'' +
                ", departureCountry='" + departureCountry + '\'' +
                ", departureContinent='" + departureContinent + '\'' +
                '}';
    }
}
