package PVL;

public interface PVL1_G33 {
    void set(int state, int transition_number, int to);
    void reset(int state, int transition_number);
    State get(int state, int transition_number);
    int traverse_input(int start_state, int[] transitions);
    void addState(int state);
}
