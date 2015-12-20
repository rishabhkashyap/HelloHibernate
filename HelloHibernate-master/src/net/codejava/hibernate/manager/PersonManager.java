package net.codejava.hibernate.manager;
 
import net.codejava.hibernate.model.Address;
import net.codejava.hibernate.model.Person;
import net.codejava.hibernate.util.HibernateUtil;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
public class PersonManager {
 
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        Person steve = new Person("Steve", "Jobs");
        Person donald = new Person("Donald", "Trump");
 
        Address valley = new Address("Steve P Jobs", "San Francisco", "11111");
        Address newyork = new Address("Trump Tower", "New York", "22222");
        Address chicago = new Address("Trump Tower", "Chicago", "33333");
 
        steve.getAddresses().add(valley);
        donald.getAddresses().add(newyork);
        donald.getAddresses().add(chicago);
 
        System.out.println("Creating Person: " + steve.getFirstName());
        session.persist(steve);
        System.out.println("Creating Person: " + donald.getFirstName());
        session.persist(donald);
 
        session.getTransaction().commit();
        session.close();
    }
 
}