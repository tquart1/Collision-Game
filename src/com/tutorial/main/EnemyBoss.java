package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {
	private Handler handler;
	Random r = new Random();
	private int timer = 80;
	private int timerT = 50;

	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		velX = 0;
		velY = 2;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 96, 96);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;

		timer--;
		if (timer <= 0)
			velY = 0;
		else
			timer--;

		if (timer <= 0)
			timerT--;
		if (timerT <= 0) {
			if (velX == 0)
				velX = 2;
			if (velX > 0)
				velX += 0.005f;
			else if (velX < 0)
				velX -= 0.005f;

			velX = Game.clamp(velX, -10, 10);
			int spawn = r.nextInt(10);
			if (spawn == 0)
				handler.addObject(new EnemyBossBullets((int) x + 48, (int) y + 48, ID.UnRighteousEnemy, handler));
		}

		// if( y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 96)
			velX *= -1;

		// handler.addObject(new Trail ((int)x, (int)y,Color.GREEN, ID.Trail,
		// 96, 96, 0.02f, handler));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 96, 96);

	}

}

