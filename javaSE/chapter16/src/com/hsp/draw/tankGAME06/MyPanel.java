package com.hsp.draw.tankGAME06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    int width = 900;
    int height = 600;
    Hero hero = null;
    Enemy enemy = null;
    Vector<Enemy> enemyVector = new Vector<>();
    Vector<Node> nodes = new Vector<>();

    int enemies = 3;
    //定义一个Vector，存放炸弹
    //当子弹击中坦克时就添加一个炸弹
    Vector<Bomb> bombs = new Vector<>();

    //三张爆炸图片
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String key) {
        Recorder.readRecord();
        nodes = Recorder.getNodes();
        this.hero = new Hero(400, 200, 0);
        switch (key){
            case "1":{
                for (int i = 0; i < enemies; i++) {
                    enemy = new Enemy(100 + i * 100, i, 2);//初始化敌方坦克
                    new Thread(enemy).start();//初始化后开始移动
                    enemyVector.add(enemy);
                    Shot shot = null;
                    switch (enemy.getDirect()) {//初始化子弹
                        case 0: {
                            shot = new Shot(enemy.getX() + 20, enemy.getY(), 0);
                            break;
                        }
                        case 1: {
                            shot = new Shot(enemy.getX() + 60, enemy.getY() + 20, 1);
                            break;
                        }
                        case 2: {
                            shot = new Shot(enemy.getX() + 20, enemy.getY() + 60, 2);
                            break;
                        }
                        case 3: {
                            shot = new Shot(enemy.getX(), enemy.getY() + 20, 3);
                            break;
                        }
                    }
                    //把创建的敌人坦克付给Enemy中的Vector<Enemy>
                    enemy.setEnemies(enemyVector);
                    enemy.getShots().add(shot);
                    new Thread(shot).start();
                }
             break;
            }
            case "2":{
                Recorder.setKills(Recorder.getrKills());
                for (int i = 0; i < nodes.size(); i++) {
                    Node node =  nodes.get(i);
                    enemy = new Enemy(node.getX(), node.getY(), node.getDirect());//初始化敌方坦克
                    new Thread(enemy).start();//初始化后开始移动
                    enemyVector.add(enemy);
                    Shot shot = null;
                    switch (enemy.getDirect()) {//初始化子弹
                        case 0: {
                            shot = new Shot(enemy.getX() + 20, enemy.getY(), 0);
                            break;
                        }
                        case 1: {
                            shot = new Shot(enemy.getX() + 60, enemy.getY() + 20, 1);
                            break;
                        }
                        case 2: {
                            shot = new Shot(enemy.getX() + 20, enemy.getY() + 60, 2);
                            break;
                        }
                        case 3: {
                            shot = new Shot(enemy.getX(), enemy.getY() + 20, 3);
                            break;
                        }
                    }
                    //把创建的敌人坦克付给Enemy中的Vector<Enemy>
                    enemy.setEnemies(enemyVector);
                    enemy.getShots().add(shot);
                    new Thread(shot).start();
                }
            }
            break;
        }



        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/image/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/image/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/image/bomb_3.gif"));

        //播放音乐
        new AePlayWave("E:\\java_code\\chapter16\\src\\111.wav").start();
    }

    //判断子弹是否击中坦克
    public void hitTank(Shot shot, Tank tank) {
        if (tank instanceof Enemy) {
            Enemy enemy = (Enemy) tank;
            switch (enemy.getDirect()) {
                case 0:
                case 2: {//炮筒向上
                    if ((shot.getX() > enemy.getX() && shot.getX() < enemy.getX() + 40) &&
                            (shot.getY() > enemy.getY() && shot.getY() < enemy.getY() + 60)
                    ) {
                        shot.setLive(false);
                        enemy.setLive(false);
                        Recorder.addKills();
                        enemyVector.remove(enemy);//击中的坦克从Vector中移除
                        //创建bomb对象，加入bombs
                        Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                        bombs.add(bomb);
                    }
                    break;
                }
                case 1:
                case 3: {
                    if ((shot.getX() > enemy.getX() && shot.getX() < enemy.getX() + 60) &&
                            (shot.getY() > enemy.getY() && shot.getY() < enemy.getY() + 40)
                    ) {
                        shot.setLive(false);
                        enemy.setLive(false);
                        Recorder.addKills();
                        enemyVector.remove(enemy);
                        //创建bomb对象，加入bombs
                        Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                        bombs.add(bomb);
                    }
                    break;
                }
            }
        } else if (tank instanceof Hero) {
            Hero hero = (Hero) tank;
            switch (hero.getDirect()) {
                case 0:
                case 2: {//炮筒向上
                    if ((shot.getX() > hero.getX() && shot.getX() < hero.getX() + 40) &&
                            (shot.getY() > hero.getY() && shot.getY() < hero.getY() + 60)
                    ) {
                        shot.setLive(false);
                        hero.setLive(false);
                        //创建bomb对象，加入bombs
                        Bomb bomb = new Bomb(hero.getX(), hero.getY());
                        bombs.add(bomb);
                    }
                    break;
                }
                case 1:
                case 3: {
                    if ((shot.getX() > hero.getX() && shot.getX() < hero.getX() + 60) &&
                            (shot.getY() > hero.getY() && shot.getY() < hero.getY() + 40)
                    ) {
                        shot.setLive(false);
                        hero.setLive(false);
                        //创建bomb对象，加入bombs
                        Bomb bomb = new Bomb(hero.getX(), hero.getY());
                        bombs.add(bomb);
                    }
                    break;
                }
            }
        }

    }

    public void showInf(Graphics g) {
        Font font = new Font("宋体", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("您累计击毁的敌方坦克", width + 20, 30);
        g.drawString(Recorder.getKills() + "", width + 100, 88);
        drawTank(width + 20, 50, g, 0, 0);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, width, height);//坦克运动区域
        showInf(g);
        if (hero != null && hero.isLive()) {//判断我方坦克是否存活
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);//绘制我方坦克
        }

        //我方发射子弹
        for (int i = 0; i < hero.getShots().size(); i++) {
            Shot shot = hero.getShots().get(i);
            if (shot != null && shot.getIsLive()) {//先判断getShot()是否为null
                g.fill3DRect(shot.getX(), shot.getY(), 5, 5, false);//绘制我方炮弹
            } else {
                hero.getShots().remove(shot);
            }
        }
        //绘制敌方坦克和敌方炮弹
        for (int i = 0; i < enemyVector.size(); i++) {
            Enemy enemy = enemyVector.get(i);
            if (enemy.isLive()) {//判断敌人坦克是否存活
                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 0);

                for (int j = 0; j < enemy.getShots().size(); j++) {
                    if (enemy.getShots().get(j).getIsLive()) {//绘制敌方炮弹
                        g.fill3DRect(enemy.getShots().get(j).getX(), enemy.getShots().get(j).getY(), 5, 5, false);//绘制敌方炮弹
                    } else {
                        enemy.getShots().remove(j);
                    }
                }

            }
        }
        //绘制爆炸效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            for (int j = 0; j < bomb.getLife(); j++) {
                if (bomb.isLive()) {
                    if (bomb.getLife() > bomb.getLife() * 2 / 3) {
                        g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
                    } else if (bomb.getLife() > bomb.getLife() / 3) {
                        g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
                    } else {
                        g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
                    }
                }
                bomb.downLife();
                if (bomb.getLife() == 0) {
                    bombs.remove(bomb);
                }
            }
        }

    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0: {//自己
                g.setColor(Color.cyan);
                break;
            }
            case 1: {//敌人
                g.setColor(Color.red);
                break;
            }
        }
        //direct 0,1,2,3 ,上右下右
        switch (direct) {
            case 0: {//炮筒向上
                g.fill3DRect(x, y, 10, 60, false);//左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//炮身
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            }
            case 1: {//右边
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            }
            case 2: {
                g.fill3DRect(x, y, 10, 60, false);//左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//炮身
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            }
            case 3: {
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override//0,1,2,3 ,上右下左
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            if (hero != null && hero.getY() > 0) {
                hero.moveUp();
                hero.setDirect(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (hero != null && hero.getY() + 60 < height) {
                hero.moveDown();
                hero.setDirect(2);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (hero != null && hero.getX() > 0) {
                hero.moveLeft();
                hero.setDirect(3);
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (hero != null && hero.getX() + 60 < width) {
                hero.moveRight();
                hero.setDirect(1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
          /*  发射一颗子弹
          if (hero.getShot() == null || !hero.getShot().getIsLive()) {//判断当前子弹是否消亡
                //第一次是因为shot为空，
                // 后面是因为越界或者击中getShot().getIsLive()为false
                hero.shotFired();
            }*/
            if (hero != null) {
                hero.shotFired();//发射多颗子弹
            }
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断是否击中敌人坦克
            hitEnemyTank();
            //判断子弹是否击中我方坦克
            hitHeroTank();
            repaint();
            //把存活的坦克给给Record
            Recorder.setEnemies(enemyVector);

        }
    }

    public void hitEnemyTank() {//判断我方所有子弹是否，击中敌方
        for (int i = 0; i < enemyVector.size(); i++) {
            Enemy enemy1 = enemyVector.get(i);
            if (hero != null) {
                for (int j = 0; j < hero.getShots().size(); j++) {//遍历每一个子弹
                    Shot shot = hero.getShots().get(j);
                    if (shot != null && shot.getIsLive()) {//要先判断hero.getShot()是否为空
                        hitTank(shot, enemy1);
                    }
                }
            }
        }
    }

    public void hitHeroTank() {//判断敌方所有子弹是否，击中我
        for (int i = 0; i < enemyVector.size(); i++) {
            Enemy enemy = enemyVector.get(i);
            for (int j = 0; j < enemy.getShots().size(); j++) {
                Shot shot = enemy.getShots().get(j);
                if (hero.isLive() && shot != null && shot.getIsLive()) {
                    hitTank(shot, hero);
                }
            }
        }
    }


}
