package ksh.mjc.mjclibrary;

public class StudyRoom {//스터디룸 클래스 정의
    String studyRoomName;//스터디룸 이름
    int minNumberOfPeople, maxNumberOfPeople;//스터디룸 최소인원/최대인원

    //생성자(스터디룸 이름과 최소/최대 인원 초기화
    public StudyRoom(String studyRoomName, int minNumberOfPeople, int maxNumberOfPeople) {
        this.studyRoomName = studyRoomName;
        this.minNumberOfPeople = minNumberOfPeople;
        this.maxNumberOfPeople = maxNumberOfPeople;
    }
}
