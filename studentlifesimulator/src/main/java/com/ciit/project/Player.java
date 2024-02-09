package com.ciit.project;

public class Player extends Person implements iStudent {
	
	private int hoursTaken = 0;

	//---------------------------------------
	//------iSTUDENT OVERRIDEN METHODS-------
	//---------------------------------------
	@Override
	public void workOnProject() {
		
		if (hoursTaken >= 1 && hoursTaken <= 3) { //1-3 hours
			System.out.println("Nice! TIme passes by quickly when it's a nice day, right? You worked on your project for one to three hours and now you're feeling pretty good about yourself. What else should you do today?");
		} else if (hoursTaken >= 4 && hoursTaken <= 6) { //4-6 hours
			System.out.println("You did a good job in doing your project. Don't overwork yourself, always remember to take a rest or do something for yourself that will make you happy and stress free!\r\n"
					+ "\r\n"
					+ "You worked for four to six hours and made some decent progress.");
		} else if (hoursTaken >= 7 && hoursTaken <= 9) { //7-9 hours
			System.out.println("I know, i know life is hard, carve your own path and struggle till the end because if everybody can do it, you can do it too! You worked for seven to nine hours, and got a lot of things done!\r\n"
					+ "\r\n"
					+ "You're feeling pretty tired, but also pretty good about yourself.");
		} else if (hoursTaken >= 10 && hoursTaken <= 12) { //10-12 hours
			System.out.println("Cramming for 10-12 hours? Are you on a time crunch? Maybe if you have good time management, you wouldn't have to do everything in one go. Oh well.\r\n"
					+ "\r\n"
					+ "You focused on your project and got a lot of things done, but you just feel drained at the end of it.");
		}
		
		System.out.println("");
		
	}

	@Override
	public void consultProf() {
		
		if (hoursTaken >= 1 && hoursTaken <= 3) { //1-3 hours
			System.out.println("You scheduled a consultation with your professor. He gave you some valuable insight.\r\n"
					+ "\r\n"
					+ "When you worked on your project, you actually got something done.");
		} else if (hoursTaken >= 4 && hoursTaken <= 6) { //4-6 hours
			System.out.println("You scheduled a consultation with your professor. He gave you some valuable insight. You took a couple of hours to think about it.\r\n"
					+ "\r\n"
					+ "When you worked on your project, you made some decent progress.");
		} else if (hoursTaken >= 7 && hoursTaken <= 9) { //7-9 hours
			System.out.println("You scheduled a consultation with your professor. He gave you some valuable insight. He said so many good points that you can't help but sit on the topic for a little while longer.\r\n"
					+ "\r\n"
					+ "When you worked on your project, you managed to progress quite a bit, but now you're somewhat tired and stressed.");
		} else if (hoursTaken >= 10 && hoursTaken <= 12) { //10-12 hours
			System.out.println("You scheduled a consultation with your professor. He gave you some valuable insight. The words he said really made you think. In fact, you thought so much that you thought for half a day.\r\n"
					+ "\r\n"
					+ "Because of the consultation a few hours ago, you did a lot of work, but now you're feeling really stressed and really tired.");
		}
		
		System.out.println("");
	}

	@Override
	public void meetWithGroup() {
		
		if (hoursTaken >= 1 && hoursTaken <= 3) { //1-3 hours
			System.out.println("Teamwork makes the dreamwork, strike while the iron is hot! You met up with you group and worked on the project for a couple of hours.");
		} else if (hoursTaken >= 4 && hoursTaken <= 6) { //4-6 hours
			System.out.println("You met up with your groupmates and worked for a reasonable number of hours -- four to six hours isn't all that long, all things considered. It's just the right amount of time to get things done.\r\n"
					+ "\r\n"
					+ "And you did. You're feeling pretty good about yourself.");
		} else if (hoursTaken >= 7 && hoursTaken <= 9) { //7-9 hours
			System.out.println("You blased your groupchat with spam messages to wake up your groupmates, who hasnt been active for a while. To be spiteful, you dragged on the work for seven to nine hours.\r\n"
					+ "\r\n"
					+ "You guys made a lot of progress, but you just stressed yourself out because you're too petty...");
		} else if (hoursTaken >= 10 && hoursTaken <= 12) { //10-12 hours
			System.out.println("The power of friendship will trump over everything! ...or so you'd like to believe, but you've been working with your groupmates for ten to twelve hours and now you're just stressed. \r\n"
					+ "\r\n"
					+ "You made progress, but you're tired and stressed.");
		}

		System.out.println("");
	}

	//---------------------------------------
	//-------iSTUDENT OVERLOAD METHODS-------
	//---------------------------------------
	
