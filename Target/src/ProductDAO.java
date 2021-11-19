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

    public void add(InventoryItem item) //still needs to be changed
    {
        try {
            String queryString = "INSERT INTO inventoryitem(inventoryitemID, productID, item name, quantity, cost, color, weight, size, description) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, item.getInventoryID());
            ptmt.setInt(2, item.getProductID());
            ptmt.setString(3, item.getItemName());
            ptmt.setInt(4, item.getQuantity());
            ptmt.setFloat(5, item.getCost());
            ptmt.setString(6, item.getColor());
            ptmt.setFloat(7, item.getWeight());
            ptmt.setString(8, item.getSize());
            ptmt.setString(9, item.getDescription());
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

    public void update(ProductItem product)
    {
        try {
            String queryString = "UPDATE productitem SET perishable=?, photo=?, description=?, name=? WHERE productID=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setBoolean(1, product.isProdPerishable());
            ptmt.setString(2, product.getProdPhoto());
            ptmt.setString(3, product.displayProdDescript());
            ptmt.setString(4, product.displayProdName());
            ptmt.setInt(5, product.getProdID());
            ptmt.executeUpdate();
            System.out.println("Table Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            }

            catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
