/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author mkonda
 */
public class AnnotationEmployeeTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(Employee.class);
        factory = config.buildSessionFactory();
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee emp = new Employee("A Jones");
        
        session.save(emp);

        session.getTransaction().commit();
        System.out.println("Done");
    }

    
    public static void main(String[] args) {
        AnnotationEmployeeTest p = new AnnotationEmployeeTest();
        p.init();
        p.persist();
    }
}
