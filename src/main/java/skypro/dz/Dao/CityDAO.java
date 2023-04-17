package skypro.dz.Dao;

import model.City;
import model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CityDAO implements CityDAOInterface<City, Long> {

    private Session currentSession;

    private Transaction currentTransaction;

    public CityDAO() {
    }

    public void openCurrentSession() {
        currentSession = getSessionFactory().openSession();
    }

    public void openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(City.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (HibernateException h) {
            System.out.println("Ошибка при инициализации сессии Hibernate!");
            h.printStackTrace();
        }
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void addNewEmployee(City entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void updateById(City entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public City findById(Long id) {
        return getCurrentSession().get(City.class, id);
    }

    @Override
    public void deleteById(City entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<City> findAll() {
        return getCurrentSession().createQuery("from City  order by cityId").list();
    }
}
