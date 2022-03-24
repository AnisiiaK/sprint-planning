package tickets;


public class Bug extends Ticket {
    private UserStory userStory;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory == null || userStory.isCompleted() == false)
            return null;
        return new Bug(id, name, estimate, userStory);

        //throw new UnsupportedOperationException("Implement this method");
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;

        //throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public String toString() {
        return "[Bug " + this.getId() + "] " + userStory.getName() + ": " + this.getName();

        //throw new UnsupportedOperationException("Implement this method");
    }
}
