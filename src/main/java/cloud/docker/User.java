package cloud.docker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
