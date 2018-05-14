package com.tutorial.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() {
		scoreKeep++;

		if (scoreKeep >= 450) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);

			if (hud.getLevel() == 2) {
				handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),
						ID.UnRighteousEnemy, handler));
			} else if (hud.getLevel() == 3) {
				handler.addObject(new UnRighteousEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),
						ID.UnRighteousEnemy, handler));
			} else if (hud.getLevel() == 4) {
				handler.addObject(new FreelanceEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),
						ID.FreelanceEnemy, handler));
			} else if (hud.getLevel() == 5) {
				handler.addObject(new FreelanceEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),
						ID.FreelanceEnemy, handler));
			} else if (hud.getLevel() == 6) {
				handler.addObject(new TheIntelligentDestructor(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),
						ID.TheIntelligentDestructor, handler));
			} else if (hud.getLevel() == 7) {
				handler.addObject(new TheIntelligentDestructor(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),
						ID.TheIntelligentDestructor, handler));
			} else if (hud.getLevel() == 10) {
				handler.clearEnemy();
				handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
			}
		}
	}
}
