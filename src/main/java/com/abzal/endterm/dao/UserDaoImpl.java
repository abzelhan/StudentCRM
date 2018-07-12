package com.abzal.endterm.dao;


import com.abzal.endterm.model.EducationHistory;
import com.abzal.endterm.model.Student;
import com.abzal.endterm.model.User;
import com.abzal.endterm.service.EducationHistoryService;
import com.abzal.endterm.service.StudentService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Autowired
	StudentService studentService;

	@Autowired
	EducationHistoryService educationHistoryService;

	public User findById(int id) {
		User user = getByKey(id);
		return user;
	}

	public User findByUsername(String username) {

		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		User user = (User)crit.uniqueResult();

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("username"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<User> users = (List<User>) criteria.list();

		return users;
	}

	public void save(User user) {
		persist(user);
	}

	public void deleteByUsername(String username) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		User user = (User)crit.uniqueResult();
		delete(user);
	}

	@Override
	public void deleteById(int id) {
		User user = findById(id);
		Student student = studentService.findStudentByUserId(id);
		ArrayList<EducationHistory> histories = educationHistoryService.getAll(student);
		for (EducationHistory education :
				histories) {
		educationHistoryService.delete(education);
		}
		studentService.delete(student);
		delete(user);
	}

}
