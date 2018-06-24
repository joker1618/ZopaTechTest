package com.zopa.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ZopaUtils {

//	public static boolean isBlank(String source) {
//		return source == null || source.trim().isEmpty();
//	}

	public static double parseDouble(String source) throws ParseException {
		return getNumberFormat().parse(source).doubleValue();
	}
	public static String formatDouble(double num, int precision) {
		return formatDouble(num, precision, null);
	}
	public static String formatDouble(double num, int precision, RoundingMode roundingMode) {
		BigDecimal bigDec = new BigDecimal(num);
		if(precision >= 0 && roundingMode != null) {
			bigDec = bigDec.setScale(precision, roundingMode);
		}
		return getNumberFormat(precision).format(bigDec.doubleValue());
	}

	public static NumberFormat getNumberFormat() {
		return getNumberFormat(-1);
	}
	public static NumberFormat getNumberFormat(int precision) {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
		nf.setGroupingUsed(false);
		if(precision >= 0) {
			nf.setMinimumFractionDigits(precision);
			nf.setMaximumFractionDigits(precision);
		}
		return nf;
	}

	public static void display(String str, Object... params) {
		System.out.println(String.format(str, params));
	}
}
