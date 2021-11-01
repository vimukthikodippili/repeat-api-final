package lk.ijse.dto;

import lk.ijse.entity.Catagory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private int productID;
    private String name;
    private String description;
    private String price;
    private String img;

    private Catagory catId;


}
