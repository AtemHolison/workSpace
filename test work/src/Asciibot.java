package robot.ascii;

import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import control.RobotControl;
import robot.Robot;
import robot.ascii.impl.Bar;
import robot.ascii.impl.Block;
import robot.ascii.impl.Arm;
import robot.ascii.impl.Drawable;
import robot.impl.RobotImpl;
import robot.impl.RobotInitException;

// ASCIIBot template code Programming 1 s1, 2018
// designed by Caspar, additional code by Ross
public class Asciibot extends AbstractASCIIBot implements Robot {
	public static void main(String[] args)
	{
		new RobotControl().control(new ASCIIBot(), null, null);
	}

	// MUST CALL DEFAULT SUPERCLASS CONSTRUCTOR!
	public ASCIIBot()
	{
		super();
	}
	
	// return the row number for the cursor
	// for convenience to be in an X Y plane
	// where 0, 0 starts at bottom left
	
	@Override
	public void init(int[] barHeights, int[] blockHeights, int height, int width, int depth)
	{
		// in addition to validating init params this also sets up keyboard support for
		// the ASCIIBot!
		try
		{
			RobotImpl.validateInitParams(this, barHeights, blockHeights, height, width, depth);
		} catch (RobotInitException e)
		{
			System.err.println(e.getMessage());
			System.exit(0);
		}

		
		
//		Block block = new Block(3,terminalFrame.getTerminalSize().getColumns(),fromY(0));
//		block.draw(terminalFrame);
		
//		Bar b = new Bar(3, fromY(0), 4);
//		b.draw(terminalFrame);
		
		int blocksColPos = terminalFrame.getTerminalSize().getColumns() - Drawable.H_SCALE_FACTOR;
		int blocksRowPos = terminalFrame.getTerminalSize().getRows();
		for(int blockHeight : blockHeights) {
			Block block = new Block(blockHeight, blocksColPos, blocksRowPos);
			block.draw(terminalFrame);
			delayAnimation();
			blocksRowPos -= blockHeight * Drawable.V_SCALE_FACTOR;
		}
		
		int barsColPos = 3 * Drawable.H_SCALE_FACTOR;
		int barsRowPos = terminalFrame.getTerminalSize().getRows();
		for(int barHeight : barHeights) {
			Bar bar = new Bar(barHeight, barsColPos, barsRowPos);
			bar.draw(terminalFrame);
			delayAnimation();
			barsColPos += Drawable.H_SCALE_FACTOR;
		}
		
		Arm arm = new Arm(9, 5, 2);
		arm.draw(terminalFrame);
		delayAnimation();
		
		
		
		
		
		
		
		
		
		
		
//		int blockRow = 0;
		//int blockCol = terminalFrame.getTerminalSize().getColumns() - 1;
//		for (int x = 0; x < blockHeights.length; x++)
//		{
//			int blockSize = blockHeights[x];
//			blockRow += blockSize;
//			Block block = new Block(blockSize, blockCol, blockRow);
//			
//			block.draw(terminalFrame);	
//		delayAnimation();
		}
//			int barRow = 0;
//			int barCol = terminalFrame.getTerminalSize().getColumns() - 16;
//			
//				for (int y = 0; y < barHeights.length; y++)
//				{
//					int barSize = barHeights[y];
//					barCol = barCol - 2;
//					barRow = barSize;
//					Bar bar = new Bar(barSize, barRow, barCol);
//					
//					bar.draw(terminalFrame);
//					delayAnimation();
//					}
//				
//					// write init code here to place bars, blocks and initial arm position
//					// suggest writing a separate method e.g. initImpl()
//
//					Arm arm = new Arm(4, 4, 4);
//
//					// clears previous frame/screen
//					terminalFrame.clearScreen();
//					// demo drawing method (for example purposes only)
//					//block.draw(terminalFrame);
//					//bar.draw(terminalFrame);
//					arm.draw(terminalFrame);
					// demoDraw();

					// call this to delay/animate and write out contents after draw
					// (i.e. after each robot move)
					//delayAnimation();
				//}
	
		
	

	// this is just a dummy method to show you how to draw chars using Lanterna
	// you need to implement the provided classes to do your own ASCIIBot robot
	// drawing!
	// REMOVE when done

	private void demoDraw()
	{
		// (0 index for terminal) hence -1
		int maxRow = terminalFrame.getTerminalSize().getRows() - 1;
		int maxCol = terminalFrame.getTerminalSize().getColumns() - 1;

		terminalFrame.setForegroundColor(Drawable.BAR_COLOR_FG);
		terminalFrame.setBackgroundColor(Drawable.BAR_COLOR_BG);

		// hard coded for demo purposes only
		int barHeight = 7;

		// draw a 'bar' of height "draw_height" in middle column with scaling
		// NOTE: we translate to terminal co-ordinates where 0,0 is top left!
		int rowPos = maxRow;
		for (int barSize = 0; barSize < barHeight; barSize++)
		{
			// apply vertical and horizontal scaling by looping to draw multiple chars
			for (int rowScale = 0; rowScale < Drawable.V_SCALE_FACTOR; rowScale++)
			{
				for (int colScale = 0; colScale < Drawable.H_SCALE_FACTOR; colScale++)
				{
					terminalFrame.setCursorPosition(maxCol / 2 + colScale, rowPos);
					terminalFrame.putCharacter(Drawable.BAR_CHAR);
				}
				rowPos--;
			}
		}
	}

	@Override
	public void pick()
	{

		// implement methods to draw robot environment using your implementation of
		// Arm.draw(), Bar.draw() etc.
		System.out.println("pick()");
	}

	@Override
	public void drop()
	{
		System.out.println("drop()");
	}

	@Override
	public void up()
	{
		System.out.println("up()");
	}

	@Override
	public void down()
	{
		System.out.println("down()");
	}

	@Override
	public void contract()
	{
		System.out.println("contract()");
	}

	@Override
	public void extend()
	{

		System.out.println("extend()");
	}

	@Override
	public void lower()
	{
		System.out.println("lower()");
	}

	@Override
	public void raise()
	{
		System.out.println("raise()");
	}
}
