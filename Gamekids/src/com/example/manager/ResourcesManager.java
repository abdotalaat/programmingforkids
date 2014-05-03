package com.example.manager;

import java.io.IOException;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.bitmap.AssetBitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import android.graphics.Color;

import com.example.gametutorial.MainActivity;


public class ResourcesManager 
{

	private static final ResourcesManager INSTANCE = new ResourcesManager();

	public Engine engine;
	public MainActivity activity;
	public Camera camera;
	public VertexBufferObjectManager vbom;

	    
	
	
	public ITextureRegion splash_region;
	public ITextureRegion menu_background_region;
	public ITextureRegion play_region;
	public ITextureRegion options_region;
	public ITextureRegion quit_region;
	public ITextureRegion submenu_background_region;
	public ITextureRegion submenu_item1_region;
	
	
	// Game Texture Regions
	public ITextureRegion block1_region;
	public ITextureRegion coin_region;
	public ITextureRegion arrow_btn;
	public ITextureRegion submit_btn;
	public ITextureRegion reset_btn;
	
	private BitmapTextureAtlas splashTextureAtlas;
	private BuildableBitmapTextureAtlas menuTextureAtlas;
	private BuildableBitmapTextureAtlas subMenuAtlas;
	// Game Texture
	public BuildableBitmapTextureAtlas gameTextureAtlas;

	//submit and reset
	//Submit
	public ITexture submitButtonTexture;
	private TiledTextureRegion submitButtonTextureRegion;
		
	private ITexture resetButtonTexture;
	private TiledTextureRegion resetButtonTextureRegion;
	//Up Down Righ Left
	private ITexture buttonTexture;
	private TiledTextureRegion buttonTextureRegion;
	//player
	//public ITexture mPlayerTexture;
	//public TiledTextureRegion mPlayerTextureRegion;
	public ITiledTextureRegion player_region;
	
	public Font font;

	

	public void loadMenuResources() {
		loadMenuGraphics();
		loadMenuAudio();
		loadMenuFonts();
	}
	public void loadSubMenuResources()
	{
		loadSubMenuGraphics();
		loadSubMenuAudio();
		loadSubMenuFonts();
	}

	public void loadGameResources() {
		loadGameGraphics();
		loadGameFonts();
		loadGameAudio();
	}

	

	private void loadMenuAudio() {

	}

	private void loadGameGraphics() 
	{
		
		 BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
		    gameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
		    
		    block1_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "block1.png");
		    coin_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "coin.png");
		    player_region = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(gameTextureAtlas, activity, "player.png", 3, 4);
		    arrow_btn = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "next.png");
		    submit_btn = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "menu_ok.png");
		    reset_btn = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "menu_reset.png");
		    
			/*
			try 
			{
				//submit and reset button***********************************
				submitButtonTexture = new AssetBitmapTexture(activity.getTextureManager(), activity.getAssets(), "menu_ok.png");
		
				submitButtonTextureRegion = TextureRegionFactory.extractTiledFromTexture(this.submitButtonTexture,1,1);
				submitButtonTexture.load();

				resetButtonTexture = new AssetBitmapTexture(activity.getTextureManager(), activity.getAssets(), "menu_reset.png");
				resetButtonTextureRegion = TextureRegionFactory.extractTiledFromTexture(this.resetButtonTexture,1,1);
				resetButtonTexture.load();
				//*****************************************************
			
			
				// Directions Button ***********************
				buttonTexture = new AssetBitmapTexture(activity.getTextureManager(), activity.getAssets(), "next.png");
				buttonTextureRegion = TextureRegionFactory.extractTiledFromTexture(this.buttonTexture,1,1);
				buttonTexture.load();
				//*******************************************
				
				//Main Character *************************
				//mPlayerTexture = //new AssetBitmapTexture(activity.getTextureManager(), activity.getAssets(), "player.png");
				//mPlayerTextureRegion = TextureRegionFactory.extractTiledFromTexture(this.mPlayerTexture, 3, 4);
				//mPlayerTexture.load();
				
				//******************************************
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		    */
		   
		    try 
		    {
		        this.gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
		        this.gameTextureAtlas.load();
		    } 
		    catch (final TextureAtlasBuilderException e)
		    {
		        Debug.e(e);
		    }
	}

	private void loadGameFonts() 
	{

	}
	

	private void loadGameAudio() {

	}
	
	public void unloadMenuTextures()
	{
		menuTextureAtlas.unload();
	}
	
	public void loadMenuTextures()
	{
		menuTextureAtlas.load();
	}
	
	public void unloadSubMenuTextures()
	{
		subMenuAtlas.unload();
	}
	
	public void loadSubMenuTextures()
	{
		subMenuAtlas.load();
	}
	
	public void loadSplashScreen() 
	{

		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		splashTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				splashTextureAtlas, activity, "splashPic.png", 0, 0);
		splashTextureAtlas.load();

	}

	public void unloadSplashScreen() {

		splashTextureAtlas.unload();
		splash_region = null;

	}
	
	private void loadMenuFonts()
	{
	    FontFactory.setAssetBasePath("font/");
	    final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

	    font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "font.ttf", 50, true, Color.WHITE, 2, Color.BLACK);
	    font.load();
	}

	public static ResourcesManager getInstance() {
		return INSTANCE;
	}

	private void loadMenuGraphics()
	{
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
        menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
        menu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "menu_bg.gif");
        play_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "play.jpg");
        options_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "level.jpg");
        quit_region=BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity,"quitbtn.jpg");
       
    	try 
    	{
			this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			this.menuTextureAtlas.load();
		} 
    	catch (final TextureAtlasBuilderException e)
    	{
			Debug.e(e);
		}
	}
	private void loadSubMenuGraphics()
	{
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/subMenu/");
		subMenuAtlas= new BuildableBitmapTextureAtlas(activity.getTextureManager(),1024,1024,TextureOptions.BILINEAR);
		submenu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(subMenuAtlas, activity,"menu_bg.gif");
		submenu_item1_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(subMenuAtlas, activity, "level.jpg");
		
		try 
    	{
			this.subMenuAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			this.subMenuAtlas.load();
		} 
    	catch (final TextureAtlasBuilderException e)
    	{
			Debug.e(e);
		}

		
	}
	private void loadSubMenuAudio()
	{
		
	}
	
	private void loadSubMenuFonts()
	{
		FontFactory.setAssetBasePath("font/");
		final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "font.ttf", 50, true, Color.WHITE, 2, Color.BLACK);
		font.load();
	}
	
	public static void prepareManager(Engine engine, MainActivity activity,
			Camera camera, VertexBufferObjectManager vbom) {
		getInstance().engine = engine;
		getInstance().activity = activity;
		getInstance().camera = camera;
		getInstance().vbom = vbom;
	}

	public void unloadGameTextures()
	{
	    // TODO (Since we did not create any textures for game scene yet)
	}
	
	
}
