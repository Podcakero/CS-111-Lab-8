public class StackTester {
	public static void main(String[] args)
	{
		int score = 0;
		score += testPush(20);
		score += testPop(20);
		score += testPushAfterPop(10);
		score += testSize(10);
		score += testEmpty(10);
		System.out.println("***FINAL SCORE*** " + score + "/70");
		System.out.println("Assuming code style and submission points:");
		System.out.println("***FINAL SCORE*** " + (score + 30) + "/100");
	}
	
	public static int testPush(int score)
	{
		boolean works = true;
		Stack<String> s = new Stack<String>();
		
		if(!s.toString().equals("[]"))
			works = false;
		
		s.push("Potato");
		s.push("Burger");
		s.push("Butter");

		if(!s.toString().equals("[Butter, Burger, Potato]"))
			works = false;
		
		if(!works) {
			System.out.println("testPush failed!");
			return 0;
		}
		else {
			System.out.println("testPush passed!");
			return score;
		}
	}
	
	public static int testPop(int score)
	{
		boolean works = true;
		Stack<String> s = new Stack<String>();
		
		try {
			s.pop();
			works = false;
			System.out.println("Code didn't throw exception on empty pop");
		}
		catch(StackException e)
		{
			System.out.println("Code successfully threw exception on empty pop");
		}
		catch(Exception e)
		{
			works = false;
			System.out.println("Code threw wrong exception on empty pop");
		}
		
		s.push("Potato");
		s.push("Burger");
		s.push("Butter");
		
		s.pop();
		
		if(!s.toString().equals("[Burger, Potato]"))
			works = false;
		
		if(!works) {
			System.out.println("testPop failed!");
			return 0;
		}
		else {
			System.out.println("testPop passed!");
			return score;
		}
	}
	
	public static int testPushAfterPop(int score)
	{
		boolean works = true;
		Stack<String> s = new Stack<String>();
		
		s.push("Potato");
		s.push("Burger");
		s.push("Butter");
		
		s.pop();
		
		s.push("Watermelon");
		
		if(!s.toString().equals("[Watermelon, Burger, Potato]"))
			works = false;
		
		if(!works) {
			System.out.println("testPushAfterPop failed!");
			return 0;
		}
		else {
			System.out.println("testPushAfterPop passed!");
			return score;
		}
	}

	public static int testSize(int score)
	{
		boolean works = true;
		Stack<String> s = new Stack<String>();
		
		if(s.size() != 0)
			works = false;
		
		s.push("Potato");
		s.push("Burger");
		s.push("Butter");

		if(s.size() != 3)
			works = false;
		
		s.pop();
		
		if(s.size() != 2)
			works = false;
		
		if(!works) {
			System.out.println("testSize failed!");
			return 0;
		}
		else {
			System.out.println("testSize passed!");
			return score;
		}
	}
	
	public static int testEmpty(int score)
	{
		boolean works = true;
		Stack<String> s = new Stack<String>();
		
		if(!s.isEmpty())
			works = false;
		
		s.push("Potato");
		s.push("Burger");
		s.push("Butter");

		if(s.isEmpty())
			works = false;
		
		s.pop();
		
		if(s.isEmpty())
			works = false;
		
		s.pop();
		s.pop();
		
		if(!s.isEmpty())
			works = false;
		
		if(!works) {
			System.out.println("testEmpty failed!");
			return 0;
		}
		else {
			System.out.println("testEmpty passed!");
			return score;
		}
	}
}
