package com.app.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.daoi.HomeDao;
import com.app.model.Student;

@Repository
public class HomeDaoImpl implements HomeDao {

	@Autowired
	private SessionFactory sf;

	public void saveData(Student s) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();

	}

	public int loginCheck(String uname, String password) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "from Student where uname='"+uname+"' and upass='"+password+"'";
		Query<Student> query = session.createQuery(hql);
		
		Student s = query.getSingleResult();
		tx.commit();
		session.close();
		return 1;
	}

	public List displayAllData() {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Student";
		Query<Student> query = session.createQuery(hql);
		List list = query.getResultList();
		tx.commit();
		session.close();
		return list;
	}

	public Student editData(Student s) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Student stu = session.get(Student.class, s.getUid());
		tx.commit();
		session.close();
		return stu;
	}

	public void updateData(Student s) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, s.getUid());
		student.setName(s.getName());
		student.setUname(s.getUname());
		student.setUpass(s.getUpass());
		student.setMobileno(s.getMobileno());
		session.update(student);
		tx.commit();
		session.close();
	}

	public int deleteData(int uid) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Student where uid = '" + uid + "'";
		Query<Student> query = session.createQuery(hql);
		int i = query.executeUpdate();
		tx.commit();
		session.close();
		return i;
	}
}