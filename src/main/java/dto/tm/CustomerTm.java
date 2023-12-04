package dto.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.awt.*;
@Data
@ToString
public class CustomerTm {
    private String id;
    private String name;
    private String address;
    private double salary;
    private javafx.scene.control.Button editBtn;
    private Button deleteBtn;

    public CustomerTm(String id, String name, String address, double salary, javafx.scene.control.Button editBtn, javafx.scene.control.Button deleteBtn) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.editBtn = editBtn;
        this.deleteBtn = deleteBtn;

    }
}
