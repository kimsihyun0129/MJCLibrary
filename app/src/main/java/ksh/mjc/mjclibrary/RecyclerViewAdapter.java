package ksh.mjc.mjclibrary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> { //리사이클러뷰 어댑터를 상속받은 클래스
    private Context context;
    ArrayList<StudyRoom> alStudyRoom;

    public RecyclerViewAdapter(Context context, ArrayList<StudyRoom> alStudyRoom) {
        this.context = context;
        this.alStudyRoom = alStudyRoom;
    }

    @NonNull
    @Override
    //뷰홀더가 처음 생성될 때 호출되는 메서드
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //스터디룸 아이템을 뷰 객체로 인플레이팅
        View view = LayoutInflater.from(context).inflate(R.layout.study_room_item, parent, false);
        //인플레이팅 한 뷰홀더를 생성자에 전달
        return new ViewHolder(view);
    }

    @Override
    //뷰홀더가 데이터와 결합될 때 호출되는 메서드
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //현재 위치에 해당하는 스터디룸 객체를 가져옴
        StudyRoom studyRoom = alStudyRoom.get(position);
        //데이터와 뷰를 결합
        holder.bind(studyRoom);
    }

    @Override
    public int getItemCount() {
        //전체 스터디룸 수 반환
        return alStudyRoom.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudyRoomName;//스터디룸 이름을 표시할 텍스트뷰
        int[] timelineNames = {R.id.v9,R.id.v10,R.id.v11,R.id.tv12,R.id.tv13,R.id.tv14,R.id.tv15,R.id.tv16,R.id.tv17,R.id.tv18,R.id.v19,R.id.tv20,R.id.v21};//시간 막대의 ID를 저장한 배열
        View[] timelines = new View[timelineNames.length];//시간 막대 배열
        //생성자
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //스터디룸 이름 텍스트뷰 인플레이팅
            tvStudyRoomName = itemView.findViewById(R.id.tvStudyRoomName);
            //시간 막대 뷰들 인플레이팅
            for(int i=0;i<timelineNames.length;i++){
                timelines[i] = itemView.findViewById(timelineNames[i]);
            }

            //스터디룸 목록 아이템을 클릭하면
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //인텐트를 사용하여 스터디룸 예약 상세 화면으로 이동(스터디룸 이름과 날짜를 함께 넘김)
                    Intent intent = new Intent(itemView.getContext(), StudyRoomReservationDetailsActivity.class);
                    intent.putExtra("studyRoomName",tvStudyRoomName.getText().toString());
                    intent.putExtra("selectDate",StudyRoomReservationActivity.tvSelectDate.getText().toString());
                    context.startActivity(intent);
                }
            });
        }

        public void bind(StudyRoom studyRoom) {
            //스터디룸 이름 텍스트 뷰를 각각의 스터디룸 이름에 맞게 바꿔줌
            tvStudyRoomName.setText(studyRoom.studyRoomName);
        }
    }
}
