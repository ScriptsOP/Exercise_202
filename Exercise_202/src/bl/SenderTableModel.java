
package bl;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class SenderTableModel extends AbstractTableModel {

    private ArrayList<Sender> sender = new ArrayList();
    private String[] colNames= {"Sender", "Frequenz", "Band"};
    
    public void addSender(Sender s) {
        sender.add(s);
        fireTableRowsInserted(sender.size()-1, sender.size()-1);
    }
    
    @Override
    public int getRowCount() {
        return sender.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
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
