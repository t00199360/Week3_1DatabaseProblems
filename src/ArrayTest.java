/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author mkonda
 */
public class ArrayTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure();
        factory = config.buildSessionFactory();
    }

    private void persistArrays() {
        Session session = factory.getCurrentSession();
        
        session.beginTransaction();
        Showroom showroom = new Showroom();
        showroom.setLocation("East Croydon, Greater London");
        showroom.setManager("Barry Larry");
        String[] cars = new String[]{"Toyota","BMW","Citroen"};

        Showroom showroom1 = new Showroom();
        showroom1.setLocation("West Croydon, Lesser London");
        showroom1.setManager("Larry Barry");
        String[] cars1 = new String[]{"Toyoda","CNX","Peugeot"};
        
        showroom.setCars(cars);
        showroom1.setCars(cars1);
        
        session.save(showroom);
        session.save(showroom1);
        
        session.getTransaction().commit();
        System.out.println("Done");
    }

 
    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        test.init();
        test.persistArrays();
       
    }
}
