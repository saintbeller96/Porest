package com.hanmaum.counseling.domain.account;

import com.hanmaum.counseling.error.WrongPasswordException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Password {
    @Column(name = "password")
    private String password;
    private PasswordEncoder encoder;

    public Password(){};
    public Password(String password, PasswordEncoder encoder){
        this.encoder = encoder;
        this.password = this.encoder.encode(password);
    }

    public void change(String newPassword){
        this.password = this.encoder.encode(newPassword);
    }

    public boolean match(String inputPassword) {
        return this.encoder.matches(password, inputPassword);
    }

}
