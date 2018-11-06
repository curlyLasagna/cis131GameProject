package blackJackExtreme;
public class Player {
    
    private String name;
    private String password; 
    private int wins; 
    private int classicRounds;
    private int fnRounds;
    private int nBJRounds;
    private int ffRounds;
    private int bJCount;
    private int creditsEarned;
    private int creditsLost;
    private int highestCredits;
    private int bankRuptcies;
    private String currency; 
    private char[] suiteIcons;
    
    public Player() { 
        //no-arg constructor        
    }
   
    public Player(String name, String password, int wins, int classicRounds, int fnRounds,
			int nBJRounds, int ffRounds, int bJCount, int creditsEarned, int creditsLost, int highestCredits,
			int bankRuptcies) {
		super();
		this.name = name;
		this.classicRounds = classicRounds;
		this.fnRounds = fnRounds;
		this.nBJRounds = nBJRounds;
		this.ffRounds = ffRounds;
		this.bJCount = bJCount;
		this.creditsEarned = creditsEarned;
		this.creditsLost = creditsLost;
		this.highestCredits = highestCredits;
		this.bankRuptcies = bankRuptcies;
	}

	public String getPassword() {
		return password;
	}

	public String getName(){
       		 return name;
   	 }

	public int getClassicRounds() {
		return classicRounds;
	}

	public int getFnRounds() {
		return fnRounds;
	}

	public int getnBJRounds() {
		return nBJRounds;
	}

	public int getFfRounds() {
		return ffRounds;
	}

	public int getbJCount() {
		return bJCount;
	}

	public int getCreditsEarned() {
		return creditsEarned;
	}

	public int getCreditsLost() {
		return creditsLost;
	}

	public int getHighestCredits() {
		return highestCredits;
	}

	public int getBankRuptcies() {
		return bankRuptcies;
	}
}
