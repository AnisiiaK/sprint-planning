

import tickets.Bug;
import tickets.Ticket;
import tickets.UserStory;

public class Sprint {
    private int capacity;
    private int ticketsLimit;
    private Ticket[] sprintTickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.sprintTickets = new Ticket[0];
        //throw new UnsupportedOperationException("Implement this method");
    }

    public boolean dependencyAcceptStatus(UserStory userStory) {
        boolean dependencyAcceptStatus;
        int dependencyUnCompletedCount = 0;
        int dependencyInSprintCount = 0;
        UserStory[] userStoryDependencies = userStory.getDependencies();
        for (UserStory userStoryD : userStoryDependencies) {
            if (!userStoryD.isCompleted()) {
                dependencyUnCompletedCount++;
                for (Ticket sprintT : sprintTickets)
                    if (userStoryD == sprintT)
                        dependencyInSprintCount++;
            }
        }
        if (dependencyUnCompletedCount == dependencyInSprintCount) {
            dependencyAcceptStatus = true;
        } else dependencyAcceptStatus = false;

        return dependencyAcceptStatus;
    }

    public boolean isCapacityOverflow(Ticket ticket) {
        if ((getTotalEstimate() + ticket.getEstimate()) > getCapacity()) {
            return true;
        } else return false;
    }

    public boolean addUserStory(UserStory userStory) {
        /*accepts a userStory, if it is not `null`, not completed
  and its uncompleted dependencies are already accepted to the sprint*/
        /*It is not allowed for a Sprint to contain tickets with total estimate greater than time capacity.
  It is not allowed for a Sprint to contain total amount of tickets greater than tickets limit*/
        if (userStory == null || userStory.isCompleted() || getTicketsLimit() == 0 || isCapacityOverflow(userStory)) {
            //System.out.println("1st if");
            return false;
        }
        if (dependencyAcceptStatus(userStory)) {
            addTicket(userStory);

            return true;
        } else {
            //System.out.println("2nd if");

            return false;
        }
        //dependencyAcceptStatus =true;
        //throw new UnsupportedOperationException("Implement this method");
    }

    public boolean addBug(Bug bugReport) {
        /*accepts a bug, if it is not `null` and not completed.
  Returns `true` if the bug is accepted, `false` otherwise*/
        if (bugReport == null || bugReport.isCompleted() || getTicketsLimit() == 0 || isCapacityOverflow(bugReport)) {
            return false;
        } else {
            addTicket(bugReport);
            return true;
        }
        //throw new UnsupportedOperationException("Implement this method");
    }

    public void addTicket(Ticket ticket) {
        //this.sprintTickets[this.sprintTickets.length - this.getTicketsLimit()] = ticket;

        Ticket[] tempTickets = new Ticket[this.sprintTickets.length + 1];
        for (int i = 0; i < this.sprintTickets.length; i++) {
            tempTickets[i] = this.sprintTickets[i];
        }
        tempTickets[tempTickets.length - 1] = ticket;
        sprintTickets = new Ticket[tempTickets.length];
        sprintTickets = tempTickets.clone();
        this.setTicketsLimit(ticketsLimit - 1);
    }

    public Ticket[] getTickets() {
        return sprintTickets.clone();
        //throw new UnsupportedOperationException("Implement this method");
    }

    public int getTotalEstimate() {
        int sum = 0;
        if(sprintTickets != null){
            for (Ticket t : sprintTickets) {
                if(t != null)
                    sum += t.getEstimate();
            }
        }
        return sum;

        //throw new UnsupportedOperationException("Implement this method");
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setTicketsLimit(int ticketsLimit) {
        this.ticketsLimit = ticketsLimit;
    }

    public int getTicketsLimit() {
        return this.ticketsLimit;
    }
}
