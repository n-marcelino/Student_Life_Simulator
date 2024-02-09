package com.ciit.project;
import java.util.ArrayList;
import java.io.IOException;
import java.util.*;

public class Program {

	static int days = 7;
	static int hoursLeft = 24;
	static Boolean[] wasCheckpointMet = {false,false,false,false,false};
	static Player p = new Player();
	static Project proj = new Project();
	

	public static void main(String[] args) {
		game();
	}
	
	//MAIN GAME METHOD
	
	public static void game() {
		//constructing the player and project object
		p.setProject(proj);
		
		//setting all stats to default values
		p.setEnergy(10);
		p.setStress(0);
		p.getProject().setProgress(0);
		
		
		Scanner in = new Scanner(System.in);
		
		//THIS IS WHERE THE GAME BEGINS
		//launches intro (title/instructions) and making the character (putting values to player object's attributes)
		launchIntroduction();
		makeCharacter(p);		
		
		//THIS IS THE START OF THE ACTUAL GAME
		System.out.println("------------------------------------------------------");
		System.out.println("---------------------GAME START-----------------------");
		System.out.println("------------------------------------------------------");
		
		//for loop that runs for 7 days
		//each day is a while loop that runs for as long as there are still 24 hours left
		for (int i=1; i <= days; i++) {			
			System.out.println("\n-------------------------------------");
			System.out.println("TODAY IS DAY " + i);
			System.out.println("-------------------------------------");
			while (hoursLeft > 0) {
				//game code bundled into methods at the bottom of main method
				//basically, show stats -> check for progress -> choose your action
				viewMyStats(p); 	//displays player stats at the beginning of every action
				choiceMenu(p);		// where the player can choose what they want to do
									//actions take up hours
				checkpoint(p); 		//checks if there has been a progress in points, checks for specific checkpoints: 1/5/10/15/20
				//this ist he code that uses arraylist
			}
			
			hoursLeft = 24; //every time the while loop ends, hoursLeft is reset back to 24
		}
		
		endGame(p);
	}
	
	//------------------------------------------------------------
	//-----These methods contain main functionalities of game-----
	//------------------------------------------------------------
	
	public static void launchIntroduction() {
		Scanner in = new Scanner(System.in);
		System.out.println("------------------------------------------------------");
		System.out.println("---------------------7 DAYS LEFT----------------------");
		System.out.println("------------------------------------------------------");
		System.out.println("\nYou have 24 hours in a day, and there's only a week left till the deadline of your project. You haven't even gotten started yet.\r\n"
				+ "Do your project within the next seven days, or don't. It's up to you.");
		
		pressEnterToContinue();
		
		System.out.println("------------------------------------------------------");
		System.out.println("---------------------HOW TO PLAY?---------------------");
		System.out.println("------------------------------------------------------");
		System.out.println("You have 7 DAYS and 24 HOURS each day.\r\n"
				+ "\nYou have three stats you need to balance: \n1.ENERGY, \n2.STRESS, and \n3.PROJECT PROGRESS.");
		
		pressEnterToContinue();
		
		System.out.println("You can choose to do two kinds of actions: SELF-CARE or ACADEMICS.");
		
		pressEnterToContinue();
		
		System.out.println("Your goal is to reach 20 PPROJECT PROGRESS points.\r\n"
				+ "You can get PROGRESS points by doing ACADEMIC actions.\r\n"
				+ "However, your STRESS will rise whenever you do ACADEMIC actions.\r\n"
				+ "Your energy will also decrease if you choose to focus only on academics.");
		
		pressEnterToContinue();
		
		System.out.println("You can replenish your energy and decrease your STRESS by doing SELF-CARE actions.");
		System.out.println("However, take note that once your ENERGY or STRESS reaches certain numbers, you would be blocked from performing certain actions.");
		
		pressEnterToContinue();
	}
	
