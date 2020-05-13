import java.util.Scanner;

public class Pb01 {
    static int[] solution(String[] purchase, int[] days){
        int[] grade = new int[5];                   // [브론즈, 실버, 골드, 플레티넘, 다이아]
        int[] price = new int [purchase.length];    // 구매 금액
        int[][] date = new int[purchase.length][2];     // 월/일 단위 저장
        int[] allPur = new int[365];                // 해당 일의 총 구매가격 = 이것으로 등급 산정

        for(int i = 0; i < price.length; i++){
            String[] pur = purchase[i].split(" ");
            String[] d   = pur[0].split("/");          // ex) 20190101

            date[i][0] = Integer.parseInt(d[1]);    // 월
            date[i][1] = Integer.parseInt(d[2]);    // 일

            price[i] = Integer.parseInt(pur[1]);
        }

        // 반복문 조건 다시보기!!
        for(int i = 0; i < price.length; i++){
            if(date[i][0]==1){      // 1월
                for(int j = date[i][1]-1; j < date[i][1]-1+30; j++) {
                    allPur[j] += price[i];
                }
            }else {
                for(int j = 0; j < date[i][0]-1; j++) {
                    date[i][1] += days[j];
                }

                for(int j = date[i][1]-1; j < date[i][1]-1+30; j++) {
                    allPur[j] += price[i];
                }
            }
        }

        /* 구매금액에 따라 배열 요소 값 1씩 증가 = 등급 유지기간 */
        for(int i = 0; i < allPur.length; i++) {
            if(0 <= allPur[i] && allPur[i] < 10000) {
                grade[0]++;
            }
            else if(10000 <= allPur[i] && allPur[i] < 20000) {
                grade[1]++;
            }
            else if(20000 <= allPur[i] && allPur[i] < 50000) {
                grade[2]++;
            }
            else if(50000 <= allPur[i] && allPur[i] < 100000) {
                grade[3]++;
            }
            else {
                grade[4]++;
            }
        }

        /* 등급 출력 */
        for(int i = 0; i<grade.length; i++){
            System.out.println(grade[i]+" ");
        }

        return grade;
    }

    public static void main(String[] args) {

//        String[] purchase = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
        String[] purchase = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        solution(purchase, days);
    }
}
