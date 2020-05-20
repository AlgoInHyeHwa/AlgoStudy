import java.util.ArrayList;

public class Pb01 {
    static void solution(String hand, int[] numbers){
        ArrayList<Character> result = new ArrayList<>();
        int left_x = 0;
        int left_y = 3;
        int right_x = 2;
        int right_y = 3;
        int middle_x;
        int middle_y;
        char hands;                 // ~ 손잡이

        if(hand == "right")
            hands = 'R';
        else
            hands = 'L';

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                left_x = 0;
                if(numbers[i] == 1){
                    left_y = 0;
                }
                else if(numbers[i] == 4){
                    left_y = 1;
                }
                else if(numbers[i] == 7){
                    left_y = 2;
                }

                result.add('L');
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                right_x = 2;
                if(numbers[i] == 3){
                    right_y = 0;
                }
                else if(numbers[i] == 6){
                    right_y = 1;
                }
                else if(numbers[i] == 9){
                    right_y = 2;
                }

                result.add('R');
            }
            else if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0){
                middle_x = 1;

                if(numbers[i] == 2){
                    middle_y = 0;
                    if(Math.abs(middle_x-left_x) + Math.abs(middle_y-left_y) > Math.abs(middle_x-right_x) + Math.abs(middle_y-right_y)){
                        result.add('R');
                        right_x = middle_x;
                        right_y = middle_y;
                    }else if(Math.abs(middle_x-left_x) + Math.abs(middle_y-left_y) < Math.abs(middle_x-right_x) + Math.abs(middle_y-right_y)){
                        result.add('L');
                        left_x = middle_x;
                        left_y = middle_y;
                    }else {
                        result.add(hands);
                        switch (hands){
                            case 'R':
                                right_x = middle_x;
                                right_y = middle_y;
                                break;
                            case 'L':
                                left_x = middle_x;
                                left_y = middle_y;
                                break;
                        }
                    }
                }
                else if(numbers[i] == 5){
                    middle_y = 1;

                    if(Math.abs(middle_x-left_x) + Math.abs(middle_y-left_y) > Math.abs(middle_x-right_x) + Math.abs(middle_y-right_y)){
                        result.add('R');
                        right_x = middle_x;
                        right_y = middle_y;
                    }else if(Math.abs(middle_x-left_x) + Math.abs(middle_y-left_y) < Math.abs(middle_x-right_x) + Math.abs(middle_y-right_y)){
                        result.add('L');
                        left_x = middle_x;
                        left_y = middle_y;
                    }else {
                        result.add(hands);
                        switch (hands){
                            case 'R':
                                right_x = middle_x;
                                right_y = middle_y;
                                break;
                            case 'L':
                                left_x = middle_x;
                                left_y = middle_y;
                                break;
                        }
                    }
                }
                else if(numbers[i] == 8){
                    middle_y = 2;

                    if(Math.abs(middle_x-left_x) + Math.abs(middle_y-left_y) > Math.abs(middle_x-right_x) + Math.abs(middle_y-right_y)){
                        result.add('R');
                        right_x = middle_x;
                        right_y = middle_y;
                    }else if(Math.abs(middle_x-left_x) + Math.abs(middle_y-left_y) < Math.abs(middle_x-right_x) + Math.abs(middle_y-right_y)){
                        result.add('L');
                        left_x = middle_x;
                        left_y = middle_y;
                    }else {
                        result.add(hands);
                        switch (hands){
                            case 'R':
                                right_x = middle_x;
                                right_y = middle_y;
                                break;
                            case 'L':
                                left_x = middle_x;
                                left_y = middle_y;
                                break;
                        }
                    }
                }
                else if(numbers[i] == 0){
                    middle_y = 3;

                    if(Math.abs(middle_x-left_x) + Math.abs(middle_y-left_y) > Math.abs(middle_x-right_x) + Math.abs(middle_y-right_y)){
                        result.add('R');
                        right_x = middle_x;
                        right_y = middle_y;
                    }else if(Math.abs(middle_x-left_x) + Math.abs(middle_y-left_y) < Math.abs(middle_x-right_x) + Math.abs(middle_y-right_y)){
                        result.add('L');
                        left_x = middle_x;
                        left_y = middle_y;
                    }else {
                        result.add(hands);
                        switch (hands){
                            case 'R':
                                right_x = middle_x;
                                right_y = middle_y;
                                break;
                            case 'L':
                                left_x = middle_x;
                                left_y = middle_y;
                                break;
                        }
                    }
                }
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
