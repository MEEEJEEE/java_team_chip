public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String profileImagePath;

    public User(String id, String name, String email, String password, String profileImagePath) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImagePath = profileImagePath;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public String getProfileImagePath() {
        return profileImagePath;
    }
}
