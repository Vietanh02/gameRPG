package entity;



import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		worldX = gp.tileSize*7;
		worldY = gp.tileSize*7;
		speed = 4;
		direction = "up";
		
	}
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/Layer 1_birdFly1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/Layer 1_birdFly2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/Layer 1_birdFly3.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/Layer 1_birdFly4.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/Layer 1_birdFly5.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/Layer 1_birdFly6.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/Layer 1_birdFly7.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/Layer 1_birdFly8.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(keyH.upPressed == true) {
			direction = "up";
			worldY-=speed;
		}
		else if(keyH.downPressed == true) {
			direction = "down";
			worldY+=speed;
		}
		else if(keyH.leftPressed == true) {
			direction = "left";
			worldX-=speed;
		}
		else if(keyH.rightPressed == true) {
			direction = "right";
			worldX+=speed;
		}
		
		spriteCounter++;
		if(spriteCounter>8) {
			if(spriteNum == 1) {
				spriteNum =2;
			}
			else if(spriteNum ==2) {
				spriteNum = 3;
			}
			else if(spriteNum ==3) {
				spriteNum = 4;
			}
			else if(spriteNum ==4) {
				spriteNum = 5;
			}
			else if(spriteNum ==5) {
				spriteNum = 6;
			}
			else if(spriteNum ==6) {
				spriteNum = 7;
			}
			else if(spriteNum ==7) {
				spriteNum = 8;
			}
			else if(spriteNum ==8) {
				spriteNum = 1;
			}
			spriteCounter = 0;
			
		}
	}
	
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.titleSize, gp.titleSize);
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum ==1) {
				image = up1;
			}
			if(spriteNum ==2) {
				image = up2;
			}
			if(spriteNum ==3) {
				image = down1;
			}
			if(spriteNum ==4) {
				image = down2;
			}
			if(spriteNum ==5) {
				image = left1;
			}
			if(spriteNum ==6) {
				image = left2;
			}
			if(spriteNum ==7) {
				image = right1;
			}
			if(spriteNum ==8) {
				image = right2;
			}
			break;
		case "down":
			if(spriteNum ==1) {
				image = up1;
			}
			if(spriteNum ==2) {
				image = up2;
			}
			if(spriteNum ==3) {
				image = down1;
			}
			if(spriteNum ==4) {
				image = down2;
			}
			if(spriteNum ==5) {
				image = left1;
			}
			if(spriteNum ==6) {
				image = left2;
			}
			if(spriteNum ==7) {
				image = right1;
			}
			if(spriteNum ==8) {
				image = right2;
			}
			break;
		case "left":
			if(spriteNum ==1) {
				image = up1;
			}
			if(spriteNum ==2) {
				image = up2;
			}
			if(spriteNum ==3) {
				image = down1;
			}
			if(spriteNum ==4) {
				image = down2;
			}
			if(spriteNum ==5) {
				image = left1;
			}
			if(spriteNum ==6) {
				image = left2;
			}
			if(spriteNum ==7) {
				image = right1;
			}
			if(spriteNum ==8) {
				image = right2;
			}
			break;
		case "right":
			if(spriteNum ==1) {
				image = up1;
			}
			if(spriteNum ==2) {
				image = up2;
			}
			if(spriteNum ==3) {
				image = down1;
			}
			if(spriteNum ==4) {
				image = down2;
			}
			if(spriteNum ==5) {
				image = left1;
			}
			if(spriteNum ==6) {
				image = left2;
			}
			if(spriteNum ==7) {
				image = right1;
			}
			if(spriteNum ==8) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize,null);
	}
}