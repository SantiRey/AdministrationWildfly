package model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@NamedQueries({
        @NamedQuery(name = "Helado.findHeladoByUserId", query = "SELECT h FROM Helado h WHERE h.user.userID = :id")
})
public class Helado {
    @Id
    @GeneratedValue
    int heladoID;

    String name;

    int price;

    int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    User user;

    //CONSTRUCTOR
    public Helado(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public Helado() {
    }

    public Helado(String name, int price, int number) {
        this.name=name;
        this.price=price;
        this.number=number;
    }

    //CONSTRUCTOR
    @Override
    public String toString() {
        return "Helado{" +
                "heladoID=" + heladoID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}