import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDAO
{
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public CartDAO(){

    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = JavaConnection.getInstance().getConnection();
        return conn;
    }

    public void add(ShoppingCart cart)
    {
        try {
            String queryString = "INSERT INTO shoppingcart(cartID, productQuantity, totalCost) VALUES(?, ?, ?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, cart.getCartID());
            ptmt.setInt(2, cart.getProdQuantity());
            ptmt.setFloat(3, cart.getTotalCost());
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

    public void update(ShoppingCart cart)
    {
        try {
            String queryString = "UPDATE shoppingcart SET productQuantity=?, totalCost=? WHERE cartID=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, cart.getProdQuantity());
            ptmt.setFloat(2, cart.getTotalCost());
            ptmt.setInt(3, cart.getCartID());
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

    public void delete(int cartID)
    {
        try
        {
            String queryString = "DELETE FROM shoppingcart WHERE cartID=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, cartID);
            ptmt.executeUpdate();
            System.out.println("Data Deleted Successfully");
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
}
