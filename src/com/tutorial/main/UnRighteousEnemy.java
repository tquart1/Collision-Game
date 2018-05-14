package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class UnRighteousEnemy extends GameObject {
	
	private Handler handler;

	public UnRighteousEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		velX = 5;
		velY = 5;
	}
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if( y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if( x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail ((int)x, (int)y,Color.BLUE, ID.Trail, 16, 16, 0.01f, handler));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		
		
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
