package tickets;

public class UserStory extends Ticket {
    private UserStory[] dependsOn;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = new UserStory[dependsOn.length];
        this.dependsOn = dependsOn.clone();
        //throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public void complete() {
        boolean dependencyStatus = true;
        for (UserStory userS : dependsOn) {
            if (!userS.isCompleted()) {
                dependencyStatus = false;
                break;
            }
        }
        if (dependencyStatus)
            super.complete();
        // throw new UnsupportedOperationException("Implement this method");
    }

    public UserStory[] getDependencies() {
        return dependsOn.clone();

        // throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public String toString() {
        return "[US " + this.getId() + "] "+ this.getName(); //"[US 1] User Story 1
        //throw new UnsupportedOperationException("Implement this method");
    }

}
