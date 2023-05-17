package dat.backend.model.persistence;

import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemListMapper {
    public static void AddToItemListSpaer(int spaerId, int quantity, int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Insert into itemlistspaer (spaer_id, quantity, carport_id) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, spaerId);
                ps.setInt(2, quantity );
                ps.setInt(3, carportId);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert spaer into spaerList in DB");
        }

    }

    public static void AddToItemListRem(int remId, int quantity, int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Insert into itemlistrem (rem_id, quantity, carport_id) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, remId);
                ps.setInt(2, quantity );
                ps.setInt(3, carportId);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert rem into remList in DB");
        }

    }

    public static void AddToItemListStolpe(int stolpeId, int quantity, int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Insert into itemliststolpe (stolpe_id, quantity, carport_id) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, stolpeId);
                ps.setInt(2, quantity );
                ps.setInt(3, carportId);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert stolpe into stolpeList in DB");
        }

    }

    public static void AddToItemListTag(int tagId, int quantity, int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Insert into itemlisttag (tag_id, quantity, carport_id) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, tagId);
                ps.setInt(2, quantity );
                ps.setInt(3, carportId);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert tag into tagList in DB");
        }

    }

   public static void deleteFromItemSpaer(int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from itemlistspaer Where carport_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, carportId);
                ps.executeUpdate();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete from itemlistspaer");
        }

    }

    public static void deleteFromItemRem(int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from itemlistrem Where carport_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, carportId);
                ps.executeUpdate();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete from itemlistrem");
        }

    }


    public static void deleteFromItemStolpe(int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from itemliststolpe Where carport_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, carportId);
                ps.executeUpdate();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete from itemliststolpe");
        }

    }

    public static void deleteFromItemTag(int carportId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from itemlisttag Where carport_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, carportId);
                ps.executeUpdate();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete from itemlistspaer");
        }

    }

}
