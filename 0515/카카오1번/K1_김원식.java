import java.util.ArrayList;

public class Pb01 {
    static void solution(String hand, int[] numbers){
        ArrayList<Character> result = new ArrayList<>();
        int left    = 0;
        int right   = 0;
        char hands;                 // ~ 손잡이

        if(hand == "right")
            hands = 'R';
        else
            hands = 'L';

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                result.add('L');
                left = numbers[i];
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                result.add('R');
                right = numbers[i];
            }
            else if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0){
                if(Math.abs(numbers[i] - left) == 1 && Math.abs(numbers[i] - right) == 1)
                    result.add(hands);
                else if(Math.abs(numbers[i] - left) > Math.abs(numbers[i] - right))
                    result.add('R');
                else if((Math.abs(numbers[i] - left) < Math.abs(numbers[i] - right)))
                    result.add('L');
            }
        }

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i));
        }
    }

    public static void main(String[] args) {
        String hand     = "right";
        int[] numbers   = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};

        solution(hand, numbers);
    }
}
