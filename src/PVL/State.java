package PVL;

import java.util.ArrayList;

public class State {

    private int state;

    private ArrayList<Transition> hiddenTransitionList;
    public Transition transitions[];

    public State(int number) {
        this.state = number;

        hiddenTransitionList = new ArrayList<>();
    }

    public void addTransition(State toState, int transitionNumber) {
        hiddenTransitionList.add(new Transition(transitionNumber, this, toState));

        transitions = new Transition[hiddenTransitionList.size()];

        for (int i = 0; i < hiddenTransitionList.size(); i++) {
            transitions[i] = hiddenTransitionList.get(i);
        }
    }

    public Transition transitionFromNumber(int transitionNumber) {
        for (Transition transition: transitions) {
            if (transition.getTransitionNumber() == transitionNumber) {
                return transition;
            }
        }
        return null;
    }

    public void resetTransition(int transitionNumber) {
        transitionFromNumber(transitionNumber).setDestinationState(this);
    }

    public int getStateNumber() {
        return this.state;
    }

}
