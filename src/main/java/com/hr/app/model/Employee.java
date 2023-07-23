package com.hr.app.model;

public class Employee {

    private int id;

    private String firstname;

    private String lastname;

    private String title;

    private String division;

    private int building;

    private String room;

    public Employee() {
    }

    public Employee(int id, String firstname, String lastname, String title, String division, int building, String room) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.division = division;
        this.building = building;
        this.room = room;
    }

    public Employee(String firstname, String lastname, String title, String division, int building, String room) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.division = division;
        this.building = building;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", title='" + title + '\'' +
                ", division='" + division + '\'' +
                ", building=" + building +
                ", room=" + room +
                '}';
    }
}