	public void workOnProject(int hoursTaken) {
		this.hoursTaken = hoursTaken;
		workOnProject();
		int sp = 0, ep = 0, pp = 0;
		
		if (hoursTaken >= 1 && hoursTaken <= 3) { //1-3 hours
			pp = 1; sp = 2; ep = 1;
			getProject().setProgress(getProject().getProgress() + pp);			
			setStress(getStress() + sp);
			setEnergy(getEnergy()- ep);
		} else if (hoursTaken >= 4 && hoursTaken <= 6) { //4-6 hours
			pp = 2; sp = 4; ep = 2;
			getProject().setProgress(getProject().getProgress() + pp);
			setStress(getStress() + sp);
			setEnergy(getEnergy() - ep);
		} else if (hoursTaken >= 7 && hoursTaken <= 9) { //7-9 hours
			pp = 3; sp = 6; ep = 3;
			getProject().setProgress(getProject().getProgress() + pp);
			setStress(getStress() + sp);
			setEnergy(getEnergy() - ep);
		} else if (hoursTaken >= 10 && hoursTaken <= 12) { //10-12 hours
			pp = 4; sp = 8; ep = 4;
			getProject().setProgress(getProject().getProgress() + pp);
			setStress(getStress() + sp);
			setEnergy(getEnergy() - ep);
		}

		System.out.println(" + " + pp + " Progress Point(s)\n"
            + " + " + sp + " Stress Point(s)\n"
            + " - " + ep + " Energy Point(s)");
		System.out.println("\n--------------------");
        

		statLimitCheck();
	}

	
	public void consultProf(int hoursTaken) {
		this.hoursTaken = hoursTaken;
		consultProf();
		int sp = 0, ep = 0, pp = 0;

		if (hoursTaken >= 1 && hoursTaken <= 3) {
			pp = 1; sp= 2; ep = 1;
			getProject().setProgress(getProject().getProgress() + pp);
			setStress(getStress() + sp);
			setEnergy(getEnergy()- ep);
		} else if (hoursTaken >= 4 && hoursTaken <= 6) {
			pp = 2; sp= 4; ep = 2;
			getProject().setProgress(getProject().getProgress() + pp);
			setStress(getStress() + sp);
			setEnergy(getEnergy()- ep);
		} else if (hoursTaken >= 7 && hoursTaken <= 9) {
			pp = 3; sp= 6; ep = 3;
			getProject().setProgress(getProject().getProgress() + pp);
			setStress(getStress() + sp);
			setEnergy(getEnergy() - ep);
		} else if (hoursTaken >= 10 && hoursTaken <= 12) {
			pp = 4; sp= 8; ep = 4;
			getProject().setProgress(getProject().getProgress() + pp);
			setStress(getStress() + sp);
			setEnergy(getEnergy() - ep);
		}

		System.out.println(" + " + pp + " Progress Point(s)\n"
            + " + " + sp + " Stress Point(s)\n"
            + " - " + ep + " Energy Point(s)");
		System.out.println("\n--------------------");
		
		statLimitCheck();
	}

	
	public void meetWithGroup(int hoursTaken) {
		this.hoursTaken = hoursTaken;
		meetWithGroup();
		int sp = 0, ep = 0, pp = 0;
		if (hoursTaken >= 1 && hoursTaken <= 3) {
			pp = 1; sp = 1; ep = 1;
            getProject().setProgress(getProject().getProgress() + pp);
            setStress(getStress() + sp);
            setEnergy(getEnergy() - ep);
        } else if (hoursTaken >= 4 && hoursTaken <= 6) {
			pp = 2; sp = 3; ep = 2;
            getProject().setProgress(getProject().getProgress() + pp);
            setStress(getStress() + sp);
            setEnergy(getEnergy() - ep);
        } else if (hoursTaken >= 7 && hoursTaken <= 9) {
			pp = 3; sp = 5; ep = 3;
            getProject().setProgress(getProject().getProgress() + pp);
            setStress(getStress() + sp);
            setEnergy(getEnergy() - ep);
        } else if (hoursTaken >= 10 && hoursTaken <= 12) {
			pp = 4; sp = 7; ep = 4;
            getProject().setProgress(getProject().getProgress() + pp);
            setStress(getStress() + sp);
            setEnergy(getEnergy() - ep);
        }

		
		System.out.println(" + " + pp + " Progress Point(s)\n"
            + " + " + sp + " Stress Point(s)\n"
            + " - " + ep + " Energy Point(s)");
		System.out.println("\n--------------------");
		statLimitCheck();
	}
	
