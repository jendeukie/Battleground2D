package game.Gun;


import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;


import java.util.Random;

public class CreateGunAK47 extends GameObject {
    public Random rd;
    public CreateGunAK47() {
        this.rd = new Random();
        this.configAction();
    }

    public void configAction() {
        this.addAction(
                new LimitAction(
                        10,
                        new SequenceAction(
                                new WaitAction(150),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        GunAK47 GunAK47 = GameObjectManager.instance.recycle(GunAK47.class);
                                        GunAK47.position.set(450, 2000);
                                        return true;
                                    }
                                }
                        )
                )
        );
    }


}