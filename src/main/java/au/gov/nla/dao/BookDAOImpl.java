package au.gov.nla.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.gov.nla.model.Book;

@Repository
public class BookDAOImpl implements BookDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Book> getBookListByPerson(int personId)
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> books = (List<Book>) session
				.createQuery(
						"from Book as b where b.person.personId = :personId")
				.setParameter("personId", personId).list();

		if (books.size() > 0)
		{
			return books;
		}
		return null;
	}

	@Override
	public List<Book> getBookList()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> books = (List<Book>) session.createQuery("from Book").list();

		return books;
	}

}
