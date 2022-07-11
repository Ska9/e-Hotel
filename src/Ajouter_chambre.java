import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;




public class Ajouter_chambre extends JFrame {
    JLabel label1 ;
    JLabel label2 ;
    JLabel label3 ;
    JLabel label4 ;
    JLabel label5 ;
    JTextField t1 ;
    JTextField t4 ;
    JTextField t5 ;
    JComboBox type ;
    JComboBox etage ;
    JButton b1 ;
    JButton b2 ;
    JButton b3 ;
    Connection myConn = null ;
    EspaceChambres ECH ;

    public Ajouter_chambre() {
        this.ECH=ECH;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","student" , "student");
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1050,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ajouter chambre");

        
        
        
        JPanel p=(JPanel)this.getContentPane();




        label1 = new JLabel("Numéro chambre :");
        label1.setBounds(50,50,200,20);
        p.add(label1);

        t1 = new JTextField();
        t1.setBounds(160,50,100,20);
        p.add(t1);




        label2 = new JLabel("Type :");
        label2.setBounds(50,100,200,20);
        p.add(label2);

        String[] Type = {"Single","Double"};
        type = new JComboBox(Type);
        type.setBounds(160,100,100,20);
        p.add(type);


        
        
        label3 = new JLabel("Etage :");
        label3.setBounds(50,150,100,20);
        p.add(label3);

        String[] Etage = {"01","02","03","04","05"};
        etage = new JComboBox(Etage);
        etage.setBounds(160,150,100,20);
        p.add(etage);
        
        
        
        
        label4 = new JLabel("Caractéristiques");
        label4.setBounds(50,200, 100,20);
        p.add(label4);

        t4 = new JTextField();
        t4.setBounds(160,200,200,20);
        p.add(t4);
  



        label5 = new JLabel("Prix :");
        label5.setBounds(50,250,100,20);
        p.add(label5);

        t5 = new JTextField();
        t5.setBounds(160,250, 200, 20);
        p.add(t5);


   
        
        b1 = new JButton("Enregistrer");
        b1.setBounds(730, 400, 110, 20);
        p.add(b1);
        rootPane.setDefaultButton(b1);
        b1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
		try{
                ajouter ();
		} catch (SQLException ex) {
		Logger.getLogger(Ajouter_chambre.class.getName()).log(Level.SEVERE, null, ex);
		}
		dispose();}
        

		});

        
        
        
        b2 = new JButton("Annuler");
        b2.setBounds(850,400,110,20);
        p.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        
        
        
        
        b3 = new JButton("Créer type");
        b3.setBounds(610,400,110,20);
        p.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Creer_Type();
            }
        });
        setVisible(true);
    }

    public List<Chambre> getAllChambres() throws Exception {
        List<Chambre> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from Chambre");
            while (myRs.next()) {
                Chambre tempChambre = convertRowToChambre(myRs);
                list.add(tempChambre);
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public List<Chambre> searchChambre(String lastName) throws Exception {
        List<Chambre> list = new ArrayList<>();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            lastName += "%";
            myStmt = myConn.prepareStatement("select * from Chambre where last_name like ?");
            myStmt.setString(1, lastName);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                Chambre tempChambre = convertRowToChambre(myRs);
                list.add(tempChambre);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }

        private Chambre convertRowToChambre(ResultSet myRs) throws SQLException {
        String Numéro_chambre = myRs.getString("Numéro");
        String Type = myRs.getString("Type");
        String Etage = myRs.getString("Etage");
        String Caractéristiques = myRs.getString("Caractéristiques");
        String Prix = myRs.getString("Prix");
        Chambre tempChambre = new Chambre(Numéro_chambre,Type,Etage,Caractéristiques,Prix);
        return tempChambre;
    }


    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
            throws SQLException {
        if (myRs != null) {
            myRs.close();
        }
        if (myStmt != null) {
        }
        if (myConn != null) {
            myConn.close();
        }
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    public void ajouter () throws SQLException{
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            // 2. Create a statement
            myStmt = myConn.createStatement();
            // our work
            String sql="insert into Chambre " + " (Numéro,Type,Etage,Caractéristiques,Prix)"
                    + " values ("
                    +"'" + t1.getText() + "'"
                    + "," + " ' " + type.getSelectedItem().toString() + "'"
                    + "," + "'" + etage.getSelectedItem().toString() + "'"
                    + "," + "'" + t4.getText() + "'"
                    + "," + "'" + t5.getText() + "'"
                    + ")" ;
            myStmt.executeUpdate(sql);
        }catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
                    }
        List<Chambre> chambres = null;
        try {
            chambres = getAllChambres();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // create the model and update the "table"
        ChambreTableModel model = new ChambreTableModel(chambres);
        ECH.getTableau_Chambres().setModel(model);
        ECH = null;

    }
    
}
