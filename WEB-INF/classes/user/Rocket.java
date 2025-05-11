package user;
import com.sprout.annotations.*;

@SproutService
@Post
public class Rocket
{
	//Example of Dependency Injection
	@AutoWireIt
	private Department department;

	private Item item;
	
	private Store store;

	@AutoWireIt
	public Rocket(Item item)
	{
		this.item=item;
	}

	@AutoWireIt
	public void setStore(Store store)
	{
		this.store=store;
	}

	public Store getStore()
	{
		return this.store;
	}

	public void setDepartment(Department department)
	{
		this.department=department;
	}

	public Department getDepartment()
	{
		return this.department;
	}

	@Forward(path="/kalia")
	@Post
	@ServiceURL(path="/whatever")
	public void rig(String g)
	{
	}

	@Forward(path="/pqr.jsp")
	@Post
	@ServiceURL(path="/whatever")
	public void coolStuff(@RequestParameter(id="nm")String name, @RequestParameter(id="gender")char gender, @RequestParameter(id="sal")int salary)
	{
	}

	@TextResponse
	@Post
	@ServiceURL(path="dodo")
	public String getWhatToDo()
	{
		return null; //assume that we are not returning NULL
	}

	@JSONResponse
	@Post
	@ServiceURL(path="getDept")
	public Department getDepartment(@RequestParameter(id="deptId")int departmentId)
	{
		//extract department data from db
		//create object of department & return it
		return null; //assume that we are not returning null
	}
}