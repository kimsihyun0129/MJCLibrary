package ksh.mjc.mjclibrary;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Booksearch_adapter extends RecyclerView.Adapter<Booksearch_adapter.ViewHolder> {
    private Context context;
    ArrayList<booklistitem> books  = new ArrayList<>();

    public Booksearch_adapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
        View itemView = inflater.inflate(R.layout.search_book_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        booklistitem item = books.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return books.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Bookname;
        ImageView BookImg;
        TextView Author;
        TextView Publisher;
        TextView BookCode;




        public ViewHolder(@NonNull View itemView){
            super(itemView);

            Bookname = itemView.findViewById(R.id.bookname);
            BookImg =  itemView.findViewById(R.id.bookimg);
            Author = itemView.findViewById(R.id.bookmaker);
            Publisher = itemView.findViewById(R.id.bookoffice);
            BookCode = itemView.findViewById(R.id.librarycode);

        }

        public void setItem(booklistitem item){

        }
    }
}