import java.io.*;
import java.util.*;

public class PassGen 
{
	public static void main(String[] args) 
	{
		ArrayList<String> lc = new ArrayList<String>(0);
		ArrayList<String> uc = new ArrayList<String>(0);
		ArrayList<String> bc = new ArrayList<String>(0);
		ArrayList<String> num = new ArrayList<String>(0);
		ArrayList<String> nl = new ArrayList<String>(0);
		ArrayList<String> all = new ArrayList<String>(0);
		
		int i;
		String k;
		for (i=97;i<123;i++)
		{
			k= ""+(char)i;
			lc.add(k);
		}
		for (i=65;i<91;i++)
		{
			k= ""+(char)i;
			uc.add(k);
		}
		for (i=97;i<123;i++)
		{
			k= ""+(char)i;
			bc.add(k);
		}
		for (i=65;i<91;i++)
		{
			k= ""+(char)i;
			bc.add(k);
		}
		for (i=48;i<58;i++)
		{
			k= ""+(char)i;
			num.add(k);
		}
		for (i=97;i<123;i++)
		{
			k= ""+(char)i;
			nl.add(k);
		}
		for (i=65;i<91;i++)
		{
			k= ""+(char)i;
			nl.add(k);
		}
		for (i=48;i<58;i++)
		{
			k= ""+(char)i;
			nl.add(k);
		}
		for (i=97;i<123;i++)
		{
			k= ""+(char)i;
			all.add(k);
		}
		for (i=65;i<91;i++)
		{
			k= ""+(char)i;
			all.add(k);
		}
		for (i=48;i<58;i++)
		{
			k= ""+(char)i;
			all.add(k);
		}
		for (i=97;i<123;i++)
		{
			k= ""+(char)i;
			all.add(k);
		}
		for (i=65;i<91;i++)
		{
			k= ""+(char)i;
			all.add(k);
		}
		for (i=48;i<58;i++)
		{
			k= ""+(char)i;
			all.add(k);
		}
		for (i=48;i<58;i++)
		{
			k= ""+(char)i;
			all.add(k);
		}
		for (i=33;i<127;i++)
		{
			k= ""+(char)i;
			all.add(k);
		}

		Scanner input= new Scanner(System.in);
		boolean flag3= true;
		while (flag3)
		{
			System.out.println("Enter desired length: ");
			int len= input.nextInt();
			System.out.println("Choose character set:\n   1. Lowercase\n   2. Uppercase\n   3. Both Cases\n   4. Numbers\n   5. Letters and Numbers\n   6. All Keyboard Characters");
			int choice= input.nextInt();
			Random gen= new Random();
			String pass= "";
			boolean flag= true;
			while (flag)
			{
				boolean flag2= true;
				while (flag2)
				{
					if (choice == 1)
					{
						for (i=0;i<len;i++)
						{
							int index= gen.nextInt(lc.size());
							pass= pass+ lc.get(index);
						}
						System.out.println(pass);
						flag2= false;
					}
					else if (choice == 2)
					{
						for (i=0;i<len;i++)
						{
							int index= gen.nextInt(uc.size());
							pass= pass+ uc.get(index);
						}
						System.out.println(pass);
						flag2= false;
					}
					else if (choice == 3)
					{
						for (i=0;i<len;i++)
						{
							int index= gen.nextInt(bc.size());
							pass= pass+ bc.get(index);
						}
						System.out.println(pass);
						flag2= false;
					}
					else if (choice == 4)
					{
						for (i=0;i<len;i++)
						{
							int index= gen.nextInt(num.size());
							pass= pass+ num.get(index);
						}
						System.out.println(pass);
						flag2= false;
					}
					else if (choice == 5)
					{
						for (i=0;i<len;i++)
						{
							int index= gen.nextInt(nl.size());
							pass= pass+ nl.get(index);
						}
						System.out.println(pass);
						flag2= false;
					}
					else if (choice == 6)
					{
						for (i=0;i<len;i++)
						{
							int index= gen.nextInt(all.size());
							pass= pass+ all.get(index);
						}
						System.out.println(pass);
						flag2= false;
					}
					else
					{
						System.out.println("Invalid Selection");
						System.out.println("Choose character set:\n   1. Lowercase\n   2. Uppercase\n   3. Both Cases\n   4. Numbers\n   5. Letters and Numbers\n   6. All Keyboard Characters");
						choice= input.nextInt();
						flag2= true;
					}
				}
				System.out.println("Generate again? Y/N");
				String ag= input.next();
				String same;
				if (ag.equalsIgnoreCase("y"))
				{
					System.out.println("Same parameters? Y/N");
					same= input.next();
				}
				else 
				{
					same= "n";
				}
				if (ag.equalsIgnoreCase("y") && same.equalsIgnoreCase("y"))
				{
					flag= true;
					flag3= true;
					pass= "";
				}
				else if (ag.equalsIgnoreCase("y") && same.equalsIgnoreCase("n"))
				{
					flag= false;
					flag3= true;
					pass= "";
				}
				else if (ag.equalsIgnoreCase("n") && same.equalsIgnoreCase("n"))
				{
					flag= false;
					flag3= false;
					pass= "";
				}
			}
		}
	}
}