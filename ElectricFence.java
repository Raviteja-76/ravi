import java.util.*;

public class ElectricFence {

    // Method to calculate the Euclidean distance between two points
    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read the number of wire segments
        int N = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        double totalVoltage = 0;

        // Step 2: Read the wire segment coordinates and calculate the total voltage
        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            // Calculate distance (voltage) of this segment and add it to the total
            totalVoltage += calculateDistance(x1, y1, x2, y2);
        }

        // Step 3: Read the animal resistance thresholds
        Map<String, Integer> animalResistances = new HashMap<>();
        String animalData = sc.nextLine();
        String[] animalPairs = animalData.split(" ");

        // Step 4: Store the resistance data
        for (String pair : animalPairs) {
            String[] keyValue = pair.split(":");
            String animal = keyValue[0];
            int resistance = Integer.parseInt(keyValue[1]);
            animalResistances.put(animal, resistance);
        }

        // Step 5: Read the animal that touched the fence
        String touchedAnimal = sc.nextLine();

        // Step 6: Check if the animal died
        boolean died = totalVoltage > animalResistances.get(touchedAnimal);
        System.out.println(died ? "Yes" : "No");

        // Step 7: Calculate the probability of Raju securing his crops
        int survivingAnimals = 0;
        int totalAnimals = animalResistances.size();

        // For each animal, check if it survives
        for (String animal : animalResistances.keySet()) {
            if (totalVoltage <= animalResistances.get(animal)) {
                survivingAnimals++;
            }
        }

        // Calculate the probability
        double probability = (double) survivingAnimals / totalAnimals;
        System.out.printf("%.2f\n", probability);

        sc.close();
    }
}
