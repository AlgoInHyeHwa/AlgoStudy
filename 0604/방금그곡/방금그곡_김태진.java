class Solution {
    private String mMusic(String s, int t){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++)
            sb.append(s.charAt(i % s.length()));
        return sb.toString();
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPt = 0;
        m = m.replaceAll("A#", "a");
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        for(String s : musicinfos){
            s = s.replaceAll("A#", "a");
            s = s.replaceAll("C#", "c");
            s = s.replaceAll("D#", "d");
            s = s.replaceAll("F#", "f");
            s = s.replaceAll("G#", "g");
            String[] arr1 = s.split(",");
            String[] arr2 = arr1[0].split(":");
            String[] arr3 = arr1[1].split(":");
            int hour = Integer.parseInt(arr3[0]) - Integer.parseInt(arr2[0]);
            int min = Integer.parseInt(arr3[1]) - Integer.parseInt(arr2[1]) + (hour * 60);
            
            String music = mMusic(arr1[3], min);
            
            if(music.contains(m)){
                if(maxPt < min){
                    maxPt = min;
                    answer = arr1[2];
                }
            }
        }
        return answer;
    }
}