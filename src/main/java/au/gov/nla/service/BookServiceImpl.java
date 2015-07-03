package au.gov.nla.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.gov.nla.dao.BookDAO;
import au.gov.nla.model.Book;

@Service
public class BookServiceImpl implements BookService
{
	private BookDAO bookDAO;

	public void setBookDAO(BookDAO bookDAO)
	{
		this.bookDAO = bookDAO;
	}

	@Override
	@Transactional
	public List<Book> getBookListByPerson(int personId)
	{
		return this.bookDAO.getBookListByPerson(personId);
	}

	@Override
	@Transactional
	public List<Book> getBookList()
	{
		return this.bookDAO.getBookList();
	}

}
