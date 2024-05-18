package ksh.mjc.mjclibrary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Item> items;

    public RecyclerViewAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudyRoomName;
        int[] viewNames = {R.id.v9,R.id.v10,R.id.v11,R.id.tv12,R.id.tv13,R.id.tv14,R.id.tv15,R.id.tv16,R.id.tv17,R.id.tv18,R.id.v19,R.id.tv20,R.id.v21};
        View[] views = new View[viewNames.length];
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudyRoomName = itemView.findViewById(R.id.tvStudyRoomName);
            for(int i=0;i<viewNames.length;i++){
                views[i] = itemView.findViewById(viewNames[i]);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), StudyRoomReservationDetailsActivity.class);
                    intent.putExtra("studyRoomName",tvStudyRoomName.getText().toString());
                    context.startActivity(intent);
                }
            });
        }

        public void bind(Item item) {
            tvStudyRoomName.setText(item.getStudyRoomName());
        }
    }
}
