package tickets;

public class Ticket {

    private int id;
    private String name;
    private int estimate;
    private boolean completeStatus;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.completeStatus = false;
        //throw new UnsupportedOperationException("Implement this method");
    }

    public int getId() {
        return id;
        //throw new UnsupportedOperationException("Implement this method");
    }

    public String getName() {
        return name;
        //throw new UnsupportedOperationException("Implement this method");
    }

    public boolean isCompleted() {
        return completeStatus;
        //throw new UnsupportedOperationException("Implement this method");
    }

    public void complete() {
        completeStatus = true;
        //throw new UnsupportedOperationException("Implement this method");
    }

    public int getEstimate() {
        return estimate;
        //throw new UnsupportedOperationException("Implement this method");
    }
}
