public class Pb03 {
    static String solution(String m, String[] musicinfos) {
        String answer = "(NONE)";
        int maxPT = 0;

        for(String s : musicinfos) {
            s = s.replace("A#", "a");
            s = s.replace("C#", "c");
            s = s.replace("D#", "d");
            s = s.replace("F#", "f");
            s = s.replace("G#", "g");

            String[] st1 = s.split(",");
            String[] st2 = st1[0].split(":");
            String[] st3 = st1[1].split(":");

            int playHour = Integer.parseInt(st3[0]) - Integer.parseInt(st2[0]);
            int playMin = Integer.parseInt(st3[1]) - Integer.parseInt(st2[1]) + (playHour * 60);

            String music = makeMusic(st1[3], playMin);

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

    static String makeMusic(String s, int t) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        solution(m, musicinfos);
    }
}
