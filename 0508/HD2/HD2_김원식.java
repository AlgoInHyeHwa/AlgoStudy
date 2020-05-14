import java.util.ArrayList;

public class Pb02 {
    static int solution(String[] ip_addrs, String[] langs, int[] scores){
        int result  = ip_addrs.length;
        int count   = 0;
//        boolean check = false;
        
        ArrayList<Integer> arrayList = new ArrayList<>();

        /* C, C#, C++ 은 모두 같은 언어군 */
        for(int i = 0; i < langs.length; i++){
            if(langs[i] == "C" || langs[i] == "C#" || langs[i] == "C++"){
                langs[i] = "C";
            }
        }
        
        /* test */
        for(int i = 1; i < ip_addrs.length; i++){
            
            for(int j = 0; j < i; j++){
                if(ip_addrs[i] == ip_addrs[j]);                                
            }
        }

        /* ip 동일 -> arrayList 요소 0 추가 */
        for(int i = 0; i < ip_addrs.length - 1; i++){
            for(int j = i+1; j < ip_addrs.length; j++){
                if(ip_addrs[i] == ip_addrs[j]){
                        count++;
                }
            }
        }
        arrayList.add(count);
        count = 0;

        /* 언어 동일 -> arrayList 요소 1 추가 */
        for(int i=0; i < langs.length - 1; i++){
            for(int j = i+1; j < langs.length; j++){
                if(langs[i] == langs[j]){
                    count++;
                }
            }
        }
        arrayList.add(count);
        count = 0;
        /* 성적 동일 -> arrayList 요소 2 추가 */
        for(int i=0; i < scores.length - 1; i++){
            for(int j = i+1; j < scores.length; j++){
                if(scores[i] == scores[j]){
                    count++;
                }
            }
        }
        arrayList.add(count);
        
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        if(arrayList.get(0) == 4){
            result -= arrayList.get(0);
        }
        else if(arrayList.get(0) == 3 && arrayList.get(1) == 3){
            result -= arrayList.get(0);
        }
        else if(arrayList.get(0) == 2 && arrayList.get(1) == 2 && arrayList.get(2) == 2){
            result -= arrayList.get(0);
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        String[] ip_addrs   = {"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"};
        String[] langs      = {"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript"};
        int[] scores        = {294, 197, 373, 45, 294, 62, 373, 373};

        solution(ip_addrs, langs, scores);
    }
}
