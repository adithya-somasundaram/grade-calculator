// Adithya Somasundaram

import java.util.Scanner;

class grade{
    static class Node{
        float percent;
        float score;
        Node next;
        Node(float x, float y){
            percent = x;
            score = y;
            next = null;
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);	//scanner for input
        Node head = null, tail = null;
        String[] temp, letters = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-","D+", "D", "D-", "F"};
        String input;
        int[] grades = {97, 93, 90, 87, 83, 80, 77, 73, 70, 67, 63, 60};
        
        System.out.println("Welcome to the Grade Calculator!");
        System.out.println("Enter the weight of each grade and the grade you received, with a space in between the two numbers");
        System.out.println("Enter 'done' when ready to calculate scores");
        while(true){
            input = s.nextLine();
            if(input.equals("done")){
                break;
            }
            temp = input.split(" ");
            if(head == null){
                head = new Node(Float.parseFloat(temp[0]), Float.parseFloat(temp[1]));
            } else if (head.next == null){
                head.next = new Node(Float.parseFloat(temp[0]), Float.parseFloat(temp[1]));
                tail = head.next;
            } else {
                tail.next = new Node(Float.parseFloat(temp[0]), Float.parseFloat(temp[1]));
                tail = tail.next;
            }
        }
        Node holder = head;
        float sum_percent = 0, percent_left = 0, raw_score = 0;
        while(holder != null){
            sum_percent += holder.percent;
            raw_score += holder.percent * holder.score/100;
            holder = holder.next;
        }
        percent_left = 100 - sum_percent;
        if(percent_left <= 0){
            System.out.println("The sum of your categories is greater than ot equal to 100");
            s.close();
            System.exit(0);
        }
        float score;
        for(int i = 0; i < 13; i++){
            if(i == 12){
                score = 100 * (60 - raw_score)/percent_left;
                System.out.println("< 60% (" + letters[i] + "): <" + score);
            } else {
                score = 100 * (grades[i] - raw_score)/percent_left;
                System.out.println(grades[i] + "% (" + letters[i] + "): " + score);
            }
        }
        s.close();
    }

    
}