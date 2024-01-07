package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Orders {
    @Id
    private String orderId;
    private String date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Orders(String orderId, String date){
        this.orderId = orderId;
        this.date = date;
    }
}
