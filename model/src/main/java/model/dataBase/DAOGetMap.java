package model.dataBase;

import model.LorannWorld.Map;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Romain
 */
public class DAOGetMap {


    private DBConnection connection ;
    /**
     *Instantiates a new DAOGetMap.
     */
    public DAOGetMap() {

        connection=new DBConnection();

    }

    /**
     *Which map the hero is in.
     * @param id
     * @return
     */
    public ResultSet query(String sql, int id){

        try{

            final CallableStatement call=this.connection.getConnection().prepareCall(sql);
            call.setInt(1,id); //ID map to choose
            call.executeQuery(sql);
            return call.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