	public static void makeCharacter(Player p) {
		//TODO find a way to add a working verification; like "ur name is x and ur project name is y, is that right? y/n
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("------------------------------------------------------");
		System.out.println("-----------------CHARACTER CREATION-------------------");
		System.out.println("------------------------------------------------------");
		
		System.out.println("\nWhat is your name?");
		
		while(true) {
			System.out.print("INPUT: ");
			p.setName(in.nextLine());
			
			if (p.getName() == " " || p.getName() == "") {
				System.out.println("Please enter a valid name.");
			} else break;
		}
		System.out.println("\nWhat is your project name?");
		
		while(true) {
			System.out.print("INPUT: ");
			p.getProject().setProjectName(in.nextLine());
			
			if (p.getProject().getProjectName() == " " || p.getProject().getProjectName() == "") {
				System.out.println("Please enter a valid project name.");
			} else break;
		}
		
		
		System.out.println("\nYour name is " + p.getName() + " and your project's title is \"" + p.getProject().getProjectName() + "\"!");
		
		pressEnterToContinue();
		
	}
	
	public static void choiceMenu(Player p) {
		Scanner in = new Scanner(System.in);
		int choice = 0;
		int choiceSelfCare = 0;
		int choiceAcad = 0;
		int hoursTaken = 0;
		Boolean doesMeetStat = true;
		
		System.out.println("\nChoose your actions!\n"
				+"[1] SELF CARE ACTION\n" 
				+"[2] ACADEMIC ACTION\n"
				+"[3] CHECK MY PROJECT");
		System.out.print("INPUT: ");
		try {
			choice = in.nextInt();
		} catch (Exception e) {
			System.out.println("Please input only numbers.");
		}
	
		switch(choice) {
		
		  //------------- SELF-CARE ACTIONS start -------------
		  case 1:
		    System.out.println("\nSELF CARE ACTIONS.");
		    System.out.println("You've chosen to prioritise yourself today! Anything specific you want to do?\n"
    				+"[1] Sleep\n" 
    				+"[2] Eat\n"
    				+"[3] Socialize\n"
    				+"[4] Do your hobbies");
		   
		    System.out.print("INPUT: ");
		    try {
		    	choiceSelfCare = in.nextInt();
			} catch (Exception e) {
				System.out.println("Please only enter the numbers of valid choices.");
				System.out.println("\n--------------------");
    			choiceMenu(p);
			}
		    
			if (choiceSelfCare >= 1 && choiceSelfCare <=4) {
				System.out.println("\nGreat choice!");
				System.out.println("How many hours would you like to consume doing this action? (in numbers; max of 12)");
				
				System.out.print("INPUT: ");
				try {
					hoursTaken = in.nextInt();
				} catch (Exception e) {
					System.out.println("Please only enter numbers.");
					System.out.println("\n--------------------");
				}
				
				if (!(hoursTaken <= 12)) {
					System.out.println("Please enter only up to 12 hours.");
					System.out.println("\n--------------------");
	    			choiceMenu(p);
				}
			}
			
		    	switch(choiceSelfCare) {
		    	
		    		case 1: //sleeping; no stat check bc its purely + energy
		    			System.out.println("\nYou spent " + hoursTaken + " hours doing this action.\n");
		    			p.sleep(hoursTaken);
		    			hoursLeft = hoursLeft - hoursTaken;
		    			pressEnterToContinue();
		    			break;
		    		case 2: //eating; no stat check bc its purely + energy
		    			System.out.println("\nYou spent " + hoursTaken + " hours doing this action.\n");
		    			p.eat(hoursTaken);
		    			hoursLeft = hoursLeft - hoursTaken;
		    			pressEnterToContinue();
		    			break;
		    		
		    		case 3: //talking to ppl
		    			
		    			doesMeetStat = statCheck(p, 3);
		    			if (doesMeetStat == true) {
		    				System.out.println("\nYou spent " + hoursTaken + " hours doing this action.\n");
		    				p.talkToPeople(hoursTaken);
			    			hoursLeft = hoursLeft - hoursTaken;
			    			pressEnterToContinue();
		    			}
		    			break;
		    		case 4: //doing hobbies
		    			doesMeetStat = statCheck(p, 3);
		    			if (doesMeetStat == true) {
		    				System.out.println("\nYou spent " + hoursTaken + " hours doing this action.\n");
		    				p.doHobbies(hoursTaken);
			    			hoursLeft = hoursLeft - hoursTaken;
			    			pressEnterToContinue();
		    			}
		    			break;
		    		default:
		    			System.out.println("Invalid action, please enter only the valid numbers. "); //edit message
		    			pressEnterToContinue();
		    			
		    			System.out.println("\n--------------------");
		    			choiceMenu(p);
		    			break;
		    	}
		    break;
		  //------------- SELF-CARE ACTIONS end -------------
		    
		  //------------- ACADEMIC ACTIONS start -------------
		  case 2:
			  
			System.out.println("\nACADEMIC ACTIONS");
		    System.out.println("You've chosen to do your project today, despite the stresses it gave you. Anything specific you want to do?\n"
    				+"[1] Work on your Project\n" 
    				+"[2] Meet up with your Groupmates\n"
    				+"[3] Schedule a consultation with your professor\n"
    				+"[4] Submit your Project");
		    
		    System.out.print("INPUT: ");
		    try {
		    	choiceAcad = in.nextInt();
			} catch (Exception e) {
				System.out.println("Please only enter the numbers of valid choices.");
				System.out.println("\n--------------------");
			}
		    
		    if (choiceAcad != 4 && (choiceAcad >= 1 && choiceAcad <=4)) { 
		    	//if choiceAcad is not the submitProject, then give a choice for hours
		    	System.out.println("\nGreat choice!");
				System.out.println("How many hours would you like to consume doing this action? (in numbers; max of 12)");
				
				System.out.print("INPUT: ");
				try {
					hoursTaken = in.nextInt();
				} catch (Exception e) {
					System.out.println("Please only enter numbers.");
					System.out.println("\n--------------------");
				}
				
				//checks if hoursTaken is only up to 12 hours
				if (!(hoursTaken <= 12)) {
					System.out.println("Please enter only up to 12 hours.");
					System.out.println("\n--------------------");
	    			choiceMenu(p);
				}
				
		    }
		    
		    switch(choiceAcad) {
	    	
		    	case 1: //WORK ON YOUR PROJECT
		    		doesMeetStat = statCheck(p, 1);
		    		if (doesMeetStat == true) {
		    			System.out.println("\nYou spent " + hoursTaken + " hours doing this action.\n");
		    			p.workOnProject(hoursTaken);
			   			hoursLeft = hoursLeft - hoursTaken;
			   			pressEnterToContinue();
		    		}
		    		break;
    		
		    	case 2: //MEET UP W UR GROUPIES
		    		doesMeetStat = statCheck(p, 1);
		    		if (doesMeetStat == true) {
		    			System.out.println("\nYou spent " + hoursTaken + " hours doing this action.\n");
		    			p.meetWithGroup(hoursTaken);
			   			hoursLeft = hoursLeft - hoursTaken;
			   			pressEnterToContinue();
		    		}
		    		break;
    			case 3: //CONSULT W UR PROF
		    		doesMeetStat = statCheck(p, 1);
		    		if (doesMeetStat == true) {
		    			System.out.println("\nYou spent " + hoursTaken + " hours doing this action.\n");
		    			p.consultProf(hoursTaken);
			    		hoursLeft = hoursLeft - hoursTaken;
			    		pressEnterToContinue();
		    		}
		    		break;
    		
		    	case 4:
		   			submitProject(p);
		   			break;
		   		default:
		   			System.out.println("Invalid action, please enter only the valid choices. ");
	    			pressEnterToContinue();
		    			
	    			System.out.println("\n--------------------");
	    			choiceMenu(p);
	    			break;
		    	}
		    break;
		  //------------- ACADEMIC ACTIONS end -------------
		  
		  //------------- MY PROJECT start -------------
		  case 3: 
			  checkMyProject(p);
			  break;
		  //------------- MY PROJECT end -------------
			  
		  default:
			System.out.println("Invalid action, please enter only the valid choices. ");
			pressEnterToContinue();
			
			System.out.println("\n--------------------");
			choiceMenu(p);
			break;
		}
	}
	
