class Solution {
    public String solution(String m, String[] musicinfos) {
		String answer = "";

		String[] music = {};

		for (String s : musicinfos) {
			music = s.split(",");

			String start[] = music[0].split(":");
			String end[] = music[1].split(":");

			String name = music[2];
			String melody = music[3];

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
			
			if(song.contains(melody)) {
				answer = name;
				break;
			}
		}

		return answer;
    }
}
