package dao;

import model.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserDAO extends objectDAO {

    public void createUser(@NotNull User user) {
        if (!user.equals(null)) {
            em.persist(user);
        }
    }

    public void update(User user) {
        if(!user.equals(null)){
            em.merge(user);
        }
    }

    public void delete(User user){
        em.remove(user);
    }

    public List<User> getAllUsers() {
        List<User> users = em.createQuery("SELECT U FROM User u").getResultList();
        return users;
    }

    public  List<User> getAllUsersByHelado(int id){
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u = "+id).getResultList();
        return users;
    }

    public User getUserByID(int id) {
        User user = em.find(User.class, id);

        return user;
    }
     public User getUsetByName(String name){
        User user = (User) em.createQuery("SELECT u FROM User u WHERE u.name='"+name+"'").getSingleResult();
        return user;
     }

}
