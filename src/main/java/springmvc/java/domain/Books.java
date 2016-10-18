package springmvc.java.domain;

import javax.persistence.*;

/**
 * Created by oleg on 16.10.2016.
 */
@Entity
@Table (name = "book")

public class Books {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id", unique = true, nullable = false)
    private Long id;

    @Column (name = "BOOK_TITLE")
    private String BOOK_TITLE;

    @Column (name = "BOOK_AUTOR")
    private String autor;

    @Column (name = "izdatel")
    private String izdatel;

    @Column (name = "BOOK_STATUS")
    private Integer BOOK_STATUS;

    @Column (name = "BOOK_SHELF")
    private Integer BOOK_SHELF;

    @Column (name = "BOOK_ROOM")
    private Integer BOOK_ROOM;

    public Books() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBOOK_TITLE() {
        return BOOK_TITLE;
    }

    public void setBOOK_TITLE(String BOOK_TITLE) {
        this.BOOK_TITLE = BOOK_TITLE;
    }

    public String getautor() {
        return autor;
    }

    public void setautor(String BOOK_AUTOR) {
        this.autor = BOOK_AUTOR;
    }

    public String getIzdatel() {
        return izdatel;
    }

    public void setIzdatel(String izdatel) {
        this.izdatel = izdatel;
    }

    public Integer getBOOK_STATUS() {
        return BOOK_STATUS;
    }

    public void setBOOK_STATUS(Integer BOOK_STATUS) {
        this.BOOK_STATUS = BOOK_STATUS;
    }

    public Integer getBOOK_SHELF() {
        return BOOK_SHELF;
    }

    public void setBOOK_SHELF(Integer BOOK_SHELF) {
        this.BOOK_SHELF = BOOK_SHELF;
    }

    public Integer getBOOK_ROOM() {
        return BOOK_ROOM;
    }

    public void setBOOK_ROOM(Integer BOOK_ROOM) {
        this.BOOK_ROOM = BOOK_ROOM;
    }
}
