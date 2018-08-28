package game.Gun;
import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;



import java.util.Random;

public class CreateGunKar98 extends GameObject {
    public Random rd;

    public CreateGunKar98() {
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
                                        GunKar98 gunKar98 = GameObjectManager.instance.recycle(GunKar98.class);
                                        gunKar98.position.set(700,2100);
                                        return true;
                                    }
                                }
                        )
                )
        );
    }
}