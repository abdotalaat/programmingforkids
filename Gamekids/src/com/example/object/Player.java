package com.example.object;


import java.util.ArrayList;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.ease.EaseSineInOut;




public  class Player extends AnimatedSprite
{
	
	LoopEntityModifier loop;
	public static ArrayList<Character> pathWayArr ;
	public static int charArrIndex = 0;
	
	float intialPositionX;
	float intialPositionY;

	public Player(float pX, float pY, float pWidth, float pHeight,ITiledTextureRegion pTiledTextR,VertexBufferObjectManager vbom) 
	{
		super(pX, pY, pWidth, pHeight, pTiledTextR,vbom);
		pathWayArr = new ArrayList<Character>();
		intialPositionX = pX;
		intialPositionY = pY;
	}
	
	
	public void moveChar(char direction)
	{
		Path path = null;
		System.out.println("Before Switch");
		switch(direction) 
		{	
			case 'd':
				this.animate(new long[]{400, 400, 400}, 6, 8, true);
				path = new Path(3).to(this.getX(), this.getY()).to(this.getX(), this.getY() - 70);
				break;
			case 'r':
				this.animate(new long[]{200, 600, 200}, 3, 5, true);
				path = new Path(3).to(this.getX(), this.getY()).to(this.getX()+ 70, this.getY());
				System.out.println("After Switch");
				break;
			case 'u':
				this.animate(new long[]{200, 200, 200}, 0, 2, true);
				path = new Path(3).to(this.getX(), this.getY()).to(this.getX(), this.getY() + 70);
				break;
			case 'l':
				this.animate(new long[]{200, 200, 200}, 9, 11, true);
				path = new Path(3).to(this.getX(), this.getY()).to(this.getX() - 70, this.getY());
				break;
		}
		
		
		

		loop = new LoopEntityModifier(new LoopEntityModifier(new PathModifier(2, path, null, new myLoopListener(),EaseSineInOut.getInstance())), 2);
		this.registerEntityModifier(loop);
	}
	
	class myLoopListener implements IPathModifierListener
	{
		
		
		@Override
		public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
		{ 
			
			Player.this.unregisterEntityModifier(loop);
			Player.this.unregisterUpdateHandler(pEntity);
			Player.this.stopAnimation();
			
			System.out.println("-------------------------------------------"+charArrIndex);
			if(charArrIndex < pathWayArr.size() -1 && pathWayArr.get(charArrIndex+1) != null)
			{
				moveChar( pathWayArr.get(charArrIndex + 1) );
				charArrIndex ++;
			}
			else
			{
				charArrIndex = 0;
				pathWayArr.clear();
			}
			
		}

		@Override
		public void onPathStarted(PathModifier pPathModifier, IEntity pEntity) 
		{
				
		}

		@Override
		public void onPathWaypointStarted(PathModifier pPathModifier,IEntity pEntity, int pWaypointIndex) 
		{
			
		}

		@Override
		public void onPathFinished(PathModifier pPathModifier, IEntity pEntity) 
		{
			
		}
		
	}

	
	public void resetPlayer()
	{
		unregisterEntityModifier(loop);
		stopAnimation();
		setX(intialPositionX);
		setY(intialPositionY);
		pathWayArr.clear();
		charArrIndex = 0;
	}
	
}