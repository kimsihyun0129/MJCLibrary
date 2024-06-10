package ksh.mjc.mjclibrary.DTO;

import java.io.Serializable;

public class Login implements Serializable {
    private int studentNumber;//학번 저장할 변수
    private int dateOfBirth;//생년월일을 저장할 변수

    //생성자
    public Login(int studentNumber, int dateOfBirth) {
        this.studentNumber = studentNumber;
        this.dateOfBirth = dateOfBirth;
    }

    //학번과 생년월일에 대한 getter와 setter 메소드 정의
    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
