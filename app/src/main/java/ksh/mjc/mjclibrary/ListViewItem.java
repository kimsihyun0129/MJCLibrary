package ksh.mjc.mjclibrary;

public class ListViewItem { //리스트뷰(추가 동반이용자 리스트뷰, 최근 동반이용자 리스트뷰)에 들어갈 아이템 객체
    private String name; //이름 저장할 문자열 변수
    private int studentNumber;//학번 저장할 문자열 변수

    //이름과 학번을 가져와서 쓰기 위한 getter 메서드
    public String getName() {
        return name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    //생성자
    public ListViewItem(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }
}
