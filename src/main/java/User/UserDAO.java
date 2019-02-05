package User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class UserDAO {

    private static UserDAO instance;
    private static final String USER_UNIT = "unit-1";
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(USER_UNIT);

    private UserDAO() {

    }

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }

    protected void saveNewUser(User user) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();


        user.setAddedDate(Calendar.getInstance().getTime());
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    protected boolean checkIfUserExist(String mail) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String jpql = "SELECT u FROM User u WHERE u.mail = :mail";
        User user = em.createQuery(jpql, User.class).setParameter("mail", mail).getSingleResult();
        if (user == null){
            return false;
        }else {
            return true;
        }
    }
}
