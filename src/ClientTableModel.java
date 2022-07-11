import java.util.List;

import javax.swing.table.AbstractTableModel;

class ClientTableModel extends AbstractTableModel {

    private static final int Statut_COL = 0 ;
    private static final int Nom_COL = 1 ;
    private static final int Prénom_COL = 2 ;
    private static final int ID_COL = 3 ;
    private static final int Adresse_COL = 4;
    private static final int Téléphone_COL = 5 ;
    private static final int Email_COL = 6 ;
    private static final int Nationnalité_COL = 7 ;

    private String[] columnNames = {"Statut","Nom","Prénom","ID","Adresse","Téléphone","E-mail","Nationnalité"};
    private List<Client> clients;

    public ClientTableModel(List<Client> theClients) {
        clients = theClients;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Client tempClient = clients.get(row);

        switch (col) {
            case Statut_COL:
                return tempClient.getStatut();
            case Nom_COL:
                return tempClient.getNom();
            case Prénom_COL:
                return tempClient.getPrénom();
            case ID_COL:
                return tempClient.getID();
            case Adresse_COL:
                return tempClient.getAdresse();
            case Téléphone_COL:
                return tempClient.getTéléphone();
            case Email_COL:
                return tempClient.getEmail();
            case Nationnalité_COL:
                return tempClient.getNationnalité();
            }
        return null ;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
