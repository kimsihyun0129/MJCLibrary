package ksh.mjc.mjclibrary.DTO;

public class Bookdata {
    String book_name, book_author,book_publisher, book_code;
    int book_img;

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    public int getBook_img() {
        return book_img;
    }

    public void setBook_img(int book_img) {
        this.book_img = book_img;
    }

    public Bookdata(String bname, String bauthor, String bpublisher, String bcode, int bimg){
        this.book_name = bname;
        this.book_author = bauthor;
        this.book_publisher = bpublisher;
        this.book_code = bcode;
        this.book_img = bimg;
    }
}
