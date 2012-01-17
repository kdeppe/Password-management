import java.util.*;
import java.io.*;

public class Passwords
{
	public static void main(String[] args) 
	{
		try
		{
			//Declare arraylist
			ArrayList<Password> passwords;
			
			try
			{
				//Initialize with existing arraylist, if there
				FileInputStream fis= new FileInputStream("passwords.ser");
				BufferedInputStream bis= new BufferedInputStream(fis);
				ObjectInputStream ois= new ObjectInputStream(bis);
				passwords= (ArrayList<Password>)ois.readObject();

				ois.close();
			}
			catch (ClassNotFoundException cnfe)
			{
				//Otherwise initialize empty
				passwords= new ArrayList<Password>(0);
			}
			catch (IOException ioe)
			{
				//Otherwise initialize empty
				passwords= new ArrayList<Password>(0);
			}

			//Display options
			System.out.println("Select an option:\n    1: Add new site\n    2: Display stored sites\n    3: Look up site\n    4: Delete site by name\n    5: Delete site by category\n    6: Exit");
			Scanner in= new Scanner(System.in);
			String input= in.next();
			while (!input.equals("6"))
			{
				if (input.equals("1")) //Add new site
				{
					//Get data for fields
					Scanner data= new Scanner(System.in);
					System.out.println("Site name:");
					String nm= data.nextLine();
					System.out.println("URL:");
					String url= data.nextLine();
					System.out.println("Category");
					String cat= data.nextLine();
					System.out.println("Username:");
					String un= data.nextLine();
					System.out.println("Password:");
					String pw= data.nextLine();

					//Create password object
					Password p1= new Password(nm,url,cat,un,pw);

					//Write to arraylist
					passwords.add(p1);
					
					//Prompt for next option
					System.out.println("Select an option:\n    1: Add new site\n    2: Display stored sites\n    3: Look up site\n    4: Delete site by name\n    5: Delete site by category\n    6: Exit");
					input= in.next();
				}
				else if (input.equals("2")) //Display stored sites
				{
					
					//ArrayList of categories
					ArrayList<String> categories = new ArrayList<String>(0);
					
					//Find distinct categories and put in arraylist
					boolean flag= false;
					for (int i=0;i<passwords.size();i++)
					{
						Password p2= passwords.get(i);
						String cate= p2.getCategory();
						for (int j=0;j<categories.size();j++)
						{
							if (cate.equalsIgnoreCase(categories.get(j)))
							{
								flag= true;
							}
						}
						if (!flag)
						{
							categories.add(cate);
						}
						flag= false;
					}
					//Alpphabetize arraylist
					ArrayList<String> catA = Alphabetize(categories);

					//Under each category print all sites with matching category
					for (int k=0;k<catA.size();k++)
					{
						String cathead= catA.get(k);
						System.out.println("\n   +++ "+cathead+" +++\n");
						for (int l=0;l<passwords.size();l++)
						{
							Password p3= passwords.get(l);
							String catchk= p3.getCategory();
							if (catchk.equalsIgnoreCase(cathead))
							{
								System.out.println(p3.getName());
							}
						}	
					}
					System.out.println("\n");

					//Prompt for next option
					System.out.println("Select an option:\n    1: Add new site\n    2: Display stored sites\n    3: Look up site\n    4: Delete site by name\n    5: Delete site by category\n    6: Exit");
					input= in.next();
				}
				else if (input.equals("3"))
				{
					//Prompt for name
					System.out.println("Site name:");
					Scanner prompt= new Scanner(System.in);
					String name= prompt.nextLine();
					boolean chk= false;
					
					//Search arraylist for matching name and print details
					for (int m=0;m<passwords.size();m++)
					{
						Password p4= passwords.get(m);
						String namechk= p4.getName();
						if (namechk.equalsIgnoreCase(name))
						{
							System.out.println(p4.toString());
							chk= true;
						}
					}
					if (!chk)
					{
						System.out.println("\nSearch key returned no results\n");
					}

					//Prompt for next option
					System.out.println("Select an option:\n    1: Add new site\n    2: Display stored sites\n    3: Look up site\n    4: Delete site by name\n    5: Delete site by category\n    6: Exit");
					input= in.next();
				}
				else if (input.equals("4"))
				{
					//Prompt name
					System.out.println("Site name:");
					Scanner search= new Scanner(System.in);
					String name= search.nextLine();
					boolean chk= false;


					for (int m=0;m<passwords.size();m++)
					{
						//Retrieve password object
						Password p4= passwords.get(m);
						String namechk= p4.getName();

						//Check if name is equal to search key
						if (namechk.equalsIgnoreCase(name))
						{
							System.out.println(p4.toString()); 
							//Verify element to delete
							System.out.println("Proceed with delete? Y/N");
							input= in.next();
							if (input.equalsIgnoreCase("Y"))
							{
								//Delete element
								passwords.remove(m);
								System.out.println("Entry deleted");
							}
							else
							{
								//Confirm that delete cancelled
								System.out.println("Deleting cancelled.");
							}
							chk= true;
						}
					}
					if (!chk)
					{
						System.out.println("\nSearch key returned no results\n");
					}

					//Prompt for next option
					System.out.println("Select an option:\n    1: Add new site\n    2: Display stored sites\n    3: Look up site\n    4: Delete site by name\n    5: Delete site by category\n    6: Exit");
					input= in.next();
				}
				else if (input.equals("5"))
				{
					//Prompt category
					System.out.println("Category:");
					Scanner search2= new Scanner(System.in);
					String categ= search2.nextLine();
					boolean chk= false;


					for (int m=0;m<passwords.size();m++)
					{
						//Retrieve password object
						Password p4= passwords.get(m);
						String catechk= p4.getCategory();

						//Check if name is equal to search key
						if (catechk.equalsIgnoreCase(categ))
						{
							System.out.println(p4.toString()); 
							//Verify element to delete
							System.out.println("Proceed with delete? Y/N");
							input= in.next();
							if (input.equalsIgnoreCase("Y"))
							{
								//Delete element
								passwords.remove(m);
								System.out.println("Entry deleted");
							}
							else
							{
								//Confirm that delete cancelled
								System.out.println("Deleting cancelled.");
							}
							chk= true;
						}
					}
					if (!chk)
					{
						System.out.println("\nSearch key returned no results\n");
					}
				}
				else
				{
					System.out.println("Invalid input");
					//Prompt for next option
					System.out.println("Select an option:\n    1: Add new site\n    2: Display stored sites\n    3: Look up site\n    4: Delete site by name\n    5: Delete site by category\n    6: Exit");
					input= in.next();
				}
			}

			//Write arraylist after all changes to file
			FileOutputStream fos = new FileOutputStream("passwords.ser");
			BufferedOutputStream bos= new BufferedOutputStream(fos);
			ObjectOutputStream oos= new ObjectOutputStream(bos);

			ArrayList<Password> passA= Alphpass(passwords);
			oos.writeObject(passA);
			oos.close();
		}
		catch (IOException ioe)
		{
			System.out.println(ioe);
		}
	}

