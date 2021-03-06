package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;  // lưu các ô của bản đồ
	public int[][] mapTileNum; // vẽ theo tọa đồ Oxy, ví dụ (0,1) là tường thì chèn ảnh tường vaò vị trí (0,1)
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/map01.txt");
	}
	
	// nhập các ảnh wall, water, grass vào mảng tile
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[2].collision = true;
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//tải map 01. quy định 0 là cỏ, 1 là tường 2 là nước, xem res/map01.txt
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			int col =0;
			int row =0;
			while(col<gp.maxWorldCol && row<gp.maxWorldRow) {
				String line = br.readLine();
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					System.out.println(mapTileNum[col][row]);
					col++;
				}
				if(col == gp.maxWorldCol) {
					col=0;
					row++;
				}
			}
			br.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public void draw(Graphics2D g2) {
		for(int i =0;i<=15;i++) {
			g2.drawImage(tile[0].image, 0, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 48, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 96, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 144, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 192, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 240, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 288, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 336, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 384, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 432, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 480, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 528, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 576, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 624, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 672, 48*i,gp.titleSize, gp.titleSize, null);
			g2.drawImage(tile[0].image, 720, 48*i,gp.titleSize, gp.titleSize, null);
		}
	}*/
	
	public void draw(Graphics2D g2) {
		
		int worldCol =0;
		int worldRow = 0;
		while(worldCol< gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			int tileNum = mapTileNum[worldCol][worldRow];
			int worldX = worldCol*gp.tileSize;
			int worldY = worldRow*gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			if(worldX + gp.tileSize  > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize  < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize  > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize  < gp.player.worldY + gp.player.screenY) {
			
				g2.drawImage(tile[tileNum].image, screenX, screenY,gp.tileSize, gp.tileSize, null);
			
			}
			
			worldCol++;
				
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
		
	}
		
}
