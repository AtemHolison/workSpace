package robot.ascii.impl;


import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;



public class Block implements Drawable
{

	private int blockHeight;
	private int row;
	private int col;
	
	
	public Block(int height, int col, int row) {
		this.blockHeight = height;
		this.row = row;
		this.col = col;
	}
	
	private TextColor.ANSI getBlockColor() {
		switch(this.blockHeight) {
			case 1:
				return TextColor.ANSI.YELLOW;
			case 2:
				return TextColor.ANSI.RED;
			case 3:
				return TextColor.ANSI.BLUE;
			default:
				return TextColor.ANSI.BLACK;
		}
	}
	
	@Override
	public void draw(SwingTerminalFrame terminalFrame)
	{
		
		int colPos = this.col;
		int rowPos = this.row;
			
		terminalFrame.setForegroundColor(this.getBlockColor());
		terminalFrame.setBackgroundColor(this.getBlockColor());
		
		// draw a 'bar' of height "draw_height" in middle column with scaling
		// NOTE: we translate to terminal co-ordinates where 0,0 is top left!
		
		for (int block = 0; block < blockHeight; block++)
		{
			
			
			for (int rowScale = 0; rowScale < Drawable.V_SCALE_FACTOR; rowScale++)
			{
				for (int colScale = 0; colScale < Drawable.H_SCALE_FACTOR; colScale++)
				{
					terminalFrame.setCursorPosition(colPos + colScale, rowPos);
					terminalFrame.putCharacter(Drawable.BLOCK_CHAR);
				}
				rowPos--;
			}
		}
	}
}
	

