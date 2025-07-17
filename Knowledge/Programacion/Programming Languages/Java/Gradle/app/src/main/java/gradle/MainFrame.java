package gradle;

import java.awt.GraphicsEnvironment;

public class MainFrame{
    public static void main(String[] args) {
        try {
            //check if the environment is headless
            boolean isHeadless = GraphicsEnvironment.isHeadless();
            System.out.println(isHeadless ? "Running in headless mode" : "Running with GUI support");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error occurred while checking the graphics environment: " + e.getMessage());
        }
    }
    
}
