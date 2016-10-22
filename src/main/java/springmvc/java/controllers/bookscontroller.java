package springmvc.java.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springmvc.java.bookservices.bookservice;
import springmvc.java.domain.Books;

import java.util.List;

/**
 * Created by oleg on 16.10.2016.
 */
@Controller
public class bookscontroller {

    @Autowired
    private bookservice bookservice;

    @RequestMapping (value = "/saveBook", method = RequestMethod.POST)
    public ModelAndView saveBook (
            @RequestParam (value = "BOOK_TITLE") String BOOK_TITLE,
            @RequestParam (value = "AUTOR") String BOOK_AUTOR,
            @RequestParam (value = "izdatel") String BOOK_IZDATEL,
            @RequestParam (value = "BOOK_SHELF") Integer BOOK_SHELF,
            @RequestParam (value = "BOOK_ROOM") Integer BOOK_ROOM
    ) {
        Books book = new Books();
        book.setBOOK_TITLE(BOOK_TITLE);
        book.setautor(BOOK_AUTOR);
        book.setIzdatel(BOOK_IZDATEL);
        book.setBOOK_SHELF(BOOK_SHELF);
        book.setBOOK_ROOM(BOOK_ROOM);
        book.setBOOK_STATUS(1);

        System.out.println(bookservice);

        bookservice.saveBook(book);
        return new ModelAndView("newBook","message","Done!");
    }


    @RequestMapping (value = "/showAll", method = RequestMethod.GET)
    public ModelAndView showAll () {

        List<Books> allBooks = bookservice.ListAllBooks();
        ModelAndView mv = new ModelAndView("allBooks","listOfAllBooks",allBooks);
        mv.addObject("counts", allBooks.size());
        return mv;
    }

    @RequestMapping (value = "/allBooksByAutor", method = RequestMethod.POST)
    public ModelAndView allBooksByAutor (
            @RequestParam (value = "AUTOR", required = false, defaultValue = "") String BOOK_AUTOR,
            @RequestParam (value = "IZDATEL", required = false, defaultValue = "") String BOOK_IZDATEL
    ) {
        List<Books> allBooksByAutor=null;
        ModelAndView Mv = null;
        if (BOOK_IZDATEL.equals("") && !BOOK_AUTOR.equals("")) {
            allBooksByAutor = bookservice.ListAllBooksByAUTOR(BOOK_AUTOR);
            Mv = new ModelAndView("bookBy", "listofbooks", allBooksByAutor);
            Mv.addObject("counts", allBooksByAutor.size());
        }
        else if (!BOOK_IZDATEL.equals("") && BOOK_AUTOR.equals("")) {
            allBooksByAutor = bookservice.ListAllBooksByIZDATEL(BOOK_IZDATEL);
            Mv = new ModelAndView("bookBy", "listofbooks", allBooksByAutor);
            Mv.addObject("counts", allBooksByAutor.size());
        }
        else if (BOOK_IZDATEL.equals("") && BOOK_AUTOR.equals("")) {
            Mv = new ModelAndView("bookBy","counts",0);
        }
        else if (!BOOK_IZDATEL.equals("") && !BOOK_AUTOR.equals("")) {
            allBooksByAutor = bookservice.listAllBooks1(BOOK_AUTOR,BOOK_IZDATEL);
            Mv = new ModelAndView("bookBy", "listofbooks", allBooksByAutor);
            Mv.addObject("counts", allBooksByAutor.size());
        }
        else {
            Mv = new ModelAndView("bookBy", "listofbooks", allBooksByAutor);

            Mv.addObject("counts", allBooksByAutor.size());
        }
        return  Mv;
    }
}
