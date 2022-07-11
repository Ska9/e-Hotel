/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageBase;

/**
 *
 * @author Skander
 */

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Metier {
        Connection myConn = null;

    public Metier() throws SQLException {
        
                    myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","student" , "student");

    }

    
public void updateClient(String Nom , String Prénom , String Adresse , String Téléphone ,String Email ,String ID   ) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Client"
					+ " set Nom=?, Prénom=?,  Adresse=?, Téléphone=?, mail=?"
					+ " where ID=?");
			
			// set params
			myStmt.setString(1, Nom);
			myStmt.setString(2, Prénom);
			myStmt.setString(3, Adresse);
                        myStmt.setString(4, Téléphone);
                        myStmt.setString(5, Email);
			myStmt.setString(6, ID);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			myStmt.close();
		}
		
	} 
       public void updateChambre(String Numéro_chambre, String Type, String Etage, String Caractéristiques, String Prix) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Chambre"
					+ " Type=?,  Etage=?, Caractéristiques=?, Prix=?"
					+ " where Numéro=?");
			
			// set params
			myStmt.setString(1, Type);
			myStmt.setString(2, Etage);
			myStmt.setString(3, Caractéristiques);
                        myStmt.setString(4, Prix);
                        myStmt.setString(5, Numéro_chambre);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			myStmt.close();
		}
		
	} 


}