	public static ArrayList<String> Alphabetize(ArrayList<String> b)
	{
		boolean flag= true;
		while (flag)
		{
			flag= false;
			for (int i=0;i<b.size()-1;i++)
			{
				String k= b.get(i);
				String l= b.get(i+1);
				int ind= 0;
				boolean same= true;
				while (same)
				{
					same= false;
					int s= (int)k.charAt(ind);
					int t= (int)l.charAt(ind);
					if (s>96)
					{
						s= s-32;
					}
					if (t>96)
					{
						t= t-32;
					}
					if (s == t)
					{
						same= true;
						ind++;
					}
					else if (s > t)
					{
						String temp= k;
						k= l;
						l= temp;
						flag= true;
						b.set(i,k);
						b.set(i+1,l);
					}
				}
				ind= 0;
			}
		}
		return b;
	}
	public static ArrayList<Password> Alphpass(ArrayList<Password> b)
	{
		boolean flag= true;
		while (flag)
		{
			flag= false;
			for (int i=0;i<b.size()-1;i++)
			{
				String k= b.get(i).getName();
				String l= b.get(i+1).getName();
				int ind= 0;
				boolean same= true;
				while (same)
				{
					int s= (int)k.charAt(ind);
					int t= (int)l.charAt(ind);
					if (s>96)
					{
						s= s-32;
					}
					if (t>96)
					{
						t= t-32;
					}
					same= false;
					if (s == t)
					{
						same= true;
						ind++;
					}
					else if (s > t)
					{
						Password w= b.get(i);
						Password x= b.get(i+1);
						Password temp= w;
						w= x;
						x= temp;
						flag= true;
						b.set(i,w);
						b.set(i+1,x);
					}
				}
				ind= 0;
			}
		}
		return b;
	}
}
