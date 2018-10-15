package bl;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SenderTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Sender s = (Sender) value;
        Color c = null;
        JLabel label = new JLabel();
        Font f = label.getFont();
        label.setOpaque(true);
        label.setForeground(Color.LIGHT_GRAY);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 14));
        
        if (s.getBand().equals("FM")) {
            c = Color.RED;
            label.setBackground(isSelected ? Color.BLACK : c);
            label.setForeground(isSelected ? Color.WHITE : Color.LIGHT_GRAY);
        }
        if (s.getBand().equals("AM")) {
            c = Color.BLUE;
            label.setBackground(isSelected ? Color.BLACK : c);
            label.setForeground(isSelected ? Color.WHITE : Color.LIGHT_GRAY);
        }

        switch (column) {
            case 0:
                label.setText(s.getSendername());
                break;
            case 1:
                label.setText(s.getFrequenz() + "");
                break;
            case 2:
                label.setText(s.getBand());
        }
        return label;
    }

}
