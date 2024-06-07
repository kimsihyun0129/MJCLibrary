package ksh.mjc.mjclibrary;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
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
        ImageButton BookImg;
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
            Bookname.setText(item.getBookname());
            Author.setText(item.getBookauthor());
            Publisher.setText(item.getBookpublisher());
            BookCode.setText(item.getLibrarycode());

            // Decode base64 string to a Bitmap and set it to the ImageView
            String base64Image = item.getBookimg();  // Assuming `getBookImg()` returns a base64 string
            if (base64Image != null && !base64Image.isEmpty()) {
                byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                BookImg.setImageBitmap(decodedByte);
            }
        }


    }
    }
