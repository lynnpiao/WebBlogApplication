package com.linpiao.webblogapplication.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class BlogUsers extends Persons{
    private Date dob;
    private StatusLevel statusLevel;

    public enum StatusLevel {
        novice, intermediate, advanced}

    public BlogUsers(String userName, String firstName, String lastName, Date dob, StatusLevel statusLevel) {
        super(userName, firstName, lastName);
        this.dob = dob;
        this.statusLevel = statusLevel;
    }

    public BlogUsers(String userName) {
        super(userName);
    }

    public BlogUsers(String userName, Date dob, StatusLevel statusLevel) {
        super(userName);
        this.dob = dob;
        this.statusLevel = statusLevel;
    }

    @Override
    public String toString() {
        return "BlogUsers{" + super.toString() +
                "DoB=" + dob +
                ", statusLevel=" + statusLevel +
                '}';
    }
}
