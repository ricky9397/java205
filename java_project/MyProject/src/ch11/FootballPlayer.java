package ch11;

public class FootballPlayer implements Comparable<FootballPlayer>{
	private String name;
	private int number;
	private String team;
	private int age;
	
	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "FootballPlayer [이름=" + name + ", 번호=" + number + ", 팀이름=" + team + ", 나이=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		return age%10;
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		if(obj != null && obj instanceof FootballPlayer) {
			FootballPlayer f = (FootballPlayer)obj;
			if(this.name.equals(f.name) && this.team.equals(f.team) && this.age == f.age) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public int compareTo(FootballPlayer o) {
		int result = this.team.compareTo(o.getTeam()); // 음수 / 양수 / 0 
		if(result == 0) {
			result = this.name.compareTo(o.getName());
			if(result == 0) {
				result = this.number-o.getNumber();
			}
		}
		return result;
	}
}
