package game.Gun;
import base.GameObject;
import base.GameObjectManager;
import game.player.BulletPlayer;
import game.player.Player;
import input.MouseInput;

import java.util.Random;

public class ShotGun extends GunObject {
    public ShotGun() {
        this.lastTime = 0;
        this.firingRate = 2;
        this.recoilRate = 20;
        this.bulletSpeed = 30;
        this.manaCost = 10;
    }

    @Override
    public void shoot(GameObject gameObject) {
        if (Player.instance.Mana > manaCost) {
            if (MouseInput.instance.clicked) {
                long currentTime = System.nanoTime();
                if (currentTime - this.lastTime >= 1_000_000_000 / firingRate) {
                    Random random = new Random();
                    int recoilY = 25 + recoilRate / 2 - random.nextInt(recoilRate);
                        BulletPlayer bulletPlayer1 = new BulletPlayer();
                        bulletPlayer1.position.set(gameObject.position);
                        bulletPlayer1.velocity.set(MouseInput.instance.vector2D.subtract(gameObject.position).subtract(0, recoilY).normalized().multiply(bulletSpeed));
                        GameObjectManager.instance.add(bulletPlayer1);
                    BulletPlayer bulletPlayer2 = new BulletPlayer();
                    bulletPlayer2.position.set(gameObject.position);
                    bulletPlayer2.velocity.set(MouseInput.instance.vector2D.subtract(gameObject.position).subtract(0, recoilY).normalized().multiply(bulletSpeed).rotate(5));
                    GameObjectManager.instance.add(bulletPlayer2);
                    BulletPlayer bulletPlayer3 = new BulletPlayer();
                    bulletPlayer3.position.set(gameObject.position);
                    bulletPlayer3.velocity.set(MouseInput.instance.vector2D.subtract(gameObject.position).subtract(0, recoilY).normalized().multiply(bulletSpeed).rotate(-5));
                    GameObjectManager.instance.add(bulletPlayer3);
                    BulletPlayer bulletPlayer4 = new BulletPlayer();
                    bulletPlayer4.position.set(gameObject.position);
                    bulletPlayer4.velocity.set(MouseInput.instance.vector2D.subtract(gameObject.position).subtract(0, recoilY).normalized().multiply(bulletSpeed).rotate(-10));
                    GameObjectManager.instance.add(bulletPlayer4);
                        this.lastTime = currentTime;
                        Player.instance.Mana -= manaCost;
                    }
                }
            }
        }
    }