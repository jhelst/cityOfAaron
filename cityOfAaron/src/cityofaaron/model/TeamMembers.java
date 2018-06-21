package cityofaaron.model;

import java.io.Serializable;

/**
 *
 * @author jhelst, carolmadella, ramonandrade
 */ 
public enum TeamMembers implements Serializable{
	
	TeamMember1("Carolina Perez", "Student"),
	TeamMember2("Jeff Helsten", "Student"),
	TeamMember3("Ramon Andrade", "Student");
	
	private String name;
	private String title;
        
	TeamMembers(String name, String title) {
		this.name = name;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "TeamMembers [name=" + name + ", title=" + title + "]";
	}
	

}

