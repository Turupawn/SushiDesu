package pollo.empanizado.sushi;

import java.beans.EventHandler;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SushiDesu implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture_bg1;
	private Texture texture_bg2;
	private Texture texture_bg3;
	private Texture texture_bg4;
	private Sprite bg1;
	private Sprite bg2;
	private Sprite bg3;
	private Sprite bg4;
	private Image btn_bg1;
	private Image btn_bg2;
	private Image btn_bg3;
	private Image btn_bg4;
	private boolean bg1_visible=true;
	private boolean bg2_visible=false;
	private boolean bg3_visible=false;
	private boolean bg4_visible=false;
	private Image sushi;
	
	
	@Override
	public void create() {	

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
//		float w = 1024;
//		float h = 640;
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture_bg1 = new Texture(Gdx.files.internal("backgrounds/1.png"));
		texture_bg1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion region = new TextureRegion(texture_bg1, 0, 0, 1024, 640);
		bg1 = new Sprite(region);
		bg1.setSize(1f, 800f/1200f);
		bg1.setOrigin(bg1.getWidth()/2, bg1.getHeight()/2);
		bg1.setPosition(-bg1.getWidth()/2, -bg1.getHeight()/2);
		
		texture_bg2 = new Texture(Gdx.files.internal("backgrounds/2.png"));
		texture_bg2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion region2 = new TextureRegion(texture_bg2, 0, 0, 1024, 640);
		bg2 = new Sprite(region2);
		bg2.setSize(1f, 800f/1200f);
		bg2.setOrigin(bg2.getWidth()/2, bg2.getHeight()/2);
		bg2.setPosition(-bg2.getWidth()/2, -bg2.getHeight()/2);
		
		texture_bg3 = new Texture(Gdx.files.internal("backgrounds/3.png"));
		texture_bg3.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion region3 = new TextureRegion(texture_bg3, 0, 0, 1024, 640);
		bg3 = new Sprite(region3);
		bg3.setSize(1f, 800f/1200f);
		bg3.setOrigin(bg3.getWidth()/2, bg3.getHeight()/2);
		bg3.setPosition(-bg3.getWidth()/2, -bg3.getHeight()/2);
		
		texture_bg4 = new Texture(Gdx.files.internal("backgrounds/4.png"));
		texture_bg4.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion region4 = new TextureRegion(texture_bg4, 0, 0, 1024, 640);
		bg4 = new Sprite(region4);
		bg4.setSize(1f, 800f/1200f);
		bg4.setOrigin(bg4.getWidth()/2, bg4.getHeight()/2);
		bg4.setPosition(-bg4.getWidth()/2, -bg4.getHeight()/2);
		
		Global.stage = new Stage();
		Gdx.input.setInputProcessor(Global.stage);
		
		Texture sushi_texture = new Texture(Gdx.files.internal("sushi.png"));
		sushi_texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sushi = new Image(sushi_texture);
		Global.stage.addActor(sushi);
		
		new DressButton(500,10,"type4","a");
		new DressButton(630,10,"type4","b");
		new DressButton(760,10,"type4","c");
		new DressButton(890,10,"type4","x");
		
		new DressButton(500,140,"type2","a");
		new DressButton(630,140,"type2","b");
		new DressButton(760,140,"type2","c");
		new DressButton(890,140,"type2","x");
		
		new DressButton(500,270,"topping","camaron");
		new DressButton(630,270,"topping","kakiage");
		new DressButton(760,270,"topping","salmon");
		new DressButton(890,270,"topping","x");
		
		new DressButton(500,400,"type3","a");
		new DressButton(630,400,"type3","b");
		new DressButton(760,400,"type3","c");
		new DressButton(890,400,"type3","x");
		
		new DressButton(500,530,"face","a");
		new DressButton(630,530,"face","b");
		new DressButton(760,530,"face","c");
		new DressButton(890,530,"face","x");
		
		btn_bg1 = new Image(new Texture("background_buttons/1.png"));
		btn_bg2 = new Image(new Texture("background_buttons/2.png"));
		btn_bg3 = new Image(new Texture("background_buttons/3.png"));
		btn_bg4 = new Image(new Texture("background_buttons/4.png"));
		
		btn_bg1.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int pointer, int button)
			{
				bg1_visible=true;
				bg2_visible=false;
				bg3_visible=false;
				bg4_visible=false;
				return true;
			}
		});
		
		btn_bg2.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int pointer, int button)
			{
				bg1_visible=false;
				bg2_visible=true;
				bg3_visible=false;
				bg4_visible=false;
				return true;
			}
		});
		
		btn_bg3.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int pointer, int button)
			{
				bg1_visible=false;
				bg2_visible=false;
				bg3_visible=true;
				bg4_visible=false;
				return true;
			}
		});
		
		btn_bg4.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int pointer, int button)
			{
				bg1_visible=false;
				bg2_visible=false;
				bg3_visible=false;
				bg4_visible=true;
				return true;
			}
		});
		
		
		btn_bg1.setPosition(1050,500);
		btn_bg2.setPosition(1050,350);
		btn_bg3.setPosition(1050,200);
		btn_bg4.setPosition(1050,50);
		
		Global.stage.addActor(btn_bg1);
		Global.stage.addActor(btn_bg2);
		Global.stage.addActor(btn_bg3);
		Global.stage.addActor(btn_bg4);
		
//		new DressButton(1050,500,"face","a");
//		new DressButton(1050,350,"face","b");
//		new DressButton(1050,200,"face","c");
//		new DressButton(1050,50,"face","x");
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture_bg1.dispose();
		texture_bg2.dispose();
		texture_bg3.dispose();
		texture_bg4.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if(bg1_visible)
			bg1.draw(batch);
		if(bg2_visible)
			bg2.draw(batch);
		if(bg3_visible)
			bg3.draw(batch);
		if(bg4_visible)
			bg4.draw(batch);
		batch.end();
		
		Global.stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		Global.stage.setViewport(1200, 800, true);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
