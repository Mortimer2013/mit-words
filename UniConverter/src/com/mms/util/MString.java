/**
 * ကိုငွေထွန်း၏ Javascript ကွန်ဗာတာကို Java သို့ပြောင်းထားပါသည်။
 */
package com.mms.util;

/**
 * @author RENN
 * 
 */
public class MString {

	static String tallAA = "\u102B";
	static String AA = "\u102C";
	static String vi = "\u102D";
	static String ii = "\u102E";
	static String u = "\u102F";
	static String uu = "\u1030";
	static String ve = "\u1031";
	static String ai = "\u1032";
	static String ans = "\u1036";
	static String db = "\u1037";
	static String visarga = "\u1038";
	static String asat = "\u103A";
	static String ya = "\u103B";
	static String ra = "\u103C";
	static String wa = "\u103D";
	static String ha = "\u103E";
	static String zero = "\u1040";

	static String PTN_1 = "(([\u1000-\u101C\u101E-\u102A\u102C\u102E-\u103F\u104C-\u109F]))(\u1040)(?=\u0020)?";
	static String PTN_2 = "((\u101D))(\u1040)(?=\u0020)?";
	static String PTN_3 = "(([\u1000-\u101C\u101E-\u102A\u102C\u102E-\u103F\u104C-\u109F\u0020]))(\u1047)";

