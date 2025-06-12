package Day2;
public class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double pi = Math.PI;
        double volumeKm = (4.0 / 3) * pi * Math.pow(radiusKm, 3);

        double kmToMile = 0.621371;
        double radiusMiles = radiusKm * kmToMile;
        double volumeMiles = (4.0 / 3) * pi * Math.pow(radiusMiles, 3);

        System.out.println("The volume of Earth in cubic kilometers is " + volumeKm + " and in cubic miles is " + volumeMiles);
    }
}

