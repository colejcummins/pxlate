import java.awt.Color;

public class NES {
	public static final Color[] NES_PALETTE = 
		new Color[]{NES.hex("#000000"),NES.hex("#0000FC"),NES.hex("#0000BC"),NES.hex("#4428BC"),NES.hex("#22123B"),
			NES.hex("#940084"),NES.hex("#A80020"),NES.hex("#A81000"),NES.hex("#881400"),NES.hex("#503000"),
			NES.hex("#007800"),NES.hex("#006800"),NES.hex("#005800"),NES.hex("#004058"),NES.hex("#00006C"),
			NES.hex("#0078F8"),NES.hex("#0058F8"),NES.hex("#6844FC"),NES.hex("#D800CC"),NES.hex("#E40058"),
			NES.hex("#F83800"),NES.hex("#E45C10"),NES.hex("#AC7C00"),NES.hex("#00B800"),NES.hex("#00A800"),
			NES.hex("#00A844"),NES.hex("#008888"),NES.hex("#3CBCFC"),NES.hex("#6888FC"),NES.hex("#543200"),
			NES.hex("#9878F8"),NES.hex("#F878F8"),NES.hex("#F85898"),NES.hex("#F87858"),NES.hex("#FCA044"),
			NES.hex("#F8B800"),NES.hex("#B8F818"),NES.hex("#58D854"),NES.hex("#58F898"),NES.hex("#00E8D8"),
			NES.hex("#FCFCFC"),NES.hex("#A4E4FC"),NES.hex("#B8B8F8"),NES.hex("#D8B8F8"),NES.hex("#360900"),
			NES.hex("#F8B8F8"),NES.hex("#F8A4C0"),NES.hex("#F0D0B0"),NES.hex("#FCE0A8"),NES.hex("#F8D878"),
			NES.hex("#D8F878"),NES.hex("#B8F8B8"),NES.hex("#B8F8D8"),NES.hex("#00FCFC"),NES.hex("#F8D8F8")};
	
	public static final Color[] NES_PALETTE_GRAY = 
		new Color[]{NES.hex("#000000"),NES.hex("#4E4E4E"),NES.hex("#7C7C7C"),NES.hex("#0000FC"),NES.hex("#0000BC"),NES.hex("#4428BC"),NES.hex("#22123B"),
			NES.hex("#940084"),NES.hex("#A80020"),NES.hex("#A81000"),NES.hex("#881400"),NES.hex("#503000"),
			NES.hex("#007800"),NES.hex("#006800"),NES.hex("#005800"),NES.hex("#004058"),NES.hex("#BCBCBC"),NES.hex("#00006C"),
			NES.hex("#0078F8"),NES.hex("#0058F8"),NES.hex("#6844FC"),NES.hex("#D800CC"),NES.hex("#E40058"),
		    NES.hex("#F83800"),NES.hex("#E45C10"),NES.hex("#AC7C00"),NES.hex("#00B800"),NES.hex("#00A800"),
		    NES.hex("#00A844"),NES.hex("#008888"),NES.hex("#3CBCFC"),NES.hex("#6888FC"),NES.hex("#543200"),
		    NES.hex("#9878F8"),NES.hex("#F878F8"),NES.hex("#F85898"),NES.hex("#F87858"),NES.hex("#FCA044"),
		    NES.hex("#F8B800"),NES.hex("#B8F818"),NES.hex("#58D854"),NES.hex("#58F898"),NES.hex("#00E8D8"),NES.hex("#787878"),
		    NES.hex("#FCFCFC"),NES.hex("#A4E4FC"),NES.hex("#B8B8F8"),NES.hex("#D8B8F8"),NES.hex("#360900"),
		    NES.hex("#F8B8F8"),NES.hex("#F8A4C0"),NES.hex("#F0D0B0"),NES.hex("#FCE0A8"),NES.hex("#F8D878"),
		    NES.hex("#D8F878"),NES.hex("#B8F8B8"),NES.hex("#B8F8D8"),NES.hex("#00FCFC"),NES.hex("#F8D8F8")};
	
	public static final Color[] EQ_PALETTE = palette(new Color[64]);
	
	public static Color[] palette(Color[] cArray) {
		for(int b = 0; b < 4; b++) {
			for(int g = 0; g < 4; g++) {
				for(int r = 0; r < 4; r++) {
					cArray[r + (g * 4) + (b * 16)] = new Color((r * 64) + 32, (g * 64) + 32, (b * 64) + 32);
				}
			}
		}
		return cArray;
	}
	
	public static Color hex(String color) {
		return new Color(
				Integer.valueOf(color.substring(1,3), 16),
				Integer.valueOf(color.substring(3,5), 16),
				Integer.valueOf(color.substring(5,7), 16));
	}
}