
public class Main {

    public static void main(String[] args) {
        // write your program here
        int sizeEnum = 0;
        for (Secret secret : Secret.values()) {
            if (secret.name().startsWith("STAR")) {
                sizeEnum++;
            }
        }
        System.out.println(sizeEnum);
    }
}

// sample enum for inspiration
/*enum Secret {
    RASH, START, STAR, SDFG, SDGD ,HR;
}*/
