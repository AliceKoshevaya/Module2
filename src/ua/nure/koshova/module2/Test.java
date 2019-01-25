package ua.nure.koshova.module2;

import java.util.*;

/**
 * Testing results
 */
public class Test {
    public static void main(String[] args){
        Railway kharkiv = new Railway("Харьков", RailType.SOUTHERN);
        Railway novoselovka = new Railway("Новоселовка", RailType.SOUTHERN);
        Railway liman = new Railway("Лиман", RailType.DONETSK);
        Railway lozova = new Railway("Лозовая", RailType.SOUTHERN);
        Railway merefa = new Railway("Мерефа", RailType.SOUTHERN);
        Railway bogodyxov = new Railway("Богодухов", RailType.SOUTHERN);
        Railway lubotin = new Railway("Люботин", RailType.SOUTHERN);
        Railway poltava = new Railway("Полтава", RailType.SOUTHERN);
        Railway krasnograd = new Railway("Красноград", RailType.SOUTHERN);
        Railway zachepilovka = new Railway("Зачепиловка", RailType.PRIDNEPROVSKAYA);
        Sector<Railway> s1 = new Sector<Railway>(2,5, kharkiv, novoselovka);
        Sector<Railway> s2 = new Sector<Railway>(53, 60, bogodyxov, lubotin);
        Sector<Railway> s3 = new Sector<Railway>(22, 30, lubotin, novoselovka);
        Sector<Railway> s4 = new Sector<Railway>(116, 120, poltava, lubotin);
        Sector<Railway> s5 = new Sector<Railway>(81, 80, poltava, krasnograd);
        Sector<Railway> s6 = new Sector<Railway>(18, 30, lubotin, merefa);
        Sector<Railway> s7 = new Sector<Railway>(23, 30, novoselovka, merefa);
        Sector<Railway> s8 = new Sector<Railway>(76, 120, merefa, krasnograd);
        Sector<Railway> s9 = new Sector<Railway>(28, 40, zachepilovka, krasnograd);
        Sector<Railway> s10 = new Sector<Railway>(95, 80, krasnograd, lozova);
        Sector<Railway> s11 = new Sector<Railway>(123, 120, merefa, lozova);
        Sector<Railway> s12 = new Sector<Railway>(183, 180, novoselovka, liman);
        Sector<Railway> s13 = new Sector<Railway>(132, 150, lozova, liman);
        List<Sector<Railway>> sectors = new ArrayList<>();
        sectors.add(s1);
        sectors.add(s2);
        sectors.add(s3);
        sectors.add(s4);
        sectors.add(s5);
        sectors.add(s6);
        sectors.add(s7);
        sectors.add(s8);
        sectors.add(s9);
        sectors.add(s10);
        sectors.add(s11);
        sectors.add(s12);
        sectors.add(s13);
        TransportationSystem<Railway> transportationSystem = new TransportationSystem<>(sectors);
        transportationSystem.sectorSorted();
        System.out.println(transportationSystem.fastestSection());
//        Set<Railway> set = transportationSystem.neighbors(merefa);
//        Iterator<Railway> iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }



    }
}
