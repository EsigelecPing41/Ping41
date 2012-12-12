package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modele.Piece;

public abstract class PieceDAO extends DAO<Piece>
{
        public PieceDAO(Connection conn) 
        {
           super(conn);
        }

        public boolean create(Piece obj) 
        {
           return false;
        }

        public boolean delete(Piece obj) 
        {
           return false;
        }

        public Piece find(String CB) 
        {
           Piece piece = new Piece();                
                
        try 
        {
        	ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Piece WHERE P_CodeBarre = " + CB);
            if(result.first())
            piece = new Piece(result.getInt("P_ID"),result.getString("P_nom"), CB,result.getInt("P_IDLieu"), result.getInt("P_IDFournisseur"),result.getInt("P_IDCommande"));
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
                return piece;
        }

        public boolean update(Piece obj)
        {
                return false;
        }

}