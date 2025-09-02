

import java.time.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

/** Entry point */
public class SmartCity {

    public static void main(String[] args) {
        // Geo points
        GeoPoint central = new GeoPoint(28.6139, 77.2090); // City Center
        GeoPoint sector21 = new GeoPoint(28.4950, 77.0880);
        GeoPoint techPark = new GeoPoint(28.4946, 77.0956);
        GeoPoint riverDock = new GeoPoint(28.6000, 77.2500);

        // Fare calculators (Functional Interface via lambdas)
        FareCalculator busFare = trip -> 10 + 1.75 * trip.distanceKm + (trip.isPeak ? 5 : 0);
        FareCalculator metroFare = trip -> 15 + 1.25 * trip.distanceKm + (trip.isPeak ? 7 : 0);
        FareCalculator taxiFare = trip -> 40 + 8.5 * trip.distanceKm + (trip.isPeak ? 10 : 0);
        FareCalculator ferryFare = trip -> 20 + 2.25 * trip.distanceKm + (trip.isPeak ? 6 : 0);
        FareCalculator ambulanceFare = trip -> 0; // emergency — no charge

        // Services
        TransportService bus = new BusService(
                "B-12", "City Bus Line 12",
                Arrays.asList(
                        new ScheduleEntry("CENTRAL→SECTOR21", central, sector21, LocalTime.of(8, 10), true, 0),
                        new ScheduleEntry("CENTRAL→SECTOR21", central, sector21, LocalTime.of(8, 40), true, 0),
                        new ScheduleEntry("CENTRAL→SECTOR21", central, sector21, LocalTime.of(9, 10), false, 0),
                        new ScheduleEntry("SECTOR21→CENTRAL", sector21, central, LocalTime.of(18, 5), true, 0)
                ),
                busFare
        );

        TransportService metro = new MetroService(
                "M-Blue", "Metro Blue Line",
                Arrays.asList(
                        new ScheduleEntry("CENTRAL↔TECHPARK", central, techPark, LocalTime.of(8, 0), true, 0),
                        new ScheduleEntry("CENTRAL↔TECHPARK", central, techPark, LocalTime.of(8, 15), true, 0),
                        new ScheduleEntry("CENTRAL↔TECHPARK", central, techPark, LocalTime.of(9, 0), false, 0),
                        new ScheduleEntry("CENTRAL↔TECHPARK", central, techPark, LocalTime.of(18, 0), true, 0)
                ),
                metroFare
        );

        TransportService taxi = new TaxiService(
                "TX-POOL", "City Taxi (Pool)",
                Arrays.asList(
                        new ScheduleEntry("ON-DEMAND", central, techPark, LocalTime.of(8, 5), true, 200),
                        new ScheduleEntry("ON-DEMAND", techPark, sector21, LocalTime.of(9, 35), false, 150),
                        new ScheduleEntry("ON-DEMAND", sector21, central, LocalTime.of(18, 25), true, 230)
                ),
                taxiFare
        );

        TransportService ferry = new FerryService(
                "F-River", "River Ferry",
                Arrays.asList(
                        new ScheduleEntry("DOCK↔CENTRAL", riverDock, central, LocalTime.of(7, 45), false, 0),
                        new ScheduleEntry("DOCK↔CENTRAL", riverDock, central, LocalTime.of(8, 30), true, 0),
                        new ScheduleEntry("DOCK↔CENTRAL", riverDock, central, LocalTime.of(17, 30), true, 0)
                ),
                ferryFare
        );

        TransportService ambulance = new AmbulanceService(
                "AMB-01", "Emergency Ambulance",
                Arrays.asList(
                        new ScheduleEntry("ANYWHERE", central, sector21, LocalTime.of(8, 2), true, 0)
                ),
                ambulanceFare
        );

        List<TransportService> services = Arrays.asList(bus, metro, taxi, ferry, ambulance);

        // 1) Passenger searches — Lambda filters & sorts schedules (earliest then lowest fare estimate)
        LocalTime desiredAfter = LocalTime.of(8, 0);
        GeoPoint origin = central;
        GeoPoint destination = sector21;

        List<ServiceOption> options = services.stream()
                .flatMap(svc -> svc.getSchedule().stream()
                        .filter(s -> s.departure.isAfter(desiredAfter))
                        .map(s -> {
                            double dist = GeoUtils.calculateDistanceKm(s.from.lat, s.from.lon, s.to.lat, s.to.lon);
                            boolean peak = s.peak;
                            Trip tmpTrip = new Trip(null, svc, s, dist, 0, LocalDateTime.now(), peak);
                            double estimatedFare = svc.estimateFare(tmpTrip);
                            return new ServiceOption(svc, s, estimatedFare, dist);
                        })
                )
                .filter(opt -> roughlySameDestination(destination, opt.entry.to))
                .sorted(Comparator
                        .comparing((ServiceOption o) -> o.entry.departure)
                        .thenComparingDouble(o -> o.estimatedFare))
                .collect(toList());

        Logger.log("\n=== Matched Options (Earliest → Lowest Fare) ===");
        options.forEach(o -> Logger.log(String.format(
                "%s | %s | dep %s | ~%.1f km | ₹%.2f",
                o.service.getType(), o.service.getName(), o.entry.departure, o.distanceKm, o.estimatedFare)));

        // 2) Dashboard live update — forEach
        Logger.log("\n=== Live Schedules Dashboard ===");
        services.forEach(TransportService::displayLiveSchedules);

        // 3) Simulate trips & revenue reports — Stream + Collectors
        List<Passenger> passengers = Arrays.asList(
                new Passenger("P1", "Aarav"),
                new Passenger("P2", "Diya"),
                new Passenger("P3", "Kabir"),
                new Passenger("P4", "Ira"),
                new Passenger("P5", "Rohit")
        );

        // Create synthetic trips using top schedules from each service
        List<Trip> trips = new ArrayList<>();
        Random rnd = new Random(42);
        passengers.forEach(p -> {
            services.forEach(svc -> {
                svc.getSchedule().stream().limit(1).forEach(se -> {
                    GeoPoint from = se.from;
                    GeoPoint to = se.to;
                    double dist = GeoUtils.calculateDistanceKm(from.lat, from.lon, to.lat, to.lon);
                    boolean peak = se.peak || rnd.nextBoolean();
                    Trip t = new Trip(p, svc, se, dist, 0, LocalDateTime.of(LocalDate.now(), se.departure), peak);
                    t.fare = svc.estimateFare(t);
                    trips.add(t);
                });
            });
        });

        // 3a) Group passengers by route
        Logger.log("\n=== Passengers by Route (groupingBy) ===");
        Map<String, List<String>> paxByRoute = trips.stream()
                .collect(groupingBy(t -> t.entry.routeId, mapping(t -> t.passenger.name, toList())));
        paxByRoute.forEach((route, names) -> Logger.log(route + " -> " + names));

        // 3b) Partition trips by peak vs non-peak
        Logger.log("\n=== Trips Partitioned by Peak (partitioningBy) ===");
        Map<Boolean, List<Trip>> byPeak = trips.stream().collect(partitioningBy(t -> t.isPeak));
        Logger.log("Peak count: " + byPeak.get(true).size() + " | Off-peak count: " + byPeak.get(false).size());

        // 3c) Summaries of fares
        Logger.log("\n=== Fare Summary (summarizingDouble) ===");
        DoubleSummaryStatistics fareStats = trips.stream().collect(summarizingDouble(t -> t.fare));
        Logger.log(String.format("Total ₹%.2f | Avg ₹%.2f | Min ₹%.2f | Max ₹%.2f | Trips %d",
                fareStats.getSum(), fareStats.getAverage(), fareStats.getMin(), fareStats.getMax(), fareStats.getCount()));

        // 3d) Revenue by service type
        Logger.log("\n=== Revenue by Service Type ===");
        Map<String, Double> revenueByType = trips.stream().collect(groupingBy(t -> t.service.getType(), summingDouble(t -> t.fare)));
        revenueByType.forEach((type, sum) -> Logger.log(type + " -> ₹" + String.format("%.2f", sum)));

        // 3e) Top used routes (by trip count)
        Logger.log("\n=== Top Routes by Usage ===");
        List<Map.Entry<String, Long>> topRoutes = trips.stream()
                .collect(groupingBy(t -> t.entry.routeId, counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(toList());
        topRoutes.forEach(e -> Logger.log(e.getKey() + " -> " + e.getValue() + " trips"));

        // 4) System expansion — Ferry already added by implementing interfaces (works above)

        // 5) Emergency detection via Marker Interface
        Logger.log("\n=== Emergency Prioritization ===");
        services.stream()
                .filter(svc -> svc instanceof EmergencyService)
                .map(TransportService::getName)
                .forEach(n -> Logger.log("PRIORITY: " + n + " (Emergency)"));
    }

    private static boolean roughlySameDestination(GeoPoint desired, GeoPoint actual) {
        return GeoUtils.calculateDistanceKm(desired.lat, desired.lon, actual.lat, actual.lon) < 1.5;
    }
}

/** --------- Core Domain --------- */

final class GeoPoint {
    final double lat, lon;
    GeoPoint(double lat, double lon) { this.lat = lat; this.lon = lon; }
}

interface GeoUtils {
    static double calculateDistanceKm(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371.0;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2)*Math.sin(dLat/2)
                + Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon/2)*Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}

final class ScheduleEntry {
    final String routeId;
    final GeoPoint from;
    final GeoPoint to;
    final LocalTime departure;
    final boolean peak;
    final double baseFareHint; // optional (e.g., taxi surge/base)

