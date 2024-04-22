package customEntities;

import java.text.DecimalFormat;

public class CustomFormat {
	public static String formatMoneyVND(double money) {
		DecimalFormat decimalFormat = new DecimalFormat("#,###VND");
		return decimalFormat.format(money);
	}
	
	/*
	 * public static String formatMoneyVND(double money) { DecimalFormat
	 * decimalFormat = new DecimalFormat("#,###VND"); return
	 * decimalFormat.format(money); }
	 */
}
