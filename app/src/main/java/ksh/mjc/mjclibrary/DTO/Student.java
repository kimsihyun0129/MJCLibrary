package ksh.mjc.mjclibrary.DTO;

public class Student { //학생 클래스
    private String name; //이름 저장할 문자열 변수
    private int studentNumber;//학번 저장할 정수형 변수

    //이름과 학번을 가져와서 쓰기 위한 getter 메서드
    public String getName() {
        return name;
    }
    public int getStudentNumber() {
        return studentNumber;
    }

    //생성자
    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }


}
