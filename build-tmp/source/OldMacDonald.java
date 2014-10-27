import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OldMacDonald extends PApplet {


public void setup()
{
	Farm f = new Farm();
	f.animalSounds();
}

interface Animal 
{    
	public String getSound();        
	public String getType(); 
}   

class Farm 
{     
  private Animal[] aBunchOfAnimals = new Animal[3];    
  public Farm()    
  {       
   aBunchOfAnimals[0] = new NamedCow("cow","Elsie","moo");          
   aBunchOfAnimals[1] = new Chick("chick","cheep","cluck");
   aBunchOfAnimals[2] = new Pig("pig","oink");    
  }     
  public void animalSounds()    
  {
    for (int nI=0; nI < aBunchOfAnimals.length; nI++) 
    {             
       System.out.println( aBunchOfAnimals[nI].getType() + " goes " + aBunchOfAnimals[nI].getSound() );       
    }       
    System.out.println( "The cow is known as " + ((NamedCow)aBunchOfAnimals[0]).getName() );    
  } 
}

class Cow implements Animal 
{     
	protected String myType;     
  	protected String mySound;      
	public Cow(String type, String sound)    
	{         
		myType = type;         
		mySound = sound;     
	}     
	public Cow()    
	{         
		myType = "unknown";         
		mySound = "unknown";     
	}      
	public String getSound()
	{
		return mySound;
	}     
	public String getType()
	{
		return myType;
	}
}

class NamedCow extends Cow
{
	protected String myName;      
	public NamedCow(String type, String name, String sound)    
	{         
		myType = type;
		myName = name;         
		mySound = sound;     
	}     
	public NamedCow()    
	{         
		myName = "unknown";              
	}      
	public String getName()
	{
		return myName;
	}
}

class Chick extends Cow
{

	private String mySound2;     
  	private String mySound;
  	int number = (int)(Math.random()*2);      
	public Chick(String type, String sound2, String sound)    
	{         
		myType = type;
		mySound2 = sound2;         
		mySound = sound;     
	}     
	public Chick()    
	{         
		mySound2 = "unknown";         
	}         
	public String getSound()
	{
		if(number == 0)
		{
			return mySound;
		}
		else
		{
			return mySound2;
		}
	}
}

class Pig extends Cow
{     
	public Pig(String type, String sound)    
	{         
		myType = type;         
		mySound = sound;     
	}     
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OldMacDonald" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
