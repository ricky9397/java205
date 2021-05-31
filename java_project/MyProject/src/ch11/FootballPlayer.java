package ch11;

public class FootballPlayer {
	String name;
	int number;
	String team;
	int age;
	
	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof FootballPlayer)) {
			return false;
		}
		FootballPlayer f = (FootballPlayer)obj;
		return name == f.name;
	}
	
	
	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}
	
}
