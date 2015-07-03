package au.gov.nla.dao;

import java.util.List;

import au.gov.nla.model.Book;

public interface BookDAO
{
	public List<Book> getBookListByPerson(int personId);

	public List<Book> getBookList();
}