	//---------------------------------------
	//--------PERSON OVERLOAD METHODS-------- 
	//---------------------------------------
	
	public void doHobbies(int hoursTaken) {
		super.setHoursTaken(hoursTaken);
		super.doHobbies();
		int sp = 0, ep = 0;

		if (hoursTaken >= 1 && hoursTaken <= 3) {
			sp = 2; ep = 1;
			setStress(getStress() - sp);
			setEnergy(getEnergy() - ep);
		} else if (hoursTaken >= 4 && hoursTaken <= 6) {
			sp = 3; ep = 2;
			setStress(getStress() - sp);
			setEnergy(getEnergy() - ep);
		} else if (hoursTaken >= 7 && hoursTaken <= 9) {
			sp = 4; ep = 3;
			setStress(getStress() - sp);
			setEnergy(getEnergy() - ep);
		} else if (hoursTaken >= 10 && hoursTaken <= 12) {
			sp = 5; ep = 4;
			setStress(getStress() - sp);
			setEnergy(getEnergy() - ep);
		}

		
		System.out.println(" - " + sp + " Stress Point(s)\n"
            + " - " + ep + " Energy Point(s)");
		System.out.println("\n--------------------");
		statLimitCheck();
	}
	
	public void sleep(int hoursTaken) {
		super.setHoursTaken(hoursTaken);
		super.sleep();
		int sp = 0, ep = 0;
		if (hoursTaken >= 1 && hoursTaken <= 3) {
			sp = 2; ep = 1;
			setStress(getStress() - sp);
			setEnergy(getEnergy() + ep);
		} else if (hoursTaken >= 4 && hoursTaken <= 6) {
			sp = 2; ep = 2;
			setStress(getStress() - sp);
			setEnergy(getEnergy() + ep);
		} else if (hoursTaken >= 7 && hoursTaken <= 9) {
			sp = 2; ep = 3;
			setStress(getStress() - sp);
			setEnergy(getEnergy() + ep);
		} else if (hoursTaken >= 10 && hoursTaken <= 12) {
			sp = 2; ep = 10;
			setStress(getStress() - sp);
			setEnergy(getEnergy() + ep);
		}

		
		System.out.println(" - " + sp + " Stress Point(s)\n"
            + " + " + ep + " Energy Point(s)\n");
		System.out.println("\n--------------------");
		
		statLimitCheck();
	}
	
	public void eat(int hoursTaken) {
		super.setHoursTaken(hoursTaken);
		super.eat();
		int ep = 0, sp = 0;

		if (hoursTaken >= 1 && hoursTaken <= 3) {
			sp = 2; ep = 1;
			setStress(getStress() - sp);
			setEnergy(getEnergy() + ep);
		} else if (hoursTaken >= 4 && hoursTaken <= 6) {
			sp = 2; ep = 2;
			setStress(getStress() - sp);
			setEnergy(getEnergy() + ep);
		} else if (hoursTaken >= 7 && hoursTaken <= 9) {
			sp = 2; ep = 2;
			setStress(getStress() - sp);
			setEnergy(getEnergy() + ep);
		} else if (hoursTaken >= 10 && hoursTaken <= 12) {
			sp = 2; ep = 4;
			setStress(getStress() - sp);
			setEnergy(getEnergy() + ep);
		}

		System.out.println(" - " + sp + " Stress Point(s)\n"
            + " + " + ep + " Energy Point(s)");
		System.out.println("\n--------------------");
		statLimitCheck();
	}
	
	public void talkToPeople(int hoursTaken) {
		super.setHoursTaken(hoursTaken);
		super.talkToPeople();
		int ep = 0, sp = 0;

		if (hoursTaken >= 1 && hoursTaken <= 3) {
			sp = 2; ep = 1;
			setStress(getStress() - 2);
			setEnergy(getEnergy() - 1);
		} else if (hoursTaken >= 4 && hoursTaken <= 6) {
			sp = 3; ep = 2;
			setStress(getStress() - sp);
			setEnergy(getEnergy() - ep);
		} else if (hoursTaken >= 7 && hoursTaken <= 9) {
			sp = 4; ep = 3;
			setStress(getStress() - sp);
			setEnergy(getEnergy() - ep);
		} else if (hoursTaken >= 10 && hoursTaken <= 12) {
			sp = 5; ep = 4;
			setStress(getStress() - sp);
			setEnergy(getEnergy() - ep);
		}

		System.out.println(" - " + sp + " Stress Point(s)\n"
            + " - " + ep + " Energy Point(s)");
		System.out.println("\n--------------------");
		
		statLimitCheck();
	}
}