    ScheduleEntry(String routeId, GeoPoint from, GeoPoint to, LocalTime departure, boolean peak, double baseFareHint) {
        this.routeId = routeId;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.peak = peak;
        this.baseFareHint = baseFareHint;
    }
}

final class Passenger {
    final String id;
    final String name;
    Passenger(String id, String name) { this.id = id; this.name = name; }
}

final class Trip {
    final Passenger passenger;
    final TransportService service;
    final ScheduleEntry entry;
    final double distanceKm;
    double fare;
    final LocalDateTime time;
    final boolean isPeak;

    Trip(Passenger passenger, TransportService service, ScheduleEntry entry, double distanceKm, double fare,
         LocalDateTime time, boolean isPeak) {
        this.passenger = passenger;
        this.service = service;
        this.entry = entry;
        this.distanceKm = distanceKm;
        this.fare = fare;
        this.time = time;
        this.isPeak = isPeak;
    }
}

/** --------- Interfaces (Java 8 features) --------- */

@FunctionalInterface
interface FareCalculator {
    double calculateFare(Trip trip);
}

interface TransportService {
    String getId();
    String getName();
    String getType();
    List<ScheduleEntry> getSchedule();
    FareCalculator getFareCalculator();

    default void printServiceDetails() {
        Logger.log(String.format("[%s] %s (%s)", getId(), getName(), getType()));
    }

