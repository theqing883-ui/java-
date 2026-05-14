package com.hsp.draw.tankGAME04;


import java.util.Vector;

public class Enemy extends Tank implements Runnable {
    private Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;

    public Enemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (/*isLive*/true) {
            if (this.isLive && /*this.shots.isEmpty()*/this.shots.size() < 3) {
                Shot shot = null;
                switch (this.getDirect()) {//初始化子弹
                    case 0: {
                        shot = new Shot(this.getX() + 20, this.getY(), 0);
                        break;
                    }
                    case 1: {
                        shot = new Shot(this.getX() + 60, this.getY() + 20, 1);
                        break;
                    }
                    case 2: {
                        shot = new Shot(this.getX() + 20, this.getY() + 60, 2);
                        break;
                    }
                    case 3: {
                        shot = new Shot(this.getX(), this.getY() + 20, 3);
                        break;
                    }
                }
                this.getShots().add(shot);
                new Thread(shot).start();
            }
            //根据本来的方向前进
            switch (getDirect()) {
                case 0: {
                    for (int i = 0; i < 30; i++) {//移动30步后改变方向
                        if (getY() > 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                }
                case 1: {
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 900) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    break;
                }
                case 2: {
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 600) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                }
                case 3: {
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                }
            }
            setDirect((int) (Math.random() * 4));//转向
            if (!isLive) {//坦克被击中后不再移动
                break;
            }
        }
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