	public static String getZ2Uni(String zString) {

		String output = new String(zString);
		output = output.replaceAll("\u106A", " \u1009");
		output = output.replaceAll("\u1025(?=[\u1039\u102C])", "\u1009"); // new
		output = output.replaceAll("\u1025\u102E", "\u1026"); // new
		output = output.replaceAll("\u106B", "\u100A");
		output = output.replaceAll("\u1090", "\u101B");
		output = output.replaceAll("\u1040", zero);
		output = output.replaceAll("\u108F", "\u1014");
		output = output.replaceAll("\u1012", "\u1012");
		output = output.replaceAll("\u1013", "\u1013");
		output = output.replaceAll("[\u103D\u1087]", ha);
		output = output.replaceAll("\u103C", wa);
		output = output.replaceAll(
				"[\u103B\u107E\u107F\u1080\u1081\u1082\u1083\u1084]", ra);
		output = output.replaceAll("[\u103A\u107D]", ya);
		output = output.replaceAll("\u103E\u103B", ya + ha);
		output = output.replaceAll("\u108A", wa + ha);
		output = output.replaceAll("\u103E\u103D", wa + ha);
		output = output.replaceAll("(\u1031)?(\u103C)?([\u1000-\u1021])\u1064",
				"\u1064$1$2$3");
		output = output.replaceAll("(\u1031)?(\u103C)?([\u1000-\u1021])\u108B",
				"\u1064$1$2$3\u102D");
		output = output.replaceAll("(\u1031)?(\u103C)?([\u1000-\u1021])\u108C",
				"\u1064$1$2$3\u102E");
		output = output.replaceAll("(\u1031)?(\u103C)?([\u1000-\u1021])\u108D",
				"\u1064$1$2$3\u1036");
		output = output.replaceAll("\u105A", tallAA + asat);
		output = output.replaceAll("\u108E", vi + ans);
		output = output.replaceAll("\u1033", u);
		output = output.replaceAll("\u1034", uu);
		output = output.replaceAll("\u1088", ha + u);
		output = output.replaceAll("\u1089", ha + uu);
		output = output.replaceAll("\u1039", "\u103A");
		output = output.replaceAll("[\u1094\u1095]", db);
		output = output
				.replaceAll(
						"([\u1000-\u1021])([\u102C\u102D\u102E\u1032\u1036]){1,2}([\u1060\u1061\u1062\u1063\u1065\u1066\u1067\u1068\u1069\u1070\u1071\u1072\u1073\u1074\u1075\u1076\u1077\u1078\u1079\u107A\u107B\u107C\u1085])",
						"$1$3$2"); // new
		output = output.replaceAll("\u1064", "\u1004\u103A\u1039");
		output = output.replaceAll("\u104E", "\u104E\u1004\u103A\u1038");
		output = output.replaceAll("\u1086", "\u103F");
		output = output.replaceAll("\u1060", "\u1039\u1000");
		output = output.replaceAll("\u1061", "\u1039\u1001");
		output = output.replaceAll("\u1062", "\u1039\u1002");
		output = output.replaceAll("\u1063", "\u1039\u1003");
		output = output.replaceAll("\u1065", "\u1039\u1005");
		output = output.replaceAll("[\u1066\u1067]", "\u1039\u1006");
		output = output.replaceAll("\u1068", "\u1039\u1007");
		output = output.replaceAll("\u1069", "\u1039\u1008");
		output = output.replaceAll("\u106C", "\u1039\u100B");
		output = output.replaceAll("\u1070", "\u1039\u100F");
		output = output.replaceAll("[\u1071\u1072]", "\u1039\u1010");
		output = output.replaceAll("[\u1073\u1074]", "\u1039\u1011");
		output = output.replaceAll("\u1075", "\u1039\u1012");
		output = output.replaceAll("\u1076", "\u1039\u1013");
		output = output.replaceAll("\u1077", "\u1039\u1014");
		output = output.replaceAll("\u1078", "\u1039\u1015");
		output = output.replaceAll("\u1079", "\u1039\u1016");
		output = output.replaceAll("\u107A", "\u1039\u1017");
		output = output.replaceAll("\u107B", "\u1039\u1018");
		output = output.replaceAll("\u107C", "\u1039\u1019");
		output = output.replaceAll("\u1085", "\u1039\u101C");
		output = output.replaceAll("\u106D", "\u1039\u100C");
		output = output.replaceAll("\u1091", "\u100F\u1039\u100D");
		output = output.replaceAll("\u1092", "\u100B\u1039\u100C");
		output = output.replaceAll("\u1097", "\u100B\u1039\u100B");
		output = output.replaceAll("\u106F", "\u100E\u1039\u100D");
		output = output.replaceAll("\u106E", "\u100D\u1039\u100D");
		output = output.replaceAll(
				"(\u103C)([\u1000-\u1021])(\u1039[\u1000-\u1021])?", "$2$3$1");
		output = output
				.replaceAll("(\u103E)(\u103D)([\u103B\u103C])", "$3$2$1");
		output = output.replaceAll("(\u103E)([\u103B\u103C])", "$2$1");
		output = output.replaceAll("(\u103D)([\u103B\u103C])", "$2$1");

		// PTN1
		output = output.replaceAll(PTN_1, (null != "$1") ? "$1" + "\u101D"
				: "$0$1");

		// PTN2
		output = output.replaceAll(PTN_2, (null != "$1") ? "$1" + "\u101D"
				: "$0$1");

		// PTN3
		output = output.replaceAll(PTN_3, (null != "$1") ? "$1" + "\u101B"
				: "$0$1");

		output = output
				.replaceAll(
						"(\u1047)( ? = [\u1000 - \u101C\u101E - \u102A\u102C\u102E - \u103F\u104C - \u109F\u0020])",
						"\u101B");
		output = output
				.replaceAll(
						"(\u1031)?([\u1000-\u1021])(\u1039[\u1000-\u1021])?([\u102D\u102E\u1032])?([\u1036\u1037\u1038]{0,2})([\u103B-\u103E]{0,3})([\u102F\u1030])?([\u1036\u1037\u1038]{0,2})([\u102D\u102E\u1032])?",
						"$2$3$6$1$4$9$7$5$8");
		output = output.replaceAll(ans + u, u + ans);
		output = output.replaceAll("(\u103A)(\u1037)", "$2$1");

		return output;
	}
	
	public static String getUni2Z(String inString) {
		return inString;
	}
}
