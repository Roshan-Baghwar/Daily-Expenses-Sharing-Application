import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void createUser(String email, String name, String mobile) {
        if(users.containsKey(email)) {
            throw new IllegalArgumentException("User already exists");
        }
        users.put(email, new User(email, name, mobile));
    }

    public User getUser(String email) {
        return users.get(email);
    }
}
