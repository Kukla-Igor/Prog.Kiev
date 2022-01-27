package ua.kiev.prog;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Contacts")
@NoArgsConstructor
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue
    @Expose
    private long id;
    
    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    @Expose
    private String name;
    @Expose
    private String surname;
    @Expose
    private String phone;
    @Expose
    private String email;

    public Contact(Group group, String name, String surname, String phone, String email) {
        this.group = group;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }
}
