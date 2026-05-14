package com.hsp.draw.tankGAME06;


import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int Kills = 0;
    private static Vector<Enemy> enemies = new Vector<>();
    private static String fileName = "E:\\java_code\\chapter16\\src\\record.txt";
    private static Vector<Node> nodes = new Vector<>();
    private static int  rKills = 0;

    public static int getrKills() {
        return rKills;
    }

    public static Vector<Node> getNodes() {
        return nodes;
    }

    public static void addKills() {
        Kills++;
    }

    //记录击杀数据
    public static void writeRecord() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(Kills + "");
            bw.newLine();
            System.out.println("Kills记录成功" + Kills);
            for (int i = 0; i < enemies.size(); i++) {
                Enemy e = enemies.get(i);
                bw.write(e.getX() + " " + e.getY() + " " + e.getDirect());
                bw.newLine();
            }
            System.out.println("坐标记录成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //恢复数据
    public static void readRecord() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            rKills = Integer.parseInt(br.readLine().trim());
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void setEnemies(Vector<Enemy> enemies) {
        Recorder.enemies = enemies;
    }

    public static int getKills() {
        return Kills;
    }

    public static void setKills(int kills) {
        Kills = kills;
    }
}
