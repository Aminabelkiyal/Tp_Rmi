/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermachine;

import dao.IDao;
import entities.Machine;
import entities.Salle;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import service.MachineService;
import service.SalleService;

import util.HibernateUtil;

/**
 *
 * @author Lachgar
 */
public class ServerMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        try {
            
            // Create an RMI service for Machine entities

            IDao<Machine> dao = new  MachineService();
            
            LocateRegistry.createRegistry(1099);
            
            Naming.bind("rmi://localhost:1099/dao", dao);
            
        
            // Create a new RMI service for Salle entities
            IDao<Salle> salleDao = new SalleService();
            Naming.bind("rmi://localhost:1099/daosalle", salleDao);
            
            
            
            System.out.println("En attente d'un client ");
            
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServerMachine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
