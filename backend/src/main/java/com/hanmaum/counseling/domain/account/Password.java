package com.hanmaum.counseling.domain.account;

import com.hanmaum.counseling.error.WrongPasswordException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
@Getter
public class Password {
    @Column(name = "password")
    private String password;

    @Transient
    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    public Password(){};
    public Password(String password){
        this.password = this.encoder.encode(password);
    }

    public void change(String newPassword){
        this.password = this.encoder.encode(newPassword);
    }

    public boolean match(String inputPassword) {
        return this.encoder.matches(password, inputPassword);
    }

    public String getValue() {
        return this.password;
    }

}
