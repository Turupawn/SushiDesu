package pollo.empanizado.sushi;

public class Dress extends SuperImage
{
	String type;
	String name;
	public Dress(int x, int y, String type, String name)
	{
		super(x,y,"Dress/"+type+"/"+name+".png");
		Global.stage.addActor(this);
		setVisible(false);
		this.type=type;
		this.name=name;
	}

	@Override
	public void onTouchDown() {
	}
}
