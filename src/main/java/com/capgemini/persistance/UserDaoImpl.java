package com.capgemini.persistance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.User;

@Repository("UserDaoImpl")
@Transactional
public class UserDaoImpl implements UserDao {
	
	private EntityManager em;
	
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void add(User user) {
		em.persist(user);
	}

	@Override
	public User findUser(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> getUsers() {
		String query = "from users";
		return em.createQuery(query).getResultList();
	}

}
