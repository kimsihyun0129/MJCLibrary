package ksh.mjc.mjclibrary.DTO;

public class Reservation_status {

    String reservation_room, reservation_date,reservation_starttime,reservation_endtime,reservation_type;

    public String getReservation_room() {
        return reservation_room;
    }

    public void setReservation_room(String reservation_room) {
        this.reservation_room = reservation_room;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }



    public String getReservation_type() {
        return reservation_type;
    }

    public void setReservation_type(String reservation_person) {
        this.reservation_type = reservation_person;
    }

    public String getReservation_starttime() {
        return reservation_starttime;
    }

    public void setReservation_starttime(String reservation_starttime) {
        this.reservation_starttime = reservation_starttime;
    }

    public String getReservation_endtime() {
        return reservation_endtime;
    }

    public void setReservation_endtime(String reservation_endtime) {
        this.reservation_endtime = reservation_endtime;
    }

    public Reservation_status(String rvroom, String rvdate,String rvstime ,String rvetime, String rvperson){
        this.reservation_room = rvroom;
        this.reservation_date=rvdate;
        this.reservation_starttime=rvstime;
        this.reservation_endtime = rvetime;
        this.reservation_type=rvperson;
    }
}
