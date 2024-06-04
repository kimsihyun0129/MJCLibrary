package ksh.mjc.mjclibrary;

public class booklistitem {

    String bookname;
    String bookimg;
    String bookauthor;
    String bookpublisher;
    String librarycode;


    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookpublisher() {
        return bookpublisher;
    }

    public void setBookpublisher(String bookpublisher) {
        this.bookpublisher = bookpublisher;
    }

    public String getLibrarycode() {
        return librarycode;
    }

    public void setLibrarycode(String librarycode) {
        this.librarycode = librarycode;
    }

public booklistitem(String bookname, String bookimg, String bookauthor, String bookpublisher, String librarycode){
        this.bookname = bookname;
        this.bookimg = bookimg;
        this.bookauthor = bookauthor;
        this.bookpublisher = bookpublisher;
        this.librarycode = librarycode;
}


}
