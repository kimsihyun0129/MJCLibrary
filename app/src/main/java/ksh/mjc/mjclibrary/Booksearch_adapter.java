package ksh.mjc.mjclibrary;

<<<<<<< HEAD
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

public class Booksearch_adapter extends BaseAdapter  {
=======
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Booksearch_adapter extends BaseAdapter {

private  Context context;
private List<booklistitem> booklist;

public  Booksearch_adapter(Context context, List<booklistitem> booklist){
    this.context=context;
    this.booklist=booklist;
}

@Override
    public int getCount(){
    return booklist.size();
}

    @Override
    public Object getItem(int i){
        return booklist.get(i);
    }

    @Override
    public long getItemId(int i){
    return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
    View v = View.inflate(context,R.layout.search_book_item,null);

    TextView bookname = v.findViewById(R.id.bookname);
    ImageView bookimg = v.findViewById(R.id.bookimg);
    TextView bookmaker = v.findViewById(R.id.bookmaker);
    TextView bookoffice = v.findViewById(R.id.bookoffice);
    TextView librarycode = v.findViewById(R.id.librarycode);

    bookname.setText(booklist.get(i).getBookname());
    bookmaker.setText(booklist.get(i).getBookmaker());
    bookoffice.setText(booklist.get(i).getBookoffice());
    librarycode.setText(booklist.get(i).getLibrarycode());

    return v;
    }


>>>>>>> origin/master

}
