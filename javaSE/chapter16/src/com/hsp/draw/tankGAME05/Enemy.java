package com.hsp.draw.tankGAME05;


import java.util.Vector;

public class Enemy extends Tank implements Runnable {
    Vector<Enemy> enemies = new Vector<>();
    private Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;

    public Enemy(int x, int y, int direct) {
        super(x, y, direct);
    }

    public void setEnemies(Vector<Enemy> enemies) {
        this.enemies = enemies;
    }

    //判断敌人的坦克是否相互碰撞
    public boolean Touch() {
        switch (this.getDirect()) {
            case 0: {
                for (int i = 0; i < enemies.size(); i++) {//当前坦克和所有其他坦克比较
                    Enemy enemy = enemies.get(i);
                    if (this == enemy) {
                        continue;
                    }
                    switch (enemy.getDirect()) {
                        case 0://其他上下(x,x+40) (y,y+60)
                        case 2: {
                            if (((this.getX() >= enemy.getX())
                                    && (this.getX() <= enemy.getX() + 40)
                                    && (this.getY()) >= enemy.getY()
                                    && (this.getY() <= enemy.getY() + 60)) //[x,y]
                                    || ((this.getX() + 40 >= enemy.getX())
                                    && (this.getX() + 40 <= enemy.getX() + 40)
                                    && (this.getY() >= enemy.getY())
                                    && (this.getY() <= enemy.getY() + 60))) {//[x+40,y]
                                return true;
                            }
                            break;
                        }
                        case 1://左右(x,x+60) (y,y+40)
                        case 3: {
                            if (((this.getX() >= enemy.getX())
                                    && (this.getX() <= enemy.getX() + 60)
                                    && (this.getY()) >= enemy.getY()
                                    && (this.getY() <= enemy.getY() + 40)) //[x,y]
                                    || ((this.getX() + 40 >= enemy.getX())
                                    && (this.getX() + 40 <= enemy.getX() + 60)
                                    && (this.getY() >= enemy.getY())
                                    && (this.getY() <= enemy.getY() + 40))) {//[x+40,y]
                                return true;
                            }
                            break;
                        }
                    }
                }
                break;
            }
            case 1: {
                for (int i = 0; i < enemies.size(); i++) {//当前坦克和所有其他坦克比较
                    Enemy enemy = enemies.get(i);
                    if (this == enemy) {
                        return false;
                    }
                    switch (enemy.getDirect()) {
                        case 0://其他上下(x,x+40) (y,y+60)
                        case 2: {
                            if (((this.getX() + 60 >= enemy.getX())
                                    && (this.getX() + 60 <= enemy.getX() + 40)
                                    && (this.getY()) >= enemy.getY()
                                    && (this.getY() <= enemy.getY() + 60)) //[x+60,y]
                                    || ((this.getX() + 60 >= enemy.getX())
                                    && (this.getX() + 60 <= enemy.getX() + 40)
                                    && (this.getY() + 40 >= enemy.getY())
                                    && (this.getY() + 40 <= enemy.getY() + 60))) {//[x+60,y+40]
                                return true;
                            }
                            break;
                        }
                        case 1://左右(x,x+60) (y,y+40)
                        case 3: {
                            if (((this.getX() + 60 >= enemy.getX())
                                    && (this.getX() + 60 <= enemy.getX() + 60)
                                    && (this.getY()) >= enemy.getY()
                                    && (this.getY() <= enemy.getY() + 40)) //[x+60,y]
                                    || ((this.getX() + 60 >= enemy.getX())
                                    && (this.getX() + 60 <= enemy.getX() + 60)
                                    && (this.getY() + 40 >= enemy.getY())
                                    && (this.getY() + 40 <= enemy.getY() + 40))) {//[x+60,y+40]
                                return true;
                            }
                            break;
                        }
                    }
                }
                break;
            }
            case 2: {
                for (int i = 0; i < enemies.size(); i++) {//当前坦克和所有其他坦克比较
                    Enemy enemy = enemies.get(i);
                    if (this == enemy) {
                        return false;
                    }
                    switch (enemy.getDirect()) {
                        case 0://其他上下(x,x+40) (y,y+60)
                        case 2: {
                            if (((this.getX() >= enemy.getX())
                                    && (this.getX() <= enemy.getX() + 40)
                                    && (this.getY() + 60 >= enemy.getY())
                                    && (this.getY() + 60 <= enemy.getY() + 60)) //[x,y+60]
                                    || ((this.getX() + 40 >= enemy.getX())
                                    && (this.getX() + 40 <= enemy.getX() + 40)
                                    && (this.getY() + 60 >= enemy.getY())
                                    && (this.getY() + 60 <= enemy.getY() + 60))) {//[x+40,y+60]
                                return true;
                            }
                            break;
                        }
                        case 1://左右(x,x+60) (y,y+40)
                        case 3: {
                            if (((this.getX() >= enemy.getX())
                                    && (this.getX() <= enemy.getX() + 60)
                                    && (this.getY() + 60) >= enemy.getY()
                                    && (this.getY() + 60 <= enemy.getY() + 40)) //[x,y+60]
                                    || ((this.getX() + 40 >= enemy.getX())
                                    && (this.getX() + 40 <= enemy.getX() + 60)
                                    && (this.getY() + 60 >= enemy.getY())
                                    && (this.getY() + 60 <= enemy.getY() + 40))) {//[x+40,y+60]
                                return true;
                            }
                            break;
                        }
                    }
                }
                break;
            }
            case 3: {
                for (int i = 0; i < enemies.size(); i++) {//当前坦克和所有其他坦克比较
                    Enemy enemy = enemies.get(i);
                    if (this == enemy) {
                        return false;
                    }
                    switch (enemy.getDirect()) {
                        case 0://其他上下(x,x+40) (y,y+60)
                        case 2: {
                            if (((this.getX() >= enemy.getX())
                                    && (this.getX() <= enemy.getX() + 40)
                                    && (this.getY() >= enemy.getY())
                                    && (this.getY() <= enemy.getY() + 60)) //[x,y]
                                    || ((this.getX() >= enemy.getX())
                                    && (this.getX() <= enemy.getX() + 40)
                                    && (this.getY() + 40 >= enemy.getY())
                                    && (this.getY() + 40 <= enemy.getY() + 60))) {//[x,y+40]
                                return true;
                            }
                            break;
                        }
                        case 1://左右(x,x+60) (y,y+40)
                        case 3: {
                            if (((this.getX() >= enemy.getX())
                                    && (this.getX() <= enemy.getX() + 60)
                                    && (this.getY()) >= enemy.getY()
                                    && (this.getY() <= enemy.getY() + 40)) //[x,y]
                                    || ((this.getX() >= enemy.getX())
                                    && (this.getX() <= enemy.getX() + 60)
                                    && (this.getY() + 40 >= enemy.getY())
                                    && (this.getY() + 40 <= enemy.getY() + 40))) {//[x,y+40]
                                return true;
                            }
                            break;
                        }
                    }
                }
                break;
            }
        }
        return false;
    }

    @Override
    public void run() {
        while (/*isLive*/true) {
            //子弹移动
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
                this.shots.add(shot);
                new Thread(shot).start();
            }


            //坦克移动
            switch (getDirect()) {//根据本来的方向前进
                case 0: {
                    for (int i = 0; i < 30; i++) {//移动30步后改变方向
                        if (getY() > 0 && !this.Touch()) {
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
                        if (getX() + 60 < 900 && !this.Touch()) {
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
                        if (getY() + 60 < 600 && !this.Touch()) {
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
                        if (getX() > 0 && !this.Touch()) {
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
