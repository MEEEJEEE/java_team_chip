import javax.swing.*;
import java.awt.*;

public class ClothingDetailPage extends JPanel {
    private MainApp mainApp;

    public ClothingDetailPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        JTextArea clothingDetail = new JTextArea(10, 40);
        clothingDetail.setText("옷 상세 정보\n");

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showClosetPage());

        add(new JLabel("옷 상세 정보", JLabel.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(clothingDetail), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
