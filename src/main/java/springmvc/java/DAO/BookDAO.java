package springmvc.java.DAO;




import org.springframework.data.repository.CrudRepository;


import springmvc.java.domain.Books;

import java.util.List;


/**
 * Created by oleg on 16.10.2016.
 */
public interface BookDAO extends CrudRepository <Books,Long> {

List<Books> findByAutorContaining (String Autor);
List<Books> findByIzdatelContaining (String Izdatel);
List<Books> findAllBooksByAutorAndIzdatelContaining (String Autor, String Izdatel);

}
