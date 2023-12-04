package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.awt.*;

@Data
@AllArgsConstructor
@ToString

public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private double salary;

}
