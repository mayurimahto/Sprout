package user;
import com.sprout.annotations.*;

@SproutService
@Post
public class Rocket
{
	//@AutoWireIt
	//private Laboratory lab; //Assume that Laboratory is a class 
					//setter and getter methods for Laboratory property-> setLab & getLab

	@Post
	@ServiceURL(path="/whatever")
	public void rig(String g)
	{
	}
}