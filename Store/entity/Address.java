package ua.kiev.prog.entity;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String Country;
    private String City;
    private String Street;

    @OneToOne(mappedBy = "address")
    private Client client;


    public Address() {
    }

    public Address(String country, String city, String street) {
        Country = country;
        City = city;
        Street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                ", Street='" + Street + '\'' +
                ", client=" + client +
                '}';
    }
}
