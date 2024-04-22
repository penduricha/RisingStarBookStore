package customEntities;

import java.awt.Color;


public class Custom_ColorPicker{
	private String mauSac;

	public static final Color blue_4B70F5 = new Custom_ColorPicker("4B70F5").toColor();
	public static final Color lightred_FF6666 = new Custom_ColorPicker("FF6666").toColor();
	public static final Color lavender_ED91FF = new Custom_ColorPicker("ED91FF").toColor();
	public static final Color coconut_FFF1E6 = new Custom_ColorPicker("FFF1E6").toColor();
	public static final Color lightgrey_D9D9D9 = new Custom_ColorPicker("D9D9D9").toColor();
	public static final Color lime_BFFF00 = new Custom_ColorPicker("BFFF00").toColor();
	public static final Color snowwhite_F2F0EB = new Custom_ColorPicker("F2F0EB").toColor();
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public Custom_ColorPicker(String mauSac) {
		setMauSac(mauSac);
	}
	
	public String getMauSac() {
		return mauSac;
	}

	public Color toColor() {
		return new Color(Integer.parseInt(mauSac,16),false);
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
}