	public static void viewMyStats(Player p) {
		System.out.println("\nYou have " + hoursLeft + " hours left.");
		System.out.println("Energy: " + p.getEnergy() + "/10");
		System.out.println("STRESS: " + p.getStress() + "/10");
		System.out.println("PROGRESS: " + p.getProject().getProgress() + "/20");

		pressEnterToContinue();
		System.out.println("--------------------");
	}
		
	public static void checkMyProject(Player p) {
		System.out.println("\n--------------------");
		System.out.println("\nMY PROJECT");
		System.out.println("Project: " + p.getProject().getProjectName());
		System.out.println("Submitted by " + p.getName());
		
		System.out.println("\nProject Progress: " + p.getProject().getProgress() + "/20");
		System.out.println("Project Components: "); 
		
		if (p.getProject().getComponents().isEmpty() != true) {
			//insert array list 
			for(int i = 0; i < p.getProject().getComponents().size(); i++) {
				//prints out a numbered list of project components
				System.out.println((i+1) + ". " + p.getProject().getComponents().get(i));
			}
		} else {
			System.out.println("You currently don't have any project components. Higher progress points allow you to make more components.");
		}
		
		pressEnterToContinue();
		System.out.println("--------------------\n");
		
	}

	public static void checkpoint (Player p) {
		int checkpoint = p.getProject().getProgress();
		Scanner in = new Scanner(System.in);
		
		//A BUNCH OF IF STATEMENTS, BC WE NEED TO CEHCK FOR EVERYTHING
		if (checkpoint >= 1 && checkpoint <= 4 && wasCheckpointMet[0]==false) {
			//CHECKS FOR THE CHECKPOINT OF 1/20
			
			System.out.println("\n--------------------");
			System.out.println("\nCongratulations! You've hit your first checkpoint of 1/20 progress points!");
			System.out.println("The finish line is still faraway, but walking or running will take you there regardless.");
			
			pressEnterToContinue();
			
			System.out.println("\nTo celebrate your first progress point, you can add a new COMPONENT to your project.");
			System.out.println("Components can be anything you want them to be.");
			System.out.println("Popular choices are things like 'introduction', 'methodology', 'conlusion', and etc.");
			
			pressEnterToContinue();
			
			System.out.println("\nWhat do you want your new component to be?");
			System.out.print("INPUT: ");
			p.getProject().getComponents().add(0, in.nextLine());
			
			pressEnterToContinue();
			System.out.println("\n--------------------");
			wasCheckpointMet[0] = true;
			
		}
		
		if (checkpoint >= 5 && checkpoint <= 9 && wasCheckpointMet[1]==false) {
			//CHECKS FOR THE CHECKPOINT OF 5/20
			System.out.println("\n--------------------");
			System.out.println("\nCongratulations! You've hit your second checkpoint of 5/20 progress points!");
			System.out.println("\nMartin Luther King, Jr. once said \"Out of the mountain of despair, a stone of hope.\""
					+ "\nThe mountain is your project, despair is stress, and a stone of hope is progress."
					+ "\nContinue working hard!");
			//insert quote
			pressEnterToContinue();
			
			System.out.println("\nWhat do you want your new component to be?");
			System.out.print("INPUT: ");
			p.getProject().getComponents().add(1, in.nextLine());
			
			pressEnterToContinue();
			System.out.println("\n--------------------");
			wasCheckpointMet[1] = true;
			
		}
		
		if (checkpoint >= 10 && checkpoint <=14 && wasCheckpointMet[2]==false) {
			//CHECKS FOR THE CHECKPOINT OF 10/20
			System.out.println("\n--------------------");
			System.out.println("\nCongratulations! You've hit your third checkpoint of 10/20 progress points!");
			System.out.println("\nJohn Wooden said, \"Don't let what you cannot do interfere with what you can do.\""
					+ "\nDon't compare yourself to others. What matters is that you're working on your project, and them on theirs.");
			
			pressEnterToContinue();
			
			System.out.println("\nWhat do you want your new component to be?");
			System.out.print("INPUT: ");
			p.getProject().getComponents().add(2, in.nextLine());
			
			pressEnterToContinue();
			System.out.println("\n--------------------");
			wasCheckpointMet[2] = true;
			
		}
		
		if (checkpoint >=15 && checkpoint <= 19 && wasCheckpointMet[3]==false) {
			//CHECKS FOR THE CHECKPOINT OF 15/20
			System.out.println("\n--------------------");
			System.out.println("\nCongratulations! You've hit your fourth checkpoint of 15/20 progress points!");
			System.out.println("\nTheodore Roosevelt said, \"Believe you can and you're halfway there.\""
					+ "\nYou're nearly at the finish line, continue to work hard!");
			
			pressEnterToContinue();
			
			System.out.println("\nWhat do you want your new component to be?");
			System.out.print("INPUT: ");
			p.getProject().getComponents().add(3, in.nextLine());

			pressEnterToContinue();
			System.out.println("\n--------------------");
			wasCheckpointMet[3] = true;
			
		}
		
		if (checkpoint == 20 && wasCheckpointMet[4]==false) {
			//CHECKS FOR THE CHECKPOINT OF 20/20
			System.out.println("\n--------------------");
			System.out.println("\nCongratulations! You've hit your final checkpoint of 20/20 progress points!");
			System.out.println("\nYour project is like mango float. It has layers. Even if you make it wrong, "
					+ "even if it's not the best, and your mango float turns out weird, then who cares? "
					+ "\nYou've got mango float, and that's all that matters.");
			
			pressEnterToContinue();
			
			System.out.println("What do you want your component to be?");
			System.out.print("INPUT: ");
			p.getProject().getComponents().add(4, in.nextLine());
			
			pressEnterToContinue();
			System.out.println("\n--------------------");
			wasCheckpointMet[4] = true;
		}
	}

