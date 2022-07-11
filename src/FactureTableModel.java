import java.util.List;
import javax.swing.table.AbstractTableModel;




class FactureTableModel extends AbstractTableModel {
     private static final int Numéro_facture_COL = 0 ;
    private static final int ID_client_COL = 1 ;
    private static final int Date_COL = 2 ;
    private static final int Nombre_personne_COL = 3 ;
    private static final int Total_COL = 4 ;
    private String[] columnNames = {"Numéro facture","ID Client","Date","Nombre personne","Total"};
    private List<Facture> factures ;

    public FactureTableModel(List<Facture> theFactures) {
        factures = theFactures ;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return factures.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Facture tempFacture = factures.get(row);

        switch (col) {
            
            case Numéro_facture_COL:
                return tempFacture.getNuméro_facture();
            case ID_client_COL:
                return tempFacture.getID_client();
            case Date_COL:
                return tempFacture.getDate();
            case Nombre_personne_COL:
                return tempFacture.getNombre_personne();
            case Total_COL:
                return tempFacture.getTotal();
        }
        return null ;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0,c).getClass();
    }
    
}
