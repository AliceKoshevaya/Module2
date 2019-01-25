package ua.nure.koshova.module2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Generic class "Transport system" containing a list of sites (arcs)
 *
 * @param <T>
 */
public class TransportationSystem<T> {

    /**
     * List of arcs
     */
    private List<Sector<T>> sectors;

    /**
     * Constructor
     *
     * @param sectors
     */

    public TransportationSystem(List<Sector<T>> sectors) {
        this.sectors = sectors;
    }

    public List<Sector<T>> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector<T>> sectors) {
        this.sectors = sectors;
    }

    public String toString() {
        return "Sectors: " + sectors;
    }

    /**
     * A function that returns a list of nodes in the transport system.
     *
     * @return set transportation system nodes
     */
    public Set<T> listRailway() {
        Set<T> setNode = new HashSet<>();
        for (int i = 0; i < sectors.size(); i++) {
            setNode.add(sectors.get(i).getStart());
            setNode.add(sectors.get(i).getEnd());
        }
        return setNode;
    }

    /**
     * Function to get neighbors node
     *
     * @param railway
     * @return set of neighbors node
     */
    private Set<T> neighborsInner(T railway) {
        Set<T> railways = listRailway();
        Set<T> set = new HashSet<>();
        for (int i = 0; i < sectors.size(); i++) {
            T start = sectors.get(i).getStart();
            T end = sectors.get(i).getEnd();

            if (railway.equals(start)) {
                Iterator<T> iterator = railways.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next() == start) {
                        set.add(end);
                    }
                }
            } else if (railway.equals(end)) {
                Iterator<T> iterator = railways.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next() == end) {
                        set.add(start);
                    }
                }
            }
        }
        return set;
    }

    /**
     * Function to get the neighbors of a node through one
     *
     * @param railway
     * @return set of neighbors of node through one
     */
    public Set<T> neighbors(T railway) {
        Set<T> set = neighborsInner(railway);
        Set<T> add = new HashSet<>();
        Iterator<T> iterator = set.iterator();
        while (iterator.hasNext()) {
            T station = iterator.next();
            Set<T> neighborsOverOne = neighborsInner(station);
            add.addAll(neighborsOverOne);
        }
        set.addAll(add);
        set.remove(railway);
        return set;
    }

    /**
     * A function that returns a list of nodes sorted by increasing number
     *   related sites (incoming or outgoing)
     *
     * @return list of nodes
     */
    public List<T> sectorSorted() {
        return listRailway()
                .stream()
                .sorted(Comparator.comparingInt(a -> neighborsInner(a).size()))
                .collect(Collectors.toList());
    }

    /**
     * The function that returns the fastest sector.
     *
     * @return fastest sector
     */
    public Sector fastestSection() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < sectors.size(); i++) {
            list.add(sectors.get(i).estimatedSpeed(sectors.get(i).getDistance(), sectors.get(i).getTime()));
        }
        Collections.sort(list);
        return sectors.get(0);
    }
}
