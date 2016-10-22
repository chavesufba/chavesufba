package br.ufba.chavesime.model;

import java.io.Serializable;

/**
 * Created by Igor on 9/3/16.
 */
public class Sala implements Serializable {

    private int id;
    private String number;
    private int capacity;
    private String roomType;

    public Sala(int id, String number, int capacity, String roomType) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

}
