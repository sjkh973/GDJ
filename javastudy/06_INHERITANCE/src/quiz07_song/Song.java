package quiz07_song;

public class Song {

	private String title;
	private double playTime;
	
	public Song(String title, double playTime) {
		super();
		this.title = title;
		this.playTime = playTime;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", playTime=" + playTime + "]";
	}
	
	
}
