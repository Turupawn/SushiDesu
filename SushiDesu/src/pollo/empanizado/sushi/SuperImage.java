package pollo.empanizado.sushi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class SuperImage extends Image
{
	public SuperImage(int x,int y,String path)
	{
		super(getTexture(path));
		setPosition(x, y);
		
		addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int pointer, int button)
			{
				onTouchDown();
				return true;
			}
		});
	}
	
	
	public static Texture getTexture(String path)
	{
		Texture texture = new Texture(path);
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		return texture;
	}
	
	public abstract void onTouchDown();
}
