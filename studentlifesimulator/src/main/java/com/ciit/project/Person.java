package com.ciit.project;

public class Person {
	private String name;
	private int energy = 10;
	private int stress = 0;
	private Project project;
	
	
	private int hoursTaken = 0;
	
	public int getHoursTaken() {
		return hoursTaken;
	}

	public void setHoursTaken(int hoursTaken) {
		this.hoursTaken = hoursTaken;
	}

	//---------------------------------------
	//-----------OTHER METHODS---------------
	//---------------------------------------
	public void statLimitCheck() {
		//following code makes sure your stats dont go greater than 10 or less than 0
		if (this.energy < 0) {
			this.energy = 0; //less than 0 kasi 0 is minimum stat
		} else if (this.energy > 10) {
			this.energy = 10; //greater than 10 kasi 10 is max stat
		}
		
		if (this.stress < 0) {
			this.stress = 0;
		} else if (this.stress > 10) {
			this.stress = 10;
		}

		if (this.project.getProgress() < 0) {
			project.setProgress(0);
			
		} else if (this.project.getProgress() > 20) {
			project.setProgress(20);
		}
		//this code is untested, needs more testing
	}
	
	public void doHobbies() {

		if (hoursTaken >= 1 && hoursTaken <= 3) { //1-3 hours
			System.out.println("You did your hobbies! "
					+ "\nIt only took you an hour or two or three but you definitely feel less stressed than you started with! "
					+ "\nLooks like its a great time to do something else :)");
		} else if (hoursTaken >= 4 && hoursTaken <= 6) { //4-6 hours
			System.out.println("You happily did your hobbies! "
					+ "\nBut somehow, you blinked and what? Four to six hours already passed? "
					+ "\nWow, time goes by when you're enjoying yourself huh! You're a lot happier, less stressed, but also a little tired...");
		} else if (hoursTaken >= 7 && hoursTaken <= 9) { //7-9 hours
			System.out.println("Eurgh.. holy cr*p, how long has it been? Seven to nine hours? Were you supposed to have fun for this long? \r\n"
					+ "\r\n"
					+ "...well, you definitely feel less stressed, but you haven't moved in a bit and you feel like you're about to fossilise."
					+ "\nYou definitely feel a little more tired.");
		} else if (hoursTaken >= 10 && hoursTaken <= 12) { //10-12 hours
			System.out.println("Girl chill. 10 to 12 hours yarn? Sino ka dyan? "
					+ "\nGo check with your doctor, it might be an addiction or an obsessive disorder.\r\n"
					+ "\r\n"
					+ "You might as well become a statue with how long you've been doing the same thing.");
		}

		
			
			System.out.println("");
			System.out.println("\n--------------------");
			
	}
	
	public void sleep() {

		if (hoursTaken >= 1 && hoursTaken <= 3) { //1-3 hours
			System.out.println("You took what some would call a 'power nap'. Consider sleeping a little longer lest you faint from fatigue. Don't forget to do your project :)");
		} else if (hoursTaken >= 4 && hoursTaken <= 6) { //4-6 hours
			System.out.println("Rise and Shine! Did you know successful entrepreneurs claim they sleep for only 4 to 6 hours a day? Maybe by copying them, you'll also become successful?");
		} else if (hoursTaken >= 7 && hoursTaken <= 9) { //7-9 hours
			System.out.println("Rise and shine, sleepyhead! You had a perfect 7 to 9 hours of sleep. It's a beautiful day to touch grass, or better yet, your project.");
		} else if (hoursTaken >= 10 && hoursTaken <= 12) { //10-12 hours
			System.out.println("Great talent! If sleeping was an olympic sport, you'd be an olympian several times over! :D");
		}

		
		System.out.println("");
		System.out.println("\n--------------------");
	}
	
	public void eat() {

		if (hoursTaken >= 1 && hoursTaken <= 3) { //1-3 hours
			System.out.println("You're part of the majority who actually cooks, and actually takes time to prepare your food. "
					+ "\nYou believe in the saying that food is life, but Instagram is lifer.");
		} else if (hoursTaken >= 4 && hoursTaken <= 6) { //4-6 hours
			System.out.println("Eating is good for your body, but eating too much will make your stomach suffer later. "
					+ "\nYou ate for a while, and feel the beginnings of a stomachache...");
		} else if (hoursTaken >= 7 && hoursTaken <= 9) { //7-9 hours
			System.out.println("Oh wow you can eat for like 7 to 9 hours? I know eating is fun but groceries are expensive these days, don't you know? "
					+ "\nWill the stuff in your fridge even be enough?");
		} else if (hoursTaken >= 10 && hoursTaken <= 12) { //10-12 hours
			System.out.println("Eating for ten to twelve hours straight....... really, how talented. Are you trying to bulk up to become the new loser rookie?");
		}

		
		System.out.println("");
	}
	
	public void talkToPeople() {

		if (hoursTaken >= 1 && hoursTaken <= 3) { //1-3 hours
			System.out.println("You're happily conversing with friends. The conversation is all over the place and going too fast. No topics are connected and you guys don't make sense for the most part. \r\n"
					+ "\r\n"
					+ "Still, the fun goes by too quickly and leaves you craving for more. Maybe.... it won't hurt to mess around a few more hours?");
		} else if (hoursTaken >= 4 && hoursTaken <= 6) { //4-6 hours
			System.out.println("Conversation is chill. You and your friends decided to hang out and spend time together. You chat over snacks and tv shows and it's fun. \r\n"
					+ "\r\n"
					+ "Oh, your project? Who cares? You still have enough time. A little messing around with your friends won't hurt, right?");
		} else if (hoursTaken >= 7 && hoursTaken <= 9) { //7-9 hours
			System.out.println("There are multiple dead airs where you and your friends loose the topic entirely. One of them has taken over the T.V. and honestly you can only watch so much Princess Bride replays.\r\n"
					+ "\r\n"
					+ "Multiple times, you find yourself staring at the wall or even the ceiling to pass the time. You really should get rid of that spider living in the upper left corner of your living room. ");
		} else if (hoursTaken >= 10 && hoursTaken <= 12) { //10-12 hours
			System.out.println("You chilled with your friends for nearly half a day. You like them, but not that much. There are multiple dead airs until someone busted out some card game. You have no clue what's happening, but while you're having fun, you're also really tired.\r\n"
					+ "\r\n"
					+ "Do you even have enough time to work on your project? Oh well. Who cares? Obviously, not you, since you socialised for half the day HAHAHAHA");
		}

		
		System.out.println("");
	}

	
	//---------------------------------------
	//---------------GETTERS-----------------
	//---------------------------------------
	public String getName() {
		return name;
	}

	public int getEnergy() {
		return energy;
	}

	public int getStress() {
		return stress;
	}

	public Project getProject() {
		return project;
	}
	
	//---------------------------------------
	//--------------SETTERS------------------
	//---------------------------------------
	public void setName(String name) {	
		this.name = name;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public void setStress(int stress) {
		this.stress = stress;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
}
