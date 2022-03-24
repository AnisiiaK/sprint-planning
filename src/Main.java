
import tickets.UserStory;

public class Main {

    public static void main(String[] args) {
        int nextId = 1;
        Sprint sprint = new Sprint(40, 3);
        //boolean status = sprint.addUserStory(new UserStory(nextId++, "User Registration Entity", 8));


        UserStory us1 = new UserStory(nextId++, "User Registration Entity", 8);
        UserStory us2 = new UserStory(nextId++, "User Registration Form", 16, us1);
        UserStory us3 = new UserStory(nextId++, "User Registration. Apply Captcha", 16, us1, us2);

        boolean status = sprint.addUserStory(us2);
        System.out.println(status);
    }
}
