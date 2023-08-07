import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        1. Lập 1 danh sách các chuyến bay List<Flight>
        List<Flight> flights = List.of(
                new DomesticFlight(1,
                        LocalDateTime.of(2023, 8, 1, 12, 0),
                        LocalDateTime.of(2023, 8, 4, 18, 0),
                        "Ho Chi Minh", "Viet Nam", "Chau A", "Ha Noi"),
                new DomesticFlight(2,
                        LocalDateTime.of(2023, 8, 1, 12, 0),
                        LocalDateTime.of(2023, 8, 4, 18, 0),
                        "Ho Chi Minh", "Viet Nam", "Chau A", "Ha Noi"),
                new OverseaFlight(10,
                        LocalDateTime.of(2023, 8, 4, 17, 0),
                        LocalDateTime.of(2023, 8, 2, 21, 0),
                        "Ha Noi", "Viet Nam", "Chau A", "London", "England", "Chau Au"),
                new OverseaFlight(20,
                        LocalDateTime.of(2023, 8, 4, 17, 0),
                        LocalDateTime.of(2023, 8, 2, 21, 0),
                        "Ha Noi", "Viet Nam", "Chau A", "London", "England", "Chau Au")
        );
//2. Tìm danh sách các chuyến bay nội địa đến Hà Nội ngày 4/8/2023
        LocalDate targetDate = LocalDate.of(2023, 8, 4);
        List<Flight> searchDomesticFlightOnDate = flights.stream()
                .filter(searchTypeOfFlight -> searchTypeOfFlight instanceof DomesticFlight)
                .filter(searchDestination -> ((DomesticFlight) searchDestination).getDestinationCity().equals("Ha Noi"))
                .filter(searchTargetDate -> searchTargetDate.getEndTime().toLocalDate().equals(targetDate))
                .collect(Collectors.toList());
        searchDomesticFlightOnDate.forEach(item -> System.out.println("chuyen bay so: " + item.getNumber() + "\n" + "chuyen bay bat dau luc: " + item.getStartTime() + "\n" + "khoi hanh tu: " + item.getDepartureCity()));
//        3. Tìm danh sách các chuyến bay quốc tế xuất phát từ Hà Nội, Việt Nam ngày 4/8/2023
        List<Flight> searchOverseaFlightOnDate = flights.stream()
                .filter(searchTypeOfFlight -> searchTypeOfFlight instanceof OverseaFlight)
                .filter(searchDestination -> searchDestination.getDepartureCity().equals("Ha Noi"))
                .filter(searchTargetDate -> searchTargetDate.getStartTime().toLocalDate().equals(targetDate))
                .collect(Collectors.toList());
        searchOverseaFlightOnDate.forEach(item -> System.out.println("chuyen bay so: " + item.getNumber() + "\n" + "chuyen bay bat dau luc: " + item.getStartTime() + "\n" + "khoi hanh tu: " + item.getDepartureCity()));

        //      1. Khởi tạo danh sách các địa điểm List<Location> chứa tất cả điểm bay đi/đến và kinh độ, vĩ độ tương ứng
        List<Location> locations = List.of(
                new Location("Ha Noi", "Viet Nam", "Chau A", 10, 20),
                new Location("Ho Chi Minh", "Viet Nam", "Chau A", 30, 40),
                new Location("London", "England", "Chau Au", 50, 60)
        );
        //        2. Với cách tính giá vé (VND) cho từng chuyến bay như sau:
//        Nội địa: 1120 * khoảng cách (km)
//        Quốc tế:
//        - Nếu 2 quốc gia cùng châu lục: 1490 * khoảng cách (km)
//        - Nếu 2 quốc gia khác châu lục: 1780 * khoảng cách (km)
//        Thêm method calculatePrice() vào các class Flight, DomesticFlight và OverseaFlight. In ra giá vé tương ứng với từng chuyến bay.
//        Câu hỏi: class Flight nên chỉnh sửa gì thì phù hợp?

        List<Integer> collect = flights.stream()
                .filter(domestic -> domestic instanceof DomesticFlight)
                .map(
                        domesticCity -> {
                            Location[] destination = new Location[2];
                            locations.forEach(item -> {
                                if (
                                        item.getCity().equals(((DomesticFlight) domesticCity).getDestinationCity())
                                ) {
                                    destination[0] = item;
                                }
                                if (
                                        item.getCity().equals(domesticCity.getDepartureCity())
                                ) {
                                    destination[1] = item;
                                }

                            });
                            int price = domesticCity.calculatePrice(destination[1], destination[0]);
                            return price;
                        }
                )
                .collect(Collectors.toList());

        List<Integer> collect1 = flights.stream()
                .filter(oversea -> oversea instanceof OverseaFlight)
                .map(
                        overseaCity -> {
                            Location[] destination = new Location[2];
                            locations.forEach(item -> {
                                if (
                                        item.getCity().equals(((OverseaFlight) overseaCity).getDestinationCity())
                                ) {
                                    destination[0] = item;
                                }
                                if (
                                        item.getCity().equals(overseaCity.getDepartureCity())
                                ) {
                                    destination[1] = item;
                                }

                            });
                            int price = overseaCity.calculatePrice(destination[1], destination[0]);
                            return price;
                        }
                )
                .collect(Collectors.toList());

        System.out.println("Gia ve chuyen bay noi dia : "+ collect +"\n"+ "Gia ve chuyen bay quoc te: " + collect1);

    }
}
