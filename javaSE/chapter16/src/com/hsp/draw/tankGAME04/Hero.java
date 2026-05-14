package com.hsp.draw.tankGAME04;

import java.util.Vector;

public class Hero extends Tank {
    private Shot shot = null;
    private Vector<Shot> shots = new Vector();
    private boolean live = true;
    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotFired() {
        switch (getDirect()) {
            case 0: {
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            }
            case 1: {
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            }
            case 2: {
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            }
            case 3: {
                shot = new Shot(getX(), getY() + 20, 3);
                break;
            }
        }
        if (shots.size() < 5) {//存活的子弹最多5颗
            shots.add(shot);//将新子弹加入Vector
        }
        new Thread(shot).start();

    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }



}


