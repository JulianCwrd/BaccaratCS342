
public class Card {
	private String suite;
	private int value;
	
	
	//two argument constructor
	Card(String theSuite, int theValue){
		this.suite = theSuite;
		this.value = theValue;
	}
	
//	public int getValue() {
//		return this.value;
//	}
	
	public String getSuite() {
		return this.suite;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setSuite(String suite) {
		this.suite = suite;
	}
	
	public int getValue() {
		return value;
	}

	
	
}
