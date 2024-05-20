import javax.swing.*;
import java.awt.*;

public class MyPage extends JPanel {
    private MainApp mainApp;

    public MyPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        User user = mainApp.getCurrentUser();

        ImageIcon profileImage = new ImageIcon(user.getProfileImagePath());
        JLabel profileImageLabel = new JLabel(profileImage);

        JTextArea userInfo = new JTextArea(10, 40);
        userInfo.setText("마이페이지\n\n");
        userInfo.append("이름: " + user.getName() + "\n");
        userInfo.append("아이디: " + user.getId() + "\n");
        userInfo.append("이메일: " + user.getEmail() + "\n");
        userInfo.append("패스워드: " + user.getPassword() + "\n");

        userInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(userInfo);

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        add(scrollPane, BorderLayout.CENTER); // 텍스트 영역을 중앙에 배치
        add(backButton, BorderLayout.SOUTH); // 버튼을 아래에 배치
    }
}