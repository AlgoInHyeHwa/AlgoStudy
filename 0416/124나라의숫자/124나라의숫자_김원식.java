class Solution {
  public String solution(int n) {
      String answer = "";
      int x = 0;
      
      /* test1 */
      // int sum;
      // int x = 0;    // 10의 자리
      // int y = 0;    // 1의 자리

      /* test2 */
      while(n > 0)
      {
          x = n%3;
          n = n/3;
          
          if(x == 0){   // 10의 자리 바뀌는 경우
              n -= 1;
              x = 4;
          }
          
          answer = x + answer;
      }
      
      /* test 1 */
      // switch(n%3){
      //     case 0:
      //         x = ((n / 3)-1) * 10;
      //         y = 4;
      //         break;
      //     case 1:
      //         x = (n / 3)*10;
      //         y = 1;
      //         break;
      //     case 2:
      //         x = (n / 3)*10;
      //         y = 2;
      //         break;
      // }
      // sum = x + y;
      // answer = "" + sum;
      
      return answer;
      }
  }
