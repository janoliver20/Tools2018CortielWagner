
public class TimeToText {


	public void thisIsANewMethod() {
		
	String x = "Help us";

	 }

	public static void main(String[] args) {
	
		System.out.print("This is a git change by Member 1");
		
		// input hour and minute
		int hour = In.readInt();
		int minute = In.readInt();
		
		// minute split in one digit and ten digit
		int minute_ten = minute / 10;
		int minute_one = minute % 10;
		
		// error 
		if (minute_ten >= 6 || hour >= 13 || hour == 0)
			Out.print("");
		
		// special minute count (without "halb")
		else if (minute_one == 0 && minute_ten == 0)
			Out.print("punkt ");
		else if (minute_one == 5 && minute_ten == 1)
			Out.print("viertel nach ");
		else if (minute_one == 5 && minute_ten == 4)
			Out.print("dreiviertel ");
		
		// error
		if (!(minute_ten >= 6) && (hour >= 13 || hour == 0))
			Out.print("***");
		else if (minute >= 60 && !(hour >= 13 || hour == 0))
			Out.print("");
		
		// hours and special minute count "halb"
		else if (hour == 1) {
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb zwei uhr");
			else 
				Out.print("ein uhr ");
			}
		else if (hour == 2) {
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb drei uhr");
			else
				Out.print("zwei uhr ");
		}
		else if (hour == 3)
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb vier uhr");
			else			
				Out.print("drei uhr "); 
		
		else if (hour == 4)
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb fünf uhr");
			else
				Out.print("vier uhr "); 
		
		else if (hour == 5)
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb sechs uhr");
			else
				Out.print("fünf uhr "); 
		
		else if (hour == 6)
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb sieben uhr");
			else
				Out.print("sechs uhr "); 
		
		else if (hour == 7)
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb acht uhr");
			else
				Out.print("sieben uhr ");
		
		else if (hour == 8)
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb neun uhr");
			else
				Out.print("acht uhr ");
		
		else if (hour == 9)
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb zehn uhr");
			else 
				Out.print("neun uhr ");
		
		else if (hour == 10)
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb elf uhr");
			else
				Out.print("zehn uhr ");
		
		else if (hour == 11)
			if (minute_one == 0 && minute_ten == 3)
				Out.print("halb zwölf uhr");
			else
				Out.print("elf uhr "); 
		
		
		else if (hour == 12)
			if (minute_one == 0  && minute_ten == 3)
				Out.print("halb ein uhr");
			else
				Out.print("zwölf uhr "); 
		
		// error
		if (!(minute_ten >= 6) && (hour >= 13 || hour == 0) )
			Out.print("");
		
		else if (minute_ten >= 6 && !(hour >= 13 || hour == 0))
			Out.print("***");
		
		// minute one digit 20 - 59
		else if (minute_one <= 9) {
			switch (minute_one) {
			case 1: 
				if (minute_one == 1 && minute_ten > 1)
				Out.print("einund"); break;
			case 2:
				if (minute_one == 2 && minute_ten > 1)
				Out.print("zweiund"); break;
			case 3: 
				if (minute_one == 3 && minute_ten > 1)
				Out.print("dreiund"); break;
			case 4:
				if (minute_one == 4 && minute_ten > 1)
				Out.print("vierund"); break;
			case 5:
				if (minute_one == 5 && minute_ten > 1 && minute_ten != 4) // condition for special minute count
				Out.print("fünfund"); break;
			case 6:
				if (minute_one == 6 && minute_ten > 1)
				Out.print("sechsund"); break;
			case 7:
				if (minute_one == 7 && minute_ten > 1)
				Out.print("siebenund"); break;
			case 8:
				if (minute_one == 8 && minute_ten > 1)
				Out.print("achtund"); break;
			case 9:
				if (minute_one == 9 && minute_ten > 1)
				Out.print("neunund"); break;
			case 0:
				Out.print("");
			}
			
			// minute ten digit 10 - 59 and minute one digit 0 - 9 
			switch (minute_ten) {
			case 1: 
				if (minute_one == 3) 
					Out.print("drei");
				else if (minute_one == 4) 
					Out.print("vier");		
				else if (minute_one == 5)
					Out.print(" ");
				else if (minute_one == 6)
					Out.print("sech");
				else if (minute_one == 7)
					Out.print("sieb");
				else if (minute_one == 8)
					Out.print("acht");
				else if (minute_one == 9)
					Out.print("neun");
				else if (minute_one == 1)
					Out.print("elf");
				else if (minute_one == 2)
					Out.print("zwölf");
				if (minute_one >= 3 && minute_one != 5)
					Out.print("zehn"); 
				break;
			case 2:
				Out.print("zwanzig"); break;
			case 3: 
				if (minute_one == 0)
					Out.print("");
				else
					Out.print("dreißig"); 
				break;
			case 4: 
				if (minute_one == 5)
					Out.print("");
				else 
					Out.print("vierzig"); break;
			case 5:
				Out.print("fünfzig"); break;
			case 0:
					if (minute_one == 0)
						Out.print("");
				else if (minute_one == 1)
					Out.print("eins");
				else if (minute_one == 2)
					Out.print("zwei");
				else if (minute_one == 3) 
					Out.print("drei");
				else if (minute_one == 4) 
					Out.print("vier");		
				else if (minute_one == 5)
					Out.print("fünf");
				else if (minute_one == 6)
					Out.print("sechs");
				else if (minute_one == 7)
					Out.print("sieben");
				else if (minute_one == 8)
					Out.print("acht");
				else if (minute_one == 9)
					Out.print("neun");
				else if (minute_one >= 3)
					Out.print("zehn"); 				
			}	
		}
	}
}
