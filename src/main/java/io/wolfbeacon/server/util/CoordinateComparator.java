package io.wolfbeacon.server.util;

import io.wolfbeacon.server.model.Hackathon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 12/11/16
 */

public class CoordinateComparator implements Comparator<Hackathon> {

    private double lat1, lon1;
    private Map<Long, Double> memoDistances;

    public CoordinateComparator(double lat1, double lon1) {
        this.lat1 = lat1;
        this.lon1 = lon1;
        memoDistances = new HashMap<>();
    }

    @Override
    public int compare(Hackathon h1, Hackathon h2) {
        if (!memoDistances.containsKey(h1.getId())) {
            memoDistances.put(h1.getId(), distance(h1.getLatitude(), h1.getLongitude()));
        }
        if (!memoDistances.containsKey(h2.getId())) {
            memoDistances.put(h2.getId(), distance(h2.getLatitude(), h2.getLongitude()));
        }
        return Double.compare(memoDistances.get(h1.getId()), memoDistances.get(h2.getId()));
    }

    //http://www.geodatasource.com/
    private double distance(double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}