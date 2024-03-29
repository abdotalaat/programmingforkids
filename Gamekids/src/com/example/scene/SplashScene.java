package com.example.scene;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.example.base.BaseScene;
import com.example.manager.SceneManager.SceneType;
import org.andengine.engine.camera.Camera;

public class SplashScene extends BaseScene {

	private Sprite splash;

	@Override
	public void createScene() {
		// TODO Auto-generated method stub

		splash = new Sprite(0, 0, resourcesManager.splash_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		};

		splash.setScale(1.5f);
		splash.setPosition(400, 240);
		attachChild(splash);

	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_SPLASH;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		splash.detachSelf();
		splash.dispose();
		this.detachSelf();
		this.dispose();

	}

}
