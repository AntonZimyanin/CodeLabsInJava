package mainPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class FunctionTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    private String needle = null;
    private String needleX = null;
    private String needleY = null;    
    private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();

    public FunctionTableCellRenderer() {
        // Показывать только 5 знаков после запятой
        formatter.setMaximumFractionDigits(5);
        // Не использовать группировку (не отделять тысячи ни запятыми, ни пробелами)
        formatter.setGroupingUsed(false);
        // Установить в качестве разделителя дробной части точку, а не запятую.
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        // Разместить надпись внутри панели
        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // выравнивание по левому краю
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean
        isSelected, boolean hasFocus, int row, int col) {
    // Преобразовать double в строку с помощью форматировщика
    String formattedDouble = formatter.format(value);
    // Установить текст надписи равным строковому представлению числа
    label.setText(formattedDouble);
    if ((col==0 && needleX !=null && needleX.equals(formattedDouble)) || 
        (col==1 && needleY !=null && needleY.equals(formattedDouble))) {
        // Номер столбца = 0 или 1 (т.е. первый или второй столбец) + иголка не null (значит что-то ищем)
        // + значение иголки совпадает со значением ячейки таблицы - окрасить задний фон
        // панели в красный цвет
        panel.setBackground(Color.RED);
    } else {
        // Иначе - в обычный белый
        panel.setBackground(Color.WHITE);
    }
    return panel;
}


    public void setNeedle(String needle) {
        this.needle = needle;
    }

    public void setNeedleX(String needle) {
        this.needleX = needle;
    }

    public void setNeedleY(String needle) {
        this.needleY = needle;
    }
}