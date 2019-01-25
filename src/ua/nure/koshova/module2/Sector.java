package ua.nure.koshova.module2;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Generic class to represent a portion of the transport network
 *
 * @param <T>
 */
public class Sector<T> {

    private int distance;
    private int time;
    private T start;
    private T end;

    Sector(int distance, int time, T start, T end) {
        this.distance = distance;
        this.time = time;
        if (start.equals(end)) {
            try {
                throw new MySectorException("Error!At the ends of the route should not be the same objects.");
            } catch (MySectorException e) {
                e.printStackTrace();
            }
        }
        this.start = start;
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = end;
    }

    /**
     * The function of calculating the estimated speed.
     *
     * @param distance
     * @param time
     * @return estimated speed
     */
    public double estimatedSpeed(int distance, int time) {
        distance = distance * 1000;
        time = time * 60;
        double speed = distance / time;
        return speed;
    }

    public String toString() {
        return "Route from " + start.toString() + " to " + end.toString();
    }

    /**
     * Exception class for checking nodes
     */
    public static class MySectorException extends RuntimeException {
        public MySectorException(String message) {
            super(message);
        }
    }


}
