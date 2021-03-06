package atesztoth.elte.szeraj.data;

import atesztoth.elte.szeraj.presentation.Role;
import atesztoth.elte.szeraj.presentation.UserPresentation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static User createFromPresentation(UserPresentation presentation) {
        User user = new User();
        user.setUsername(presentation.getUsername());
        user.setFirstName(presentation.getFirstName());
        user.setLastName(presentation.getLastName());
        user.setPassword(new BCryptPasswordEncoder().encode(presentation.getPassword()));
        user.setType(presentation.getType());
        return user;
    }

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "firstname", nullable = true)
    private String firstName;

    @Column(name = "lastname", nullable = true)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role type;

    @Override
    public String toString() {
        return "[username: " + username + " password: " + password + " firstName: "
                + firstName + " lastName: " + lastName + "]";
    }

    // GET SET
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getType() {
        return type;
    }

    public void setType(Role type) {
        this.type = type;
    }

    public String getId() {
        return getUsername();
    }

    public void setId(String id) { setUsername(id); }
}