	public static void submitProject(Player p) {
		Scanner in = new Scanner(System.in);

		if (p.getProject().getProgress() != 20) { // checks if user has achieved 20 progress points
			System.out.println("\nYour current progress point(s) is " + p.getProject().getProgress() + ". Are you "
					+ "sure you want to submit your Project? \n"
					+ "[0] No\n"
					+ "[1] Yes");
			System.out.print("INPUT: ");
			int ans = in.nextInt();
			
			switch(ans) {
			case 0: //no
				System.out.println("Good choice! Why not work a little longer on your project, mhm?");
				System.out.println("\n--------------------");
				choiceMenu(p); //returns the player to choice menu
				break;
			case 1:
				System.out.println("You have chosen to submit your project...");
				System.out.println("\n--------------------\n");
				endGame(p); //terminates the game
				break;
			default:
				System.out.println("Please type only '0' or '1'.");
				System.out.println("\n--------------------");
				submitProject(p);
				break;
			}
		}
		else {
			System.out.println("\n--------------------\n");
			endGame(p); //launches endGame method
		}
	}
	
	public static void endGame(Player p) {
		Scanner in = new Scanner (System.in);
		System.out.println("------------------------------------------------------");
		System.out.println("-------------YOU HAVE PASSED YOUR PROJECT-------------");
		System.out.println("------------------------------------------------------");
		
		//shows final project progress
		checkMyProject(p);

		//MESSAGES DEPENDING ON YOUR CHECKPOINTS
		int checkpointsMet= 0;
		for(int i = 0; i < wasCheckpointMet.length; i++) {
			if (wasCheckpointMet[i] == true) 
				checkpointsMet+=1;
		}
		
		if (checkpointsMet == 1) {
			System.out.println("You passed your project, and, well, it could've been better. A lot better. \n\n"
								+ "\"Did you even try?\" Your professor demanded. \"It doesn look like you even bothered. "
								+ "\nTell me. With your output, what kind of grades do you think you deserve?\" \n"
								+ "\nYou and your groupmates look at each other and shrug. You don't answer, and walk away with failing grades. "
								+ "\nThis kind of result, what do you feel about it?");
		} else if (checkpointsMet == 2) {
			System.out.println("You passed your project, and sad to say you failed."
								+ "\nYour professor didn't look satisfied with your output and pointed out a lot of areas which definitely could've had major improvements. " 
								+ "\nIn the end, it's not as if you can do anything with it anymore. You pressed the submit button and the project is done and graded. "
								+ "\nMaybe you could've put in more effort, but oh well. "
								+ "\nAre you fine with these results?");
		} else if (checkpointsMet == 3) {
			System.out.println("You passed your project, and it's well within average. "
								+ "\nIt wasn't the best, but it wasn't bad either! Your professor pointed out places where you could've polished a little more, "
								+ "\nbut it isn't as if there's anything that could be done anymore. The project has been graded, hasn't it? "
								+ "\nAll that matters is that even if you don't have the best output, you haven't failed. " 
								+ "\nThis result, is it fine with you? ");
		} else if (checkpointsMet == 4) {
			System.out.println("You passed your project, and while it wasn't the best, it's hella close. "
								+ "\nYou and your groupmates presented your project, and there was a bit of stumbling here and there but no major mistakes were made. "
								+ "\nWhatever happened these past few days, your effort and hardwork, your blood, sweat, and tears finally paid off. "
								+ "\nThere are other groups who received higher grades than you, but all that matters is that you're content with what you have."
								+ "\nAnd are you?");
		} else if (checkpointsMet == 5) {
			System.out.println("You passed your project and passed with flying colours! "
								+ "\nYou and your groupmates presented your project with ease and your professor was very impressed with you! "
								+ "\nWhatever happened these past few days, all your effort and hardwork, your blood, sweat, and tears finally paid off. "
								+ "\nYou're happy, exhilerated. You should be proud of yourself! Now the question is, are you?");
		} else {
			System.out.println("In fact,  you hadn't made any progress whatsoever. "
								+ "\nIs this what we can call \"risk-taking\"? "
								+ "\nYour professor was mad and you walked away with grades that match the effort you put in. "
								+ "\nWell, which is to say, you failed. By a landslide. Congratulations, I suppose? ");
		}
		pressEnterToContinue();
		System.out.println("--------------------\n");
		
		//MESSAGE DEPENDING ON YOUR STATS
		System.out.println("\nYou finished with these stats: ");
		int ep = p.getEnergy();
		int sp = p.getStress();
		System.out.print("Energy Points: " + ep + "/10");
		System.out.print("\nStress Points: " + sp + "/10 \n\n");
		
		pressEnterToContinue();
		
		if (ep >= 1 && ep <= 3) {
			System.out.println("You're so tired, drained. You just want to sleep, or maybe grab a sandwich. ");
		} else if (ep >= 4 && ep <= 7) {
			System.out.println("You aren't tired but you aren't all that chipper either. If energy had a goldilocks zone, you're well within it. ");
		} else if (ep >= 8 && ep <= 10) {
			System.out.println("You've never felt so alive than you do now. Taking care of yourself has its perks, and this is one of it. ");
		}
		
		if (sp >= 0 && sp <= 3) {
			System.out.print("\nYou're actually feeling relaxed and stress-free, surprisingly enough. \nThis project ended on a high note, at least when it comes to your mental and physical state.");
		} else if (sp >= 4 && sp <= 6) {
			System.out.print(" \nYou're stressed, but not too stressed. It's still well within healthy and manageable levels. "
								+ "It's the kind of stress that fades away after a day or two of just relaxing.");
		} else if (sp >= 7 && sp <= 10) {
			System.out.print("\nYou're no longer a human as much as you are a bundle of stress. "
								+ "\nIt's a miracle that you haven't broken down yet. Everything sucks. You just want to sleep "
								+ "\na day or two or maybe forever. "
								+ "\nWhatever your results, was it worth this?");
		}
		pressEnterToContinue();
		System.out.println("");
		System.out.println("------------------------------------------------------");
		System.out.println("----------------------0 DAYS LEFT---------------------");
		System.out.println("------------------------------------------------------");
		pressEnterToContinue();
		System.out.println("Thank you for playing 7 Days Left!");
		pressEnterToContinue();
		System.out.println("This project has been brought to you by: ");
		System.out.println("1. Keon Villegas\n"
							+ "2. Marcus Joaquin Tion Paler\n"
							+ "3. Nico Marcelino\n"
							+ "4. Paolo Gabriel Gonzales\n");
		
		pressEnterToContinue();
		
		System.out.println("Do you want to play again?" + "\n"
							+ "[0] No\n"
							+ "[1] Yes");
		System.out.print("INPUT: ");
		int choice = in.nextInt();
		
		switch (choice) {
		case 0:
			System.out.println("\nThank you for playing. :)");
			System.exit(0);//terminates program
		case 1:
			System.out.println("\nRestarting game.... \n");
			pressEnterToContinue();
			game();
		}
	}

