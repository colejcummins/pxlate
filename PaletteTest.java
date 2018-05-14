import java.awt.Color;

public class PaletteTest {
	
	public PaletteTest() {
		Color[] palette = NES.NES_PALETTE;
		ColorHash[] colors = new ColorHash[128];
		for (int i = 0; i < palette.length; i++) {
			ColorHash ch = new ColorHash(palette[i]);
			int pos = (ch.getColor().getBlue() + ch.getColor().getRed() + ch.getColor().getGreen());
		}
	}
	
	public static String getString(ColorHash[] colors) {
		String returnString = "";
		for(int i = 0; i < colors.length; i++) {
			ColorHash runner = colors[i];
			if(runner == null) 
				returnString += "[ null ]";
			while(runner != null) {
				Color c = runner.getColor();
				returnString += "[ " + String.valueOf(c.getBlue() + c.getGreen() + c.getRed()) + " ]  -->  ";
				runner = runner.next;
			}
			returnString += "\n";
		}
		return returnString;
	}
	
	private class ColorHash { 
		private Color color;
		private ColorHash next;
		
		private ColorHash(Color color) {
			this.color = color;
			this.next = null;
		}
		
		private void setNext(ColorHash next) {
			this.next = next;
		}
		
		private Color getColor() {
			return color;
		}
	}
}