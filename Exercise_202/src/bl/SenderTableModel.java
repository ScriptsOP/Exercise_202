package bl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

public class SenderTableModel extends AbstractTableModel {

    private transient ArrayList<Sender> sender = new ArrayList();
    private String[] colNames = {"Sender", "Frequenz", "Band"};
    private boolean show = false;

    public void addSender(Sender s) {
        sender.add(s);
        sortByFrequenz();
        fireTableRowsInserted(sender.size() - 1, sender.size() - 1);
    }

    public void sortByFrequenz() {
        Collections.sort(sender, new SortByFrequenz());
    }

    public void save(File f) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        for (Sender s : sender) {
            oos.writeObject(s);
        }
        oos.flush();
        oos.close();
    }

    public void load(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try {
            Sender s;
            while ((s = (Sender) ois.readObject()) != null) {
                sender.add(s);
            }
            ois.close();
        } catch (EOFException eof) {

        }
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
        if (show) {
            return colNames.length;
        } else {
            return colNames.length - 1;
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
