package PVL;

public class Utility {

    public static State getStateFromNumber(State states[], int number) {
        for (State state: states) {
            if (state.getStateNumber() == number) {
                return state;
            }
        }
        return null;
    }

    public static Transition[] getAllTransitions(State states[]) {

        int index = 1;

        // Zählt, wie viele Transitions es gibt.
        for (State state: states) {
            for (Transition trans: state.transitions) {
                index++;
            }
        }

        Transition[] transitions = new Transition[index];

        for (State state: states) {
            for (Transition trans: state.transitions) {
                transitions[transitions.length] = trans;
            }
        }

        return transitions;
    }
}
