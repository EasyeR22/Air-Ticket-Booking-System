package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private String email,password,name,surname,iin,phoneNumber;
    private int cash;

    public User(String email,String password,String name,String surname){
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}

/*class user:
	- email: sting
	- password
	- name
	- surname
	- cash balance: 0
	- iin
	- phone number
 */
