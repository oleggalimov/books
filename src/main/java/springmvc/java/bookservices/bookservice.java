package springmvc.java.bookservices;


import springmvc.java.domain.Books;

import java.util.List;

/**
 * Created by oleg on 16.10.2016.
 */
public interface bookservice  {
    List<Books> findAllBoks ();
    void saveBook (Books book);
    List <Books> ListAllBooksByAUTOR (String BOOK_AUTOR);
    List <Books> ListAllBooksByIZDATEL (String BOOK_IZDATEL);
    List <Books> ListAllBooks ();
    Books findBookById (Long id);
    List <Books> findByAutorAndIzdatelContaining (String Autor, String Izdatel);



}
