package pojos;

public enum Course {
	DAC(80),DBDA(50),DITTIS(50);
	private int minMarks;
	
	private Course(int minMarks) {
		this.minMarks = minMarks;
	}
	
	public int getMarks() {
		return this.minMarks;
	}
}
