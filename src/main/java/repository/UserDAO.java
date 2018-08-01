package repository;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAO {

	public static User getUserByEmail(String email) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		User user = (User) session.createQuery("from User where email=?").setString(0, email).uniqueResult();
		session.getTransaction().commit();
		return user;
	}
}
public class UserRoleDAO {
	public static List<UserRole> getUserRolesByEmail(String email) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<UserRole> roles = session.createQuery("from UserRole where email=?").setString(0, email).list();
		session.getTransaction().commit();
		return roles;
	}

	public static void insert(UserRole r) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.persist(r);
		session.getTransaction().commit();
	}

}
