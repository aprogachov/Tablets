package server.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import server.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("PRODUCT_ID"));
        product.setName(rs.getString("NAME"));
        product.setStateId(rs.getInt("STATEID"));
        return product;
    }
}