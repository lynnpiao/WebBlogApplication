package com.linpiao.webblogapplication.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Administrators extends Persons{
    private Date lastLogin;

    public Administrators(String userName, String firstName, String lastName, Date lastLogin) {
        super(userName, firstName, lastName);
        this.lastLogin = lastLogin;
    }

    public Administrators(String userName) {
        super(userName);
    }

    public Administrators(String userName, Date lastLogin) {
        super(userName);
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "Administrators{" + super.toString() +
                "lastLogin=" + lastLogin +
                '}';
    }
}
