package bl;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

public class SenderTableModel extends AbstractTableModel {

    private ArrayList<Sender> sender = new ArrayList();
    private String[] colNames = {"Sender", "Frequenz", "Band"};
    private boolean show = false;

    public void addSender(Sender s) {
        sender.add(s);
        sortByFrequenz();
        fireTableRowsInserted(sender.size() - 1, sender.size() - 1);
    }
    
    public void sortByFrequenz(){
        Collections.sort(sender, new SortByFrequenz());
    }

    public void setShow(boolean show) {
        this.show = show;
    }
    
    public void updateTable() {
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return sender.size();
    }

    @Override
    public int getColumnCount() {
        if(show){
        return colNames.length;
        }else{
            return colNames.length-1;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sender s = sender.get(rowIndex);
        return s;
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }
}
