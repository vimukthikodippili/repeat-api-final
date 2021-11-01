package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    private String name;
    private String description;
    private String price;
    private String img;

    @ManyToOne
    @JoinColumn(name = "catId", referencedColumnName = "categoryID")
    private Catagory catId;







//    public Catagory getCatagories() {
//        return catagories;
//    }
//
//    public void setCatagories(Catagory catagories) {
//        this.catagories = catagories;
//    }
}
