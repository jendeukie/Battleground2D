package game.Gun;

public class AK47 extends GunObject {
    public AK47(){
        this.lastTime=0;
        this.firingRate = 10;
        this.recoilRate = 40;
        this.bulletSpeed = 17;
        this.manaCost = 5;
    }
}
