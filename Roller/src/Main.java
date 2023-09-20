public class Main {
    public static void main(String[] args) {
        Roller newRoller = new Roller(100, 10);
        for(double res : newRoller.RollAll()) {
            System.out.println(res);
        }
    }
}

