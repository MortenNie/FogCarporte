package dat.backend.model.persistence;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class CarportMapper {

     static int CreateCarportAndReturnCarportId(double width, double length, double height, boolean shed, int orderId, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        int ts = -1;

        String sql = "insert into carport (width, length, height, shed, order_id) values (?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {


                ps.setDouble(1, width);
                ps.setDouble(2, length);
                ps.setDouble(3, height);
                ps.setBoolean(4, shed);
                ps.setInt(5,orderId);



                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();


                ts = rs.getInt(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ts;
    }

    public static int returnCarportId(double width, double length, double height, boolean shed, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        int ts = -1;

        String sql = "insert into carport (width, length, height, shed) values (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {


                ps.setDouble(1, width);
                ps.setDouble(2,length);
                ps.setDouble(3,height);
                ps.setBoolean(4, shed);

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();


                ts = rs.getInt(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ts;
    }

    public static void addOrderIdToCarport(int orderId, int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Update carport SET order_id = ? WHERE carport_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.setInt(2, carportId);
                ps.executeUpdate();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }

    }


    public static void deleteCarport(int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from carport Where carport_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, carportId);
                ps.executeUpdate();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }


    }

    static List<Carport> selectCarportsFromOrderId(int orderId, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Carport> carportList = new ArrayList<>();
        String sql = "SELECT * FROM carport INNER JOIN itemlistrem on carport.carport_id = itemlistrem.carport_id\n" +
                "INNER JOIN itemlistspaer on carport.carport_id = itemlistspaer.carport_id\n" +
                "INNER JOIN itemlisttag on carport.carport_id = itemlisttag.carport_id\n" +
                "INNER JOIN itemliststolpe on carport.carport_id = itemliststolpe.carport_id\n" +
                "INNER JOIN rem on rem.rem_id = itemlistrem.rem_id\n" +
                "INNER JOIN spaer on spaer.spaer_id = itemlistspaer.spaer_id\n" +
                "INNER JOIN tag on tag.tag_id = itemlisttag.tag_id\n" +
                "INNER JOIN stolpe on stolpe.stolpe_id = itemliststolpe.stolpe_id WHERE carport.order_id = ?";

        try (Connection connection = connectionPool.getConnection()){

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carportId = rs.getInt("carport_id");
                    double width = rs.getDouble("width");
                    double length = rs.getDouble("length");
                    double height = rs.getDouble("height");
                    boolean shed = rs.getBoolean("shed");
                    Spaer spaer = new Spaer(rs.getInt("spaer_id"), rs.getString("spaer_name"), rs.getDouble("spaer.length"), rs.getInt("spaer.price"),rs.getInt("itemlistspaer.quantity"));
                    Rem rem = new Rem(rs.getInt("rem_id"), rs.getString("rem_name"), rs.getDouble("rem.length"), rs.getInt("rem.price"),rs.getInt("itemlistrem.quantity"));
                    Stolpe stolpe = new Stolpe(rs.getInt("stolpe_id"), rs.getString("stolpe_name"), rs.getDouble("stolpe.length"), rs.getInt("stolpe.price"),rs.getInt("itemliststolpe.quantity"));
                    Tag tag = new Tag(rs.getInt("tag_id"), rs.getString("tag_name"), rs.getDouble("tag.length"), rs.getInt("tag.price"),rs.getInt("itemlisttag.quantity"));

                    Carport newCarport = new Carport(carportId, width,length,height, shed, spaer, rem,stolpe,tag);
                    carportList.add(newCarport);


                }



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carportList;
    }



}

