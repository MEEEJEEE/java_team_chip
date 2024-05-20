import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private User currentUser;

    public MainApp() {
        this.currentUser = new User("noonsong", "눈송이", "smu@sookmyung.ac.kr", "123", "path/to/profile.jpg"); // 사용자 정보 예시
        setupUI();
        showMainPage();
    }

    private void setupUI() {
        setTitle("클로징 Clothing");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel.add(new MainPage(this), "MainPage");
        mainPanel.add(new ClosetPage(this), "ClosetPage");
        mainPanel.add(new CoordinationPage(this), "CoordinationPage");
        mainPanel.add(new LaundryGuidePage(this), "LaundryGuidePage");
        mainPanel.add(new AddClothingPage(this), "AddClothingPage");
        mainPanel.add(new ClothingDetailPage(this), "ClothingDetailPage");
        mainPanel.add(new MyPage(this), "MyPage");

        add(mainPanel);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void showMainPage() {
        cardLayout.show(mainPanel, "MainPage");
    }

    public void showClosetPage() {
        cardLayout.show(mainPanel, "ClosetPage");
    }

    public void showCoordinationPage() {
        cardLayout.show(mainPanel, "CoordinationPage");
    }

    public void showLaundryGuidePage() {
        cardLayout.show(mainPanel, "LaundryGuidePage");
    }

    public void showAddClothingPage() {
        cardLayout.show(mainPanel, "AddClothingPage");
    }

    public void showClothingDetailPage() {
        cardLayout.show(mainPanel, "ClothingDetailPage");
    }

    public void showMyPage() {
        cardLayout.show(mainPanel, "MyPage");
    }

    public Component getComponentByName(String name) {
        for (Component component : mainPanel.getComponents()) {
            if (component.getClass().getSimpleName().equals(name)) {
                return component;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}
