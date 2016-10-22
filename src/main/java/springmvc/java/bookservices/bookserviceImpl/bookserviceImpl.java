package springmvc.java.bookservices.bookserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import springmvc.java.DAO.BookDAO;
import springmvc.java.bookservices.bookservice;
import springmvc.java.domain.Books;
import java.util.List;

/**
 * Created by oleg on 16.10.2016.
 */
public class bookserviceImpl implements bookservice {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Books> findAllBoks() {
        return (List<Books>) bookDAO.findAll();
    }

    public void saveBook (Books book) {
        bookDAO.save(book);
    }

    @Override
    public List<Books> ListAllBooksByAUTOR(String AUTOR) {

        return (List <Books>) bookDAO.findByAutorContaining(AUTOR);
    }

    @Override
    public List<Books> ListAllBooksByIZDATEL(String IZDATEL) {

        return (List<Books>) bookDAO.findByIzdatelContaining(IZDATEL);
    }

    @Override
    public List<Books> ListAllBooks() {
        return (List<Books>) bookDAO.findAll();
    }

    @Override
    public List<Books> listAllBooks1(String name, String izdatel) {
        return bookDAO.listAllBooks1(name,izdatel);
    }


    public List<Books> findAllBooks(String name, String izdatel) {
        return bookDAO.listAllBooks1(name, izdatel);
    }

    @Override
    public Books findBookById(Long id) {
        return null;
    }

    @Override
    public List<Books> findByAutorAndIzdatelContaining(String Autor, String Izdatel) {
        return bookDAO.findAllBooksByAutorAndIzdatelContaining(Autor,Izdatel);
    }


}
