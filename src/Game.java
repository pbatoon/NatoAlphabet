import java.util.*;


public class Game {

    public static void main(String[] args) {

        //Declare HashMap -> Character, String pairs
        HashMap<Character, String> natoAlphabet = new HashMap<Character, String>() {{
            put('a', "alfa");
            put('b', "bravo");
            put('c', "charlie");
            put('d', "delta");
            put('e', "echo");
            put('f', "foxtrot");
            put('g', "golf");
            put('h', "hotel");
            put('i', "india");
            put('j', "juliett");
            put('k', "kilo");
            put('l', "lima");
            put('m', "mike");
            put('n', "november");
            put('o', "oscar");
            put('p', "papa");
            put('q', "quebec");
            put('r', "romeo");
            put('s', "sierra");
            put('t', "tango");
            put('u', "uniform");
            put('v', "victor");
            put('w', "whiskey");
            put('x', "x-ray");
            put('y', "yankee");
            put('z', "zulu");
        }};

        /*
        //Print entire natoAlphabet hashmap
        for (char i : natoAlphabet.keySet()) {
            System.out.println("key: " + i + " value: " + natoAlphabet.get(i));
        }
        */

        //System.out.println("\nRandom value: " + key + " :: " + natoAlphabet.get(key));

        //Store letters already used
        List<Object> letters = new ArrayList<>();

        int i = 0;              // counter for loop
        int score = 0;          // score counter

        while(i <= natoAlphabet.size()) {
            //grab random value from Hashmap
            Object[] natoKeys = natoAlphabet.keySet().toArray();
            Object key = natoKeys[new Random().nextInt(natoKeys.length)];

            // if letter already used, generate a new key
            if(letters.contains(key)) {
                key = natoKeys[new Random().nextInt(natoKeys.length)];
            } else {
                //start timer
                long start = System.currentTimeMillis();

                //user input
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter code word for the letter " + key + " : ");

                // convert input to lower case
                String answer = (scanner.nextLine()).toLowerCase();

                // stop timer and convert to seconds
                long finish = System.currentTimeMillis();
                long timeElapsed = (finish - start) / 1000;


                if (natoAlphabet.get(key).equals(answer) && timeElapsed < 10) {
                    System.out.println("Correct! " + answer + " is the word for " + key);
                    score += 10;
                    System.out.println("Score: " + score);
                } else if (timeElapsed >= 10) {
                    System.out.println("Too slow!");
                } else {
                    System.out.println("Incorrect.");
                }

                letters.add(key);
                i++;
            }
        }

    }
}
