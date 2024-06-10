package ksh.mjc.mjclibrary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ksh.mjc.mjclibrary.DTO.Bookdata;
import ksh.mjc.mjclibrary.R;

public class BooklistAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Bookdata> bdata;

    public BooklistAdapter(Context context, ArrayList<Bookdata> data) {
        mContext = context;
        bdata = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return bdata.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Bookdata getItem(int position) {
        return bdata.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.search_book_item, null);

        ImageView bimg = (ImageView)view.findViewById(R.id.bookimg);
        TextView bname  = (TextView)view.findViewById(R.id.bookname);
        TextView bauthor = (TextView)view.findViewById(R.id.bookmaker);
        TextView bpublisher = (TextView)view.findViewById(R.id.bookoffice);
        TextView bcode = (TextView)view.findViewById(R.id.librarycode);

        bimg.setImageResource(bdata.get(position).getBook_img());
        bname.setText(bdata.get(position).getBook_name());
        bauthor.setText(bdata.get(position).getBook_author());
        bpublisher.setText(bdata.get(position).getBook_publisher());
        bcode.setText(bdata.get(position).getBook_code());

        return view;
    }
}
