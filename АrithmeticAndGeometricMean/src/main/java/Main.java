public class Main {

    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            calculator.start();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так, программа будет закрыта");
        }
    }
}
