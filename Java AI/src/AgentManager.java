import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AgentManager extends JFrame {

	private int borderLeft;
	private int borderTop;
	private int canvasWidth;
	private int canvasHeight;
	private BufferedImage canvas;
	private Graphics gameGraphics;
	private Graphics canvasGraphics;
	private BufferedImage stageImg;
	private BufferedImage pathImg;
	private boolean finished;

	Agent[] myAgents;

	public AgentManager() {
		this.borderLeft = getInsets().left;
		this.borderTop = getInsets().top;
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		try {
			this.stageImg = ImageIO.read(new File("/Users/atemholison/Documents/Intro Prog/game/Turtle01s.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.canvasWidth = this.stageImg.getWidth();
		this.canvasHeight = this.stageImg.getHeight();

		setSize(this.canvasWidth, this.canvasHeight);

		this.canvas = new BufferedImage(this.canvasWidth, this.canvasHeight, BufferedImage.TYPE_INT_RGB);
		this.gameGraphics = getGraphics();
		this.canvasGraphics = this.canvas.getGraphics();
		
		
		
		this.pathImg=new BufferedImage(this.stageImg.getWidth(),this.stageImg.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
		
		int clrTrans= (0 << 24) + (0 << 16) + (0 << 8) + (0); //(red << 24) + (green << 16) + (blue << 8) + (alpha);
		
		for (int x=0;x<this.pathImg.getWidth();x++)
			for (int y=0;y<this.pathImg.getHeight();y++)
				this.pathImg.setRGB(x,y,clrTrans);

		
		clrTrans= (255 << 24) + (255 << 16) + (0 << 8) + (0); //(red << 24) + (green << 16) + (blue << 8) + (alpha);
		Random rng=new Random(System.nanoTime());
		this.myAgents = new Agent[1000];
		int i = 0;
		while (i < this.myAgents.length) {
			this.myAgents[i] = new Agent(this.stageImg,this.pathImg,Math.abs(rng.nextInt())%this.canvasWidth,Math.abs(rng.nextInt())%this.canvasHeight,clrTrans);
			i++;
		}
		
		
		int bestX,bestY;
		int bestValue,bestAgent;
		bestAgent=0;
		bestValue=this.myAgents[bestAgent].getEvaluation();
		bestX=this.myAgents[bestAgent].getX();
		bestY=this.myAgents[bestAgent].getY();
		
		i= 0;
		while (bestValue!=-1) {
			if (i% this.myAgents.length==0)
			{
				System.out.println("Current best: Agent:"+bestAgent+" at "+bestX+","+bestY+" -> "+bestValue);
				updateCanvas();
			}

			this.myAgents[i% this.myAgents.length].climb();
			
			if (this.myAgents[i% this.myAgents.length].getEvaluation()>bestValue)
			{
				bestValue=this.myAgents[i% this.myAgents.length].getEvaluation();
				bestX=this.myAgents[i% this.myAgents.length].getX();
				bestY=this.myAgents[i% this.myAgents.length].getY();
				bestAgent=i% this.myAgents.length;
			}
			i++;
		}
		System.out.println("Final best: Agent:"+bestAgent+" at "+bestX+","+bestY+" -> "+bestValue);
	}

	public void updateCanvas() {
		long start = System.nanoTime();

		// Draw stage
		this.canvasGraphics.drawImage(this.stageImg, 0, 0, null);
		this.canvasGraphics.drawImage(this.pathImg,0,0,null);
		// Draw everything.
		this.gameGraphics.drawImage(this.canvas, this.borderLeft/* +3 */, this.borderTop/* +37 */, this);

		long end = System.nanoTime();
		this.gameGraphics.drawString("FPS: " + String.format("%2d", (int) (1000000000.0 / (end - start))),
				this.borderLeft + 50, this.borderTop + 50);

	}

	public static void main(String[] args) {
		AgentManager mgr = new AgentManager();

	}

}
