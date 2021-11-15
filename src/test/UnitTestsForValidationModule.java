package test;

import com.company.ConnectionToDBCoordinator;
import com.company.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTestsForValidationModule {
    int insertedUserID;
    int currentUserIDAfterDeletion;

    @Test
    public void testPhoneNumberEdit() {
        User user = new User(
                "Vilte",
                "Martisiute",
                "+37062851923",
                "viltemart@gmail.com",
                "vilnius 8",
                "Labaaasss!"
        );

        ConnectionToDBCoordinator.insertUser(user);

        Connection connection = ConnectionToDBCoordinator.openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "SELECT ID FROM USER ORDER BY ID DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                insertedUserID = rs.getInt("ID");
            }

            ConnectionToDBCoordinator.editPhoneNumber(insertedUserID, "+37061111111");

            stmt = connection.createStatement();
            sql = "SELECT telefono_numeris FROM USER where ID = " + insertedUserID + "";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                assertEquals("+37061111111", rs.getString("Telefono_numeris"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteUser() {
        User user = new User(
                "Vilte",
                "Martisiute",
                "+37062851923",
                "viltemart@gmail.com",
                "vilnius 8",
                "Labaaasss!"
        );

        ConnectionToDBCoordinator.insertUser(user);

        Connection connection = ConnectionToDBCoordinator.openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "SELECT ID FROM USER ORDER BY ID DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                insertedUserID = rs.getInt("ID");
            }

            ConnectionToDBCoordinator.deleteUser(insertedUserID);

            stmt = connection.createStatement();
            sql = "SELECT ID FROM USER ORDER BY ID DESC LIMIT 1";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                currentUserIDAfterDeletion = rs.getInt("ID");
            };

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                assertNotEquals(insertedUserID, currentUserIDAfterDeletion);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

