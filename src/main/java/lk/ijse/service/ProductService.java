package lk.ijse.service;

import lk.ijse.dto.ProductDTO;

import java.util.ArrayList;

public interface ProductService {

    void addProduct(ProductDTO dto);

    void deleteProduct(int id);

    ProductDTO searchProduct(int id);

    ArrayList<ProductDTO> getAllProduct();

    void updateProduct(ProductDTO dto);
}
