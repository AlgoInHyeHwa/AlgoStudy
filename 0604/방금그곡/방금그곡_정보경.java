class Solution {
    public static String solution(String m, String[] musicinfos) {
		String answer = "(None)";
        int longTime = 0;
		String[] music = {};

		m = m.replace("C#", "c");
		m = m.replace("D#", "d");
		m = m.replace("F#", "f");
		m = m.replace("G#", "g");
		m = m.replace("A#", "a");
		m = m.replace("E#", "e");

		for (String s : musicinfos) {

			music = s.split(",");

			String start[] = music[0].split(":");
			String end[] = music[1].split(":");

			String name = music[2];
			String melody = music[3];

			melody = melody.replace("C#", "c");
			melody = melody.replace("D#", "d");
			melody = melody.replace("F#", "f");
			melody = melody.replace("G#", "g");
			melody = melody.replace("A#", "a");
			melody = melody.replace("E#", "e");

			int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
			int time = Integer.parseInt(end[1]) - Integer.parseInt(start[1]) + (hour * 60);

			String song = "";

			
			
			while (true) {
				for(int i=0; i<melody.length(); i++) {
					if(time == song.length()){
						break;
					}
					song += Character.toString(melody.charAt(i));
				}
				if(time == song.length()) {
					break;
				}
			}

			if (song.contains(m)) {
				if (longTime < time) {
					longTime = time;
					answer = name;
				}
			}

		}

		return answer;
    }
}
