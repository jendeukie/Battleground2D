package game.background;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class BackgroundTile extends GameObject {
    private int width;
    private int height;

    public BackgroundTile() {
        super();
        this.position = new Vector2D();
        width = 50;
        height = 50;

    }


    public static BackgroundTile create(int backgroundType) {
        BackgroundTile backgroundTile = new BackgroundTile();
        switch (backgroundType) {
            case 5:
                backgroundTile.renderer = new ImageRenderer("resources/PlatformImage/bgtile.png", backgroundTile.width, backgroundTile.height);
                break;


        }
        return backgroundTile;
    }


    public void run() {
        super.run();
    }
}
