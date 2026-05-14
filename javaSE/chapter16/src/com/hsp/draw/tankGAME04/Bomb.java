package com.hsp.draw.tankGAME04;

public class Bomb {
    private int x;
    private int y;
    private boolean isLive = true;//是否存活
    private int life = 9;//生命周期

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void downLife() {
        if (life > 0) {
            life--;
        }
        else {
            isLive = false;
        }
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
