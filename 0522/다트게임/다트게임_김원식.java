public class Pb01 {
    static String[] solution(int n, int[] arr1, int[] arr2){
        String[] answer = new String[n];
        String bin1 = "";
        String bin2 = "";


        for(int i = 0; i < n; i++){
            for(int j = 0; j < arr1.length; j++){
                bin1 = Integer.toBinaryString(arr1[i]);
                for(int k = bin1.length(); k < n; k++){
                    bin1 = '0' + bin1;
                }
            }

            for(int j = 0; j < arr2.length; j++){
                bin2 = Integer.toBinaryString(arr2[i]);
                for(int k = bin2.length(); k < n; k++){
                    bin2 = '0' + bin2;
                }
            }

            answer[i] = "";

            for(int j = 0; j < n; j++){
                if(bin1.charAt(j) == '0' && bin2.charAt(j) == '0')
                    answer[i] += " ";
                else
                    answer[i] += "#";
            }

            System.out.println(answer[i]);

        }


        return answer;  // ["#####","# # #", "### #", "# ##", "#####"]
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        solution(n, arr1, arr2);
    }
}
