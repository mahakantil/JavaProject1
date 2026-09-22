import java.time.LocalDateTime;

public class HelloDocker {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   Hello from Dockerized Java App");
        System.out.println("=================================");
        System.out.println("Current date & time: " + LocalDateTime.now());
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Running inside container successfully!");
    }
}