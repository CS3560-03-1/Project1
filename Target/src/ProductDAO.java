import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO
{
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public ProductDAO(){

    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = JavaConnection.getInstance().getConnection();
        return conn;
    }

    public void add(ProductItem product)
    {
        try {
            String queryString = "INSERT INTO productitem(productID, perishable, photo, description, name) VALUES(?, ?, ?, ?, ?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, product.getProdID());
            ptmt.setBoolean(2, product.isProdPerishable());
            ptmt.setString(3, product.getProdPhoto());
            ptmt.setString(4, product.displayProdDescript());
            ptmt.setString(5, product.displayProdName());
            ptmt.executeUpdate();
            System.out.println("Data Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(ProductItem product) {
        ;
    }
}
