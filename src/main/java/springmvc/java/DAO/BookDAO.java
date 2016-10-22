package springmvc.java.DAO;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import org.springframework.data.repository.query.Param;
import springmvc.java.domain.Books;

import java.util.List;


/**
 * Created by oleg on 16.10.2016.
 */
public interface BookDAO extends CrudRepository <Books,Long> {

    @Query(value = "select b from Books b where b.autor like concat('%', :autor, '%') or b.izdatel like concat('%', :izdatel, '%') ")
    List<Books> listAllBooks1(@Param("autor") String name, @Param("izdatel") String izdatel);


List<Books> findByAutorContaining (String Autor);
List<Books> findByIzdatelContaining (String Izdatel);
List<Books> findAllBooksByAutorAndIzdatelContaining (String Autor, String Izdatel);

}