	//------------------------------------------------------------
	//------------------------OTHER MTHODS------------------------
	//------------------------------------------------------------
	
	public static void pressEnterToContinue() {
		Scanner in = new Scanner(System.in);
		System.out.println("\nPress enter to continue...");
		try{in.nextLine();}
		catch(Exception e){}
	}
		
	public static boolean statCheck (Player p, int whichStat) {
		//checks if player has enough stats to do an action
		//if sp >= 8, they can no longer do acads
		//if ep <= 3, they are too tired to do anything
		boolean doesMeetStats = true;
		System.out.println("\n--------------------");
		switch(whichStat) {
		case 1: //checks for both!
			if (p.getStress() >= 8) {
				System.out.println("Your have reached or exceeded 8 SP. That's getting unhealthily stressed.\n");
				
				System.out.println("\nYou're so stressed that you can barely think straight.");
				System.out.println("You might go insane if you do try do anything more today..");
				System.out.println("Perhaps it's time to take care of yourself?");
				
				System.out.println("\nHint: Please lower your stress by doing self-care.");
				
				doesMeetStats = false;
			}
			
			if (p.getEnergy() <= 3) {
				System.out.println("\nYou're so tired you can barely do anything.");
				System.out.println("Your hands are shaking and your vision is starting to blur around the edges.");
				System.out.println("When was the last time you slept or ate anything?");
				
				System.out.println("\nHint: Please replenish your energy by sleeping or eating.");
				doesMeetStats = false;
			}
			break;
		case 2: //checks only for stress
			if (p.getStress() >= 8) {
				System.out.println("Your have reached or exceeded 8 SP. That's getting unhealthily stressed.\n");
				
				System.out.println("\nYou're so stressed that you can barely think straight.");
				System.out.println("You might go insane if you do try do anything more today..");
				System.out.println("Perhaps it's time to take care of yourself?");
				
				System.out.println("\nHint: Please lower your stress by doing self-care.");
				
				doesMeetStats = false;
			}
			break;
		case 3: //checks only for energy
			if (p.getEnergy() <= 3) {
				System.out.println("\nYou're so tired you can barely do anything.");
				System.out.println("Your hands are shaking and your vision is starting to blur around the edges.");
				System.out.println("When was the last time you slept or ate anything?");
				
				System.out.println("\nHint: Please replenish your energy by sleeping or eating.");
				doesMeetStats = false;
			}
			break;
		}
		
		
		pressEnterToContinue();
		System.out.println("--------------------\n");
		return doesMeetStats; 
	}

}
