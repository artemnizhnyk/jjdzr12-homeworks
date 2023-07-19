public class Main {

    public static String isSuccessInTheTask(boolean isSuccess) {
        if (isSuccess) {
            return "successfully";
        } else
            return "not successfully";
    }

    public static void main(String[] args) {

        Person person = new Person("Artem");
        System.out.println(person + " finished Ex1 " + isSuccessInTheTask(true) + "!");
    }
}