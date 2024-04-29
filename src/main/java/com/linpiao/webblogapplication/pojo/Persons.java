package com.linpiao.webblogapplication.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persons {
    private String userName;
    private String firstName;
    private String lastName;

    public Persons(String userName) {
        this.userName = userName;
    }
}
