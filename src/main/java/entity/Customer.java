package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@ToString
@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders = new ArrayList<>();
}
