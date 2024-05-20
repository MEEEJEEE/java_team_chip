import java.awt.*;
import javax.swing.*;

public class ClothingCellRenderer extends JLabel implements ListCellRenderer<Clothing> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Clothing> list, Clothing clothing, int index, boolean isSelected, boolean cellHasFocus) {
        setText(clothing.getName());
        setIcon(new ImageIcon(clothing.getImageUrl()));  // 이미지 표시 추가
        setOpaque(true);
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        return this;
    }
}
