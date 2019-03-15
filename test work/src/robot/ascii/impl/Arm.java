package robot.ascii.impl;

import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import control.Control;
import robot.RobotMovement;

public class Arm implements RobotMovement, Drawable
{
	private int height;
	private int width;
	private int depth;
	
	public Arm (int height, int width, int depth) 
	{
		this.height = height;
		this.width = width;
		this.depth = depth;
	}
	
	@Override
	public void draw(SwingTerminalFrame terminalFrame)
	{
		this.drawHeight(terminalFrame);
		this.drawWidth(terminalFrame);
		
//		int maxRow = terminalFrame.getTerminalSize().getRows() - 1;
//		int minCol = terminalFrame.getTerminalSize().getColumns();
//
//		terminalFrame.setForegroundColor(Drawable.ARM_COLOR_FG);
//		terminalFrame.setBackgroundColor(Drawable.ARM_COLOR_BG);
//		
//		
//		// draw a 'bar' of height "draw_height" in middle column with scaling
//		// NOTE: we translate to terminal co-ordinates where 0,0 is top left!
//		this.row = maxRow;
//		for (int block = 0; block < height; block++)
//		{
//			// apply vertical and horizontal scaling by looping to draw multiple chars
//			for (int y = 0; y < Drawable.V_SCALE_FACTOR; y++)
//			{
//				for (int x = 0; x < Drawable.H_SCALE_FACTOR; x++)
//				{
//					terminalFrame.setCursorPosition(minCol/8, this.row);
//					terminalFrame.putCharacter(Drawable.ARM_CHAR);
//				}
//				this.row--;}}
		
	}
	
	private void drawHeight(SwingTerminalFrame terminalFrame) 
	{
		int row = terminalFrame.getTerminalSize().getRows();
		int col = 0;
		
		terminalFrame.setForegroundColor(Drawable.ARM_COLOR_FG);
		terminalFrame.setBackgroundColor(Drawable.ARM_COLOR_BG);
	
		for (int h = 0; h < this.height; h++)
		{	
			for (int rowScale = 0; rowScale < Drawable.V_SCALE_FACTOR; rowScale++)
			{
				for (int colScale = 0; colScale < Drawable.H_SCALE_FACTOR; colScale++)
				{
					terminalFrame.setCursorPosition(col + colScale, row);
					terminalFrame.putCharacter(Drawable.BLOCK_CHAR);
				}
				row--;
			}
		}
	}

	
	public void drawWidth(SwingTerminalFrame terminalFrame)
	{
		int row = terminalFrame.getTerminalSize().getRows() - this.height*V_SCALE_FACTOR + ARM1_WIDTH*V_SCALE_FACTOR;
		int col = H_SCALE_FACTOR;
		
		terminalFrame.setForegroundColor(Drawable.ARM_COLOR_FG);
		terminalFrame.setBackgroundColor(Drawable.ARM_COLOR_BG);
	
		for (int w = 0; w < this.width; w++)
		{	
			for (int rowScale = 0; rowScale < Drawable.V_SCALE_FACTOR; rowScale++)
			{
				for (int colScale = 0; colScale < Drawable.H_SCALE_FACTOR; colScale++)
				{
					terminalFrame.setCursorPosition(col + colScale, row);
					terminalFrame.putCharacter(Drawable.BLOCK_CHAR);
				}
				row--;
			}
		}
	}
	
	
	public void drawDepth(SwingTerminalFrame terminalFrame)
	{
//		int maxRow = terminalFrame.getTerminalSize().getRows() - 1;
//		int minCol = terminalFrame.getTerminalSize().getColumns();
//
//		terminalFrame.setForegroundColor(Drawable.ARM_COLOR_FG);
//		terminalFrame.setBackgroundColor(Drawable.ARM_COLOR_BG);
//		
//		
//		// draw a 'bar' of height "draw_height" in middle column with scaling
//		// NOTE: we translate to terminal co-ordinates where 0,0 is top left!
//		this.row = maxRow;
//		for (int block = 0; block < depth; block++)
//		{
//			// apply vertical and horizontal scaling by looping to draw multiple chars
//			for (int y = 0; y < Drawable.V_SCALE_FACTOR; y++)
//			{
//				for (int x = 0; x < Drawable.H_SCALE_FACTOR; x++)
//				{
//					terminalFrame.setCursorPosition(minCol/8, this.row);
//					terminalFrame.putCharacter(Drawable.ARM_CHAR);
//				}
//				this.row--;}}
//		
	}
	
	
	@Override
	public void pick()
	{
		
	}

	@Override
	public void drop()
	{

	}

	@Override
	public void up()
	{
		
	}

	@Override
	public void down()
	{

	}

	@Override
	public void contract()
	{

	}

	@Override
	public void extend()
	{

	}

	@Override
	public void lower()
	{

	}

	@Override
	public void raise()
	{

	}
}
