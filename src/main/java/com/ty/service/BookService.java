package com.ty.service;

import com.ty.dto.Book;
import java.util.List;

public interface BookService {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(int id);
    void deleteBook(int id);
    Book updateBook(int id, Book updatedBook);

}
