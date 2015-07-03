package au.gov.nla.service;

import java.util.List;

import au.gov.nla.model.Book;

public interface BookService
{
	public List<Book> getBookListByPerson(int personId);

	public List<Book> getBookList();
}
