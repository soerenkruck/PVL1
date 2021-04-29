package PVL;

// Ändern Sie den Klassen und Datei Namen. Arbeiten Sie in Beispielweise in der Gruppe 1. Nennen Sie das File und die Klasse "PVL1_G1". Arbeiten Sie alleine
// und heißen Sie Beispielweise "Max Mustermann", dann nennen Sie das File und die Klasse "PVL1_Max_Mustermann"

public class Loesung_KruckSoerenDominik_Gruppe_G33 implements PVL1_G33 {

    private State[] states;
    private int[] inputs;   // obsolet -> Wird nicht benötigt.

    public static PVL1_G33 create(int number_of_states, int number_of_inputs) {
        Loesung_KruckSoerenDominik_Gruppe_G33 l = new Loesung_KruckSoerenDominik_Gruppe_G33();

        l.states = new State[number_of_states];
        for (int i = 0; i < number_of_states; i++) {
            l.addState(i);
        }

        l.inputs = new int[number_of_inputs]; // ebenfalls obsolet.

        return l;
    }

    @Override
    public void addState(int state) {
        if (state < states.length)
            states[state] = new State(state + 1);
        else
            System.err.println("Diesen State gibt es bereits. Er müsste einen Wert von mindestens " + states.length + " haben.");
    }

    @Override
    public void set(int state, int transition_number, int to) {
        states[state - 1].addTransition(Utility.getStateFromNumber(states, to), transition_number);
    }

    @Override
    public void reset(int state, int transition_number) {
        Utility.getStateFromNumber(states, state).resetTransition(transition_number);
    }

    @Override
    public State get(int state, int transition_number) {
        return Utility.getStateFromNumber(states, state).transitionFromNumber(transition_number).getDestinationState();
    }

    @Override
    public int traverse_input(int start_state, int[] transitions) {

        State currentState = Utility.getStateFromNumber(states, start_state);

        for (int step = 0; step < transitions.length; step++) {
            Transition way = currentState.transitionFromNumber(transitions[step]);

            if (way == null || way.getDestinationState() == null) {
                System.err.println("Dieser Weg ist so nicht verfügbar");
                return -1;
            }

            currentState = way.getDestinationState();
        }

        return currentState.getStateNumber();
    }
}
