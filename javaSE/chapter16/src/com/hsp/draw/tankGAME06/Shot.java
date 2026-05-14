package com.hsp.draw.tankGAME06;

public class Shot implements Runnable {
    private int x;
    private int y;
    private int direct;
    private int speed = 10;
    private boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (isLive) {
            switch (direct) {
                case 0: {
                    y -= speed;
                    break;
                }
                case 1: {
                    x += speed;
                    break;
                }
                case 2: {
                    y += speed;
                    break;
                }
                case 3: {
                    x -= speed;
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("x :" + x + "y: " + y);
            if (!(x >= 0 && x <= 900 && y >= 0 && y <= 600)) {
//                System.out.println("子弹消亡");
                this.isLive = false;
                break;
            }
        }
//        System.out.println("子弹消亡");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public boolean getIsLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
