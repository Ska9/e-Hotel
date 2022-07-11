import java.util.List;
import javax.swing.table.AbstractTableModel;




class ChambreTableModel extends AbstractTableModel {

    private static final int Numéro_chambre_COL = 0 ;
    private static final int Type_COL = 1 ;
    private static final int Etage_COL = 2 ;
    private static final int Caractéristiques_COL = 3 ;
    private static final int Prix_COL = 4 ;
    private String[] columnNames = {"Numéro","Type","Etage","Caractéristiques","Prix"};
    private List<Chambre> chambres ;

    public ChambreTableModel(List<Chambre> theChambres) {
        chambres = theChambres ;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return chambres.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Chambre tempChambre = chambres.get(row);

        switch (col) {
            case Numéro_chambre_COL:
                return tempChambre.getNuméro_chambre();
            case Type_COL:
                return tempChambre.getType();
            case Etage_COL:
                return tempChambre.getEtage();
            case Caractéristiques_COL:
                return tempChambre.getCaractéristiques();
            case Prix_COL:
                return tempChambre.getPrix();   
        }
        return null ;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0,c).getClass();
    }
    
}

