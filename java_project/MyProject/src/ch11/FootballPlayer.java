package ch11;

import java.util.Comparator;

public class FootballPlayer implements Comparable<FootballPlayer>{
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		if(obj != null && obj instanceof FootballPlayer) {
			FootballPlayer f = (FootballPlayer)obj;
			if(this.name == f.name && this.team == f.team && this.age == f.age) {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "FootballPlayer [이름=" + name + ", 번호=" + number + ", 팀이름=" + team + ", 나이=" + age + "]";
	}

	@Override
	public int compareTo(FootballPlayer o) {
		if(this.team.compareTo(o.team) > 0) {
			return 1;
		} else if (this.team.compareTo(o.team) < 0) {
			return -1;
		} else {
			if(this.name.compareTo(o.name) > 0) {
				return 1;
			} else if (this.name.compareTo(o.name) < 0) {
			}
			return 1;
		}
	}

}
