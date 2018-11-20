package blackJackExtreme;
public class Player {
    
    private String name;
    private String password; 
    private int wins; 
    private int extremeRounds;
    private int fnRounds;
    private int nBJRounds;
	private int ffRounds;
    private int bJCount;
	private int creditsEarned;
    private int creditsLost;
    private int highestCredits;
    private int bankRuptcies;
    private String currency; 
   
    
    public Player() { 
        //no-arg constructor        
    }
   
    public Player(String name, String password, int wins, int extremeRounds, int fnRounds,
			int nBJRounds, int ffRounds, int bJCount, int creditsEarned, int creditsLost, int highestCredits,
			int bankRuptcies, String currency) {
		
		this.name = name;
		this.password = password;
		this.wins = wins; 
		this.extremeRounds = extremeRounds;
		this.fnRounds = fnRounds;
		this.nBJRounds = nBJRounds;
		this.ffRounds = ffRounds;
		this.bJCount = bJCount;
		this.creditsEarned = creditsEarned;
		this.creditsLost = creditsLost;
		this.highestCredits = highestCredits;
		this.bankRuptcies = bankRuptcies;
		this.currency = currency;
	}

	public String getPassword() {
		return password;
	}

	public String getName(){
       		 return name;
   	}

	public int getExtremeRounds() {
		return extremeRounds;
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
	
	public int getWins() {
		return wins;
	}

	public String getCurrency() {
		return currency;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public void setExtremeRounds(int extremeRounds) {
		this.extremeRounds = extremeRounds;
	}

	public void setFnRounds(int fnRounds) {
		this.fnRounds = fnRounds;
	}

	public void setnBJRounds(int nBJRounds) {
		this.nBJRounds = nBJRounds;
	}

	public void setFfRounds(int ffRounds) {
		this.ffRounds = ffRounds;
	}

	public void setbJCount(int bJCount) {
		this.bJCount = bJCount;
	}

	public void setCreditsEarned(int creditsEarned) {
		this.creditsEarned = creditsEarned;
	}

	public void setCreditsLost(int creditsLost) {
		this.creditsLost = creditsLost;
	}

	public void setHighestCredits(int highestCredits) {
		this.highestCredits = highestCredits;
	}

	public void setBankRuptcies(int bankRuptcies) {
		this.bankRuptcies = bankRuptcies;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
