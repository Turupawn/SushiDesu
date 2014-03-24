package pollo.empanizado.sushi;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;


public class DressButton extends SuperImage
{
	Dress topping;
	String type;
	String name;
	public DressButton(int x,int y,String type, String name)
	{
		super(x,y,"DressButton/"+type+"/"+name+".png");
		Global.stage.addActor(this);
		this.type=type;
		this.name=name;
		
		topping = new Dress(0, 0,type,name);
	}

	@Override
	public void onTouchDown() {
		Array<Actor> actors = Global.stage.getActors();
		for(Actor actor : actors)
		{
			if(actor instanceof Dress)
			{
				Dress temp = (Dress)actor;
				if(temp.type == type)
				{
					temp.setVisible(false);
				}
			}
		}
		topping.setVisible(true);
	}
}