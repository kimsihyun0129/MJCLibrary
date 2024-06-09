package ksh.mjc.mjclibrary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Reservation_status_adapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater layoutInflater = null;
    ArrayList<Reservation_status> rv_status;

    public Reservation_status_adapter(Context context, ArrayList<Reservation_status> data) {
        mContext = context;
        rv_status = data;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return rv_status.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Reservation_status getItem(int position) {
        return rv_status.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.reservation_status_item, null);


        TextView rv_room = (TextView)view.findViewById(R.id.reservation_room);
        TextView rv_date = (TextView)view.findViewById(R.id.reservation_date);
        TextView rv_time = (TextView)view.findViewById(R.id.reservation_time);
        TextView rv_type = (TextView)view.findViewById(R.id.reservation_type);


        rv_room.setText("스터디룸:"+rv_status.get(position).getReservation_room());
        rv_date.setText("예약 날짜:"+rv_status.get(position).getReservation_date());
        rv_time.setText("예약 시간:"+rv_status.get(position).getReservation_starttime()+"~" + rv_status.get(position).getReservation_endtime());
        rv_type.setText("사용 목적:"+rv_status.get(position).getReservation_type());
        Log.d("test", rv_status.get(position).getReservation_room());
        return view;
    }
}
