package GenericUtility;

import java.util.Random;

public class JavaUtility {
	
	public int getRandomNum()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		return randomNumber;
		
	}

}
