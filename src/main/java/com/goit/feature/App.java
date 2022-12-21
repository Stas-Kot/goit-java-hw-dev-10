package com.goit.feature;

import com.goit.feature.client.Client;
import com.goit.feature.client.ClientCrudService;
import com.goit.feature.database.Database;
import com.goit.feature.database.DatabaseInitService;
import com.goit.feature.database.hibernate.HibernateUtil;
import com.goit.feature.planet.Planet;
import com.goit.feature.planet.PlanetCrudService;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        new DatabaseInitService().initDb();
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
//
        ClientCrudService clientCrudService = new ClientCrudService(session);
        PlanetCrudService planetCrudService = new PlanetCrudService(session);

//        long valera = clientCrudService.create("Valera");
//        System.out.println("valera = " + valera);
//        Client client = clientCrudService.updateById(11, "Valeria");
//        System.out.println("client = " + client);

//        Client client11 = clientCrudService.getById(11L);
//        System.out.println("client11 = " + client11);
//        List<Client> clientsBefore = clientCrudService.getAll();
//        System.out.println("clientsBefore = " + clientsBefore);
//
//        clientCrudService.deleteById(11);
//
//        List<Client> clientsAfter = clientCrudService.getAll();
//        System.out.println("clientsAfter = " + clientsAfter);

//        planetCrudService.create("NEP5", "Neptun");

//        Planet planet = planetCrudService.updateById("NEP5", "Neptun-5");

//        planetCrudService.deleteById("NEP5");

        Planet jupi = planetCrudService.getById("JUPI");
        System.out.println("jupi = " + jupi);

        List<Planet> planets = planetCrudService.getAll();
        System.out.println("planets = " + planets);

        session.close();
    }
}
