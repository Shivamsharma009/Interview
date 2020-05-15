package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInStreamQueue {

    final static int MAX_CHAR = 26;


     static void firstnonRepeatingCharacter(String str) {
        Queue<Character> q = new LinkedList<Character>();
        int[] charCount = new int[MAX_CHAR];


        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //character push to queue
            q.add(ch);

            //update frequency
            charCount[ch - 'a']++;

            //check for non repeating character
            while (!q.isEmpty()) {
                if (charCount[q.peek() - 'a'] > 1) {
                    q.remove();
                } else {
                    System.out.print(q.peek() + "    ");
                    break;
                }
            }
            if (q.isEmpty()) {
                System.out.print(-1 +"  ");
            }
            System.out.print("  ");
        }
    }

    //Driver program
    public static void main(String[] args) {

        String str ="aaac";
        firstnonRepeatingCharacter(str);
     }
}
