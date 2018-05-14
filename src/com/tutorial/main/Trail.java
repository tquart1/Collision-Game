package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.AlphaComposite;
import java.awt.Color;

public class Trail extends GameObject {

	private float zalpha = 1;
	private Handler handler;
	private Color color;
	private float life;
	private int width, height;
	
	public Trail(int x, int y, Color color, ID id, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
		this.handler = handler;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(zalpha > life){
			zalpha -= (life - 0.0001f);
			}
		else handler.removeObject(this);
				
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(zalpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
		g2d.setComposite(makeTransparent(1));
		
	}
	private AlphaComposite makeTransparent(float zalpha){
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, zalpha);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
