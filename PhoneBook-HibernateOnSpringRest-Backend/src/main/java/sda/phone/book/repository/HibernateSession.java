package sda.phone.book.repository;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import sda.phone.book.model.Gender;
import sda.phone.book.model.Person;
import sda.phone.book.model.Phone;
import java.util.Properties;

@Service
public class HibernateSession {
    private String URL ="jdbc:mysql://localhost:3306/hibernate";
    private String USER = "root";
    private String PASSWORD = "admin";
    private SessionFactory sessionFactory;

    private Properties getSettings() {
        Properties settings = new Properties();
        settings.put(Environment.URL, URL);
        settings.put(Environment.USER, USER);
        settings.put(Environment.PASS, PASSWORD);
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        //settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        return settings;
    }
    private SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        configuration.setProperties(getSettings());

        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Phone.class);
        configuration.addAnnotatedClass(Gender.class);


        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    public Session getSession(){
        return getSessionFactory().openSession();
    }

}
