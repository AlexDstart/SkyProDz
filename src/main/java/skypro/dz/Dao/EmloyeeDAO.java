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
public class EmployeeDAO implements EmployeeDAOInterface<Employee, Long> {
    private Session currentSession;
    private Transaction currentTransaction;
    public EmployeeDAO() {
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

            configuration.addAnnotatedClass(City.class)
                    .addAnnotatedClass(Employee.class);
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
    public void addNewEmployee(Employee entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void updateById(Employee entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Employee findById(Long id) {
        return getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void deleteById(Employee entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> findAll() {
        return (List<Employee>) getCurrentSession().createQuery("from Employee order by id").list();
    }
}
