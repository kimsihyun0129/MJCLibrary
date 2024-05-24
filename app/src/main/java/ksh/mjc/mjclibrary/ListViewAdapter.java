package ksh.mjc.mjclibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<ListViewItem> {
    int itemLayout;//생성자에서 받은 레이아웃을 저장할 변수
    ArrayList<ListViewItem> alAddAccompayingUser, alRecentAccompayingUser;//추가 동반이용자 배열, 최근 동반이용자 배열
    ListViewAdapter addAccompanyingUserAdapter;//추가 동반이용자 리스트뷰에 달아준 어댑터를 저장할 변수

    //매개 변수가 3개인 생성자
    public ListViewAdapter(@NonNull Context context, int itemLayout, ArrayList<ListViewItem> alAddAccompayingUser) {
        super(context, itemLayout, alAddAccompayingUser);
        this.alAddAccompayingUser = alAddAccompayingUser;
        this.itemLayout = itemLayout;
    }

    //매개 변수가 5개인 생성자(생성자 오버로딩) - 최근 동반이용자 목록에서 추가 동반이용자 목록으로 옮기기 위해 오버로딩함.
    public ListViewAdapter(@NonNull Context context, int itemLayout, ArrayList<ListViewItem> alRecentAccompayingUser,ArrayList<ListViewItem> alAddAccompayingUser, ListViewAdapter addAccompanyingUserAdapter) {
        super(context, itemLayout, alRecentAccompayingUser);
        this.alAddAccompayingUser = alAddAccompayingUser;
        this.alRecentAccompayingUser = alRecentAccompayingUser;
        this.addAccompanyingUserAdapter = addAccompanyingUserAdapter;
        this.itemLayout = itemLayout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 현재 목록의 위치에 해당하는 ListViewItem 객체 가져오기
        ListViewItem listViewItem = getItem(position);

        // 성능 향상을 위해 재사용 가능한 뷰가 있는지 확인
        if (convertView == null) {
            // itemLayout 변수에 따라 적절한 레이아웃 삽입
            convertView = LayoutInflater.from(getContext()).inflate(itemLayout, parent, false);
        }

        //이름과 학번 텍스트뷰 인플레이팅
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvStudentNumber = convertView.findViewById(R.id.tvStudentNumber);

        //이름과 학번 텍스트 뷰를 객체의 이름과 학번으로 바꿈
        tvName.setText(listViewItem.getName());
        tvStudentNumber.setText(Integer.toString(listViewItem.getStudentNumber()));

        if(itemLayout == R.layout.added_accompaying_user_item) { //만약 레이아웃이 추가 동반이용자 리스트뷰에 사용된 레이아웃이라면
            //X버튼 인플레이팅
            ImageButton ibCancel = convertView.findViewById(R.id.ibCancel);
            //X버튼을 누르면
            ibCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //추가 동반이용자 목록에서 삭제
                    alAddAccompayingUser.remove(position);
                    //어댑터에 변경 사실을 알림
                    notifyDataSetChanged();
                }
            });
        } else if(itemLayout == R.layout.recent_accompanying_user_item) { //만약 레이아웃이 최근 동반이용자 리스트뷰에 사용된 레이아웃이라면
            //선택 버튼 인플레이팅
            Button btnSelect = convertView.findViewById(R.id.btnSelect);
            //선택 버튼을 누르면
            btnSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //추가 동반이용자 목록에 삽입
                    alAddAccompayingUser.add(new ListViewItem(tvName.getText().toString(),Integer.parseInt(tvStudentNumber.getText().toString())));
                    //추가 동반이용자 리스트뷰 어댑터에 변경 사실을 알림
                    addAccompanyingUserAdapter.notifyDataSetChanged();
                    //최근 동반 이용자 목록에서 삭제
                    alRecentAccompayingUser.remove(position);
                    //최근 동반이용자 리스트뷰 어댑터에 변경 사실을 알림
                    notifyDataSetChanged();
                }
            });
        }

        return convertView; //뷰 객체 반환
    }
}

