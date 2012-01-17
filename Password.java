import java.io.*;

public class Password implements Serializable
{
	String name;
	String url;
	String category;
	String username;
	String password;

	public Password(String a,String b,String c,String d,String e)
	{
		name= a;
		url= b;
		category= c;
		username= d;
		password= e;
	}

	public String getName()
	{
		return name;
	}
	public String getURL()
	{
		return url;
	}
	public String getCategory()
	{
		return category;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}

	public void setName(String k)
	{
		name= k;
	}
	public void setURL(String k)
	{
		url= k;
	}
	public void setCategory(String k)
	{
		category= k;
	}
	public void setUsername(String k)
	{
		username= k;
	}
	public void setPassword(String k)
	{
		password= k;
	}

	public String toString()
	{
		String k= name+"\n  URL: "+url+"\n  Username: "+username+"\n  Password: "+password+"\n";
		return k;
	}
}
