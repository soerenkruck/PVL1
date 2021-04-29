package PVL;

public class Main {

    public static void main(String[] args) {
        int states = Integer.valueOf(args[0]);

        PVL1_G33 l = new Loesung_KruckSoerenDominik_Gruppe_G33().create(4, 5);

        l.set(1,1,2);
        l.set(1,2,3);
        l.set(2,1,1);
        l.set(2,2,4);
        l.set(3,1,4);
        l.set(3,2,1);
        l.set(4,1,1);
        l.set(4, 2, 4);

        l.reset(4, 1);

        System.out.println(l.traverse_input(1, new int[]{1,1,1,2,1,2}));
    }

}
