package robot.ascii.impl;

import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

public class Bar implements Drawable
{
	private int barHeight;
	private int row;
	private int col;
	
	
	
	public Bar(int height, int col, int row)  {
		
		this.barHeight = height;
		this.row = row;
		this.col = col;
	
	}
	
	@Override
	public void draw(SwingTerminalFrame terminalFrame)
	{
		terminalFrame.setForegroundColor(Drawable.BAR_COLOR_FG);
		terminalFrame.setBackgroundColor(Drawable.BAR_COLOR_BG);
	
		for (int bar = 0; bar < barHeight; bar++)
		{	
//			for (int y = 0; y < Drawable.V_SCALE_FACTOR; y++)
//			{
//				for (int x = 0; x < Drawable.H_SCALE_FACTOR; x++)
//				{
//					terminalFrame.setCursorPosition(this.col, this.row);
//					terminalFrame.putCharacter(Drawable.BAR_CHAR);
//				}
//				this.row--;
//			}
			for (int rowScale = 0; rowScale < Drawable.V_SCALE_FACTOR; rowScale++)
			{
				for (int colScale = 0; colScale < Drawable.H_SCALE_FACTOR; colScale++)
				{
					terminalFrame.setCursorPosition(this.col + colScale, this.row);
					terminalFrame.putCharacter(Drawable.BLOCK_CHAR);
				}
				this.row--;
			}
		}
	}
}
