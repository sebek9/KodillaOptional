package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException{
        //Given
        DbManager dbManager=DbManager.getInstance();
        String sqlUpdate="UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement=dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);


        //When
        String sqlProcedureCall="CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable="SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"NOT SET\"";
        ResultSet rs=statement.executeQuery(sqlCheckTable);
        int howMany=1;
        if(rs.next()){
            howMany=rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers()throws SQLException{
        //Given
        DbManager dbManager=DbManager.getInstance();
        String sqlUpdate="UPDATE BOOKS SET BESTSELLER=0";
        Statement statement=dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall="CALL updateBestseller()";
        statement.execute(sqlProcedureCall);

        //Then
        String bestsellerCheck="SELECT COUNT(*) AS BESTSELLERS FROM BOOKS WHERE BESTSELLER=0";
        ResultSet rs=statement.executeQuery(bestsellerCheck);
        int bestsellers=2;
        if(rs.next()){
            bestsellers=rs.getInt("BESTSELLERS");
        }
        assertEquals(3,bestsellers);

    }


}