    default void displayLiveSchedules() {
        printServiceDetails();
        getSchedule().forEach(se -> Logger.log(String.format("  %s | dep %s | peak=%s",
                se.routeId, se.departure, se.peak)));
    }

    default double estimateFare(Trip t) {
        return getFareCalculator().calculateFare(t);
    }
}

interface EmergencyService {} // Marker

/** --------- Implementations --------- */

abstract class BaseService implements TransportService {
    private final String id;
    private final String name;
    private final String type;
    private final List<ScheduleEntry> schedule;
    private final FareCalculator fareCalculator;

    protected BaseService(String id, String name, String type, List<ScheduleEntry> schedule, FareCalculator fareCalculator) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.schedule = Collections.unmodifiableList(new ArrayList<>(schedule));
        this.fareCalculator = fareCalculator;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public List<ScheduleEntry> getSchedule() { return schedule; }
    public FareCalculator getFareCalculator() { return fareCalculator; }
}

final class BusService extends BaseService {
    BusService(String id, String name, List<ScheduleEntry> schedule, FareCalculator fareCalculator) {
        super(id, name, "Bus", schedule, fareCalculator);
    }
}

final class MetroService extends BaseService {
    MetroService(String id, String name, List<ScheduleEntry> schedule, FareCalculator fareCalculator) {
        super(id, name, "Metro", schedule, fareCalculator);
    }
}

final class TaxiService extends BaseService {
    TaxiService(String id, String name, List<ScheduleEntry> schedule, FareCalculator fareCalculator) {
        super(id, name, "Taxi", schedule, fareCalculator);
    }
}

final class FerryService extends BaseService {
    FerryService(String id, String name, List<ScheduleEntry> schedule, FareCalculator fareCalculator) {
        super(id, name, "Ferry", schedule, fareCalculator);
    }
}

final class AmbulanceService extends BaseService implements EmergencyService {
    AmbulanceService(String id, String name, List<ScheduleEntry> schedule, FareCalculator fareCalculator) {
        super(id, name, "Ambulance", schedule, fareCalculator);
    }
}

/** --------- Utility --------- */

final class ServiceOption {
    final TransportService service;
    final ScheduleEntry entry;
    final double estimatedFare;
    final double distanceKm;

    ServiceOption(TransportService service, ScheduleEntry entry, double estimatedFare, double distanceKm) {
        this.service = service;
        this.entry = entry;
        this.estimatedFare = estimatedFare;
        this.distanceKm = distanceKm;
    }
}

final class Logger {
    static void log(String s) { System.out.println(s); } // Method reference target
}

