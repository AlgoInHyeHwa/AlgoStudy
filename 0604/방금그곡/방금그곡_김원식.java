public class Pb03 {
    static String solution(String m, String[] musicinfos) {
        String answer = "(NONE)";
        int maxPT = 0;
//        m = killSharp(m);
        m = m.replaceAll("A#", "a");
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");

        for(String s : musicinfos) {
//            s = killSharp(m);
            s = s.replaceAll("A#", "a");
            s = s.replaceAll("C#", "c");
            s = s.replaceAll("D#", "d");
            s = s.replaceAll("F#", "f");
            s = s.replaceAll("G#", "g");


            String[] st1 = s.split(",");
            String[] st2 = st1[0].split(":");
            String[] st3 = st1[1].split(":");

            int playHour = Integer.parseInt(st3[0]) - Integer.parseInt(st2[0]);
            int playMin = Integer.parseInt(st3[1]) - Integer.parseInt(st2[1]) + (playHour * 60);

            String music = makeMusic(st1[3], playMin);  // 시간만큼 재생된 멜로디를 문자열로 반환

            // 멜로디 검사
            if(music.contains(m)) {
                if (maxPT < playMin) {
                    maxPT = playMin;
                    answer = st1[2];
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

    // 변환
//    static String killSharp(String s) {
//        s = s.replaceAll("A#", "a");
//        s = s.replaceAll("C#", "c");
//        s = s.replaceAll("D#", "d");
//        s = s.replaceAll("F#", "f");
//        s = s.replaceAll("G#", "g");
//        return s;
//    }

    // 재생된 멜로디 구간
    static String makeMusic(String s, int t) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String m = "ABCDEFG";
//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        solution(m, musicinfos);
    }
}
