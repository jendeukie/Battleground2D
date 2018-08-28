package game.Gun;
import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;



import java.util.Random;

public class CreateGunShotGun extends GameObject {
    public Random rd;

    public CreateGunShotGun() {
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
                                        GunShotGun gunShotGun = GameObjectManager.instance.recycle(GunShotGun.class);
                                        gunShotGun.position.set(500,2000);
                                        return true;
                                    }
                                }
                        )
                )
        );
    }
}