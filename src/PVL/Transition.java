package PVL;

public class Transition {

    private int transitionNumber;

    private State startState, destinationState;

    public Transition(int number, State fromState, State toState) {
        this.transitionNumber = number;
        this.startState = fromState;
        this.destinationState = toState;
    }

    public int getTransitionNumber() {
        return transitionNumber;
    }

    public State getStartState() {
        return startState;
    }

    public State getDestinationState() {
        return destinationState;
    }

    public void setDestinationState(State destinationState) {
        this.destinationState = destinationState;
    }
}
