package ksh.mjc.mjclibrary;

public class booklistitem {

    String bookname;
    String bookimg;
    String bookmaker;
    String bookoffice;
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

    public String getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(String bookmaker) {
        this.bookmaker = bookmaker;
    }

    public String getBookoffice() {
        return bookoffice;
    }

    public void setBookoffice(String bookoffice) {
        this.bookoffice = bookoffice;
    }

    public String getLibrarycode() {
        return librarycode;
    }

    public void setLibrarycode(String librarycode) {
        this.librarycode = librarycode;
    }

public booklistitem(String bookname, String bookimg, String bookmaker, String bookoffice, String librarycode){
        this.bookname = bookname;
        this.bookimg = bookimg;
        this.bookmaker = bookmaker;
        this.bookoffice = bookoffice;
        this.librarycode = librarycode;
}


}
