package nhc.erp.common.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;

/**
 * @author 이승준
 *
 * 스트링 유틸
 */
public class StringUtil {
	public StringUtil() {
	}

	public static String fromDb(String str) {
		String tmpstr = new String();

		try {
			String s = ksc2uni(str);

			return s;
		} catch(UnsupportedEncodingException e) {
		    e.printStackTrace(System.err);
		}

		return tmpstr;
    }

    public static String ksc2uni(String kscstr) throws UnsupportedEncodingException {
    	if (kscstr == null) {
    		return " ";
    	} else {
    		return new String(kscstr.getBytes("KSC5601"), "8859_1");
    	}
    }

    public static String ms2euc(String kscstr) throws UnsupportedEncodingException {
    	if (kscstr == null) {
    		return " ";
    	} else {
    		return new String(kscstr.getBytes("MS949"), "euc-kr");
    	}
    }

    public static String euc2ms(String kscstr) throws UnsupportedEncodingException {
    	if (kscstr == null) {
    		return " ";
    	} else {
    		return new String(kscstr.getBytes("euc-kr"), "MS949");
    	}
    }

    public static String toDb(String str) {
        String tmpstr = new String();

        try {
        	tmpstr = uni2ksc(str);
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace(System.err);
        }

        return tmpstr;
    }

    public static String uni2ksc(String unicodestr) throws UnsupportedEncodingException {
    	if (unicodestr == null) {
    		return " ";
    	} else {
    		return new String(unicodestr.getBytes("8859_1"), "KSC5601");
    	}
    }

    public static String utf2uni(String kscstr) throws UnsupportedEncodingException {
    	if (kscstr == null) {
    		return " ";
    	} else {
    		return new String(kscstr.getBytes("UTF-8"), "8859_1");
    	}
    }

    public static String uni2utf(String unicodestr) throws UnsupportedEncodingException {
        if (unicodestr == null) {
        	return " ";
        } else {
        	return new String(unicodestr.getBytes("8859_1"), "UTF-8");
        }
    }

	public static String convertHtml(String _text) {
		StringBuffer html = new StringBuffer();
		String text = _text;

		int startindex = 0;
		int endindex = 0;

		while ((endindex = text.indexOf("\n", startindex)) > -1) {
			html.append(text.substring(startindex, endindex));
			html.append("<br>");
			startindex = endindex + 1;
		}
		html.append(text.substring(startindex,text.length()));

		return html.toString();
	}

  	/**
  	 * 문장을 HTML용으로 변환.
  	 *
  	 * @param s
  	 * @return
  	 */
  	public static String setTag(String s) {
  		int j = s.length();

  		StringBuffer stringbuffer = new StringBuffer(j + 500);

  		for (int i = 0; i < j ;i++) {
  			if (s.charAt(i) == '<') {
  				stringbuffer.append("&lt");
  			} else if (s.charAt(i) == '>') {
  				stringbuffer.append("&gt");
  			} else {
  				stringbuffer.append(s.charAt(i));
  			}
  		}

  		return stringbuffer.toString();
  	}

  	/**
  	 * HTML 사용 안 함.
  	 *
  	 * @param s
  	 * @return
  	 */
  	public static String setBr(String s) {
  		int j = s.length();

  		StringBuffer stringbuffer = new StringBuffer(j + 500);

  		for (int i = 0; i < j ;i++) {
  			if (s.charAt(i) == '\n') {
  				stringbuffer.append("<br>");
  			} else if (s.charAt(i) == '\r') {
  				stringbuffer.append("");
  			} else {
  				stringbuffer.append(s.charAt(i));
  			}
  		}

  		return stringbuffer.toString();
  	}

	/**
	 * HTML 사용 안 함.(공백으로 변환.)
	 *
	 * @param s
	 * @return
	 */
	public static String setSpace(String s) {
		int j = s.length();

		StringBuffer stringbuffer = new StringBuffer(j + 500);

		for (int i = 0; i < j; i++) {
			if (s.charAt(i) == '\n'){
				stringbuffer.append("\\n");
			} else if (s.charAt(i) == '\r') {
				stringbuffer.append("\\r");
			} else {
				stringbuffer.append(s.charAt(i));
			}
		}

		return stringbuffer.toString();
	}

	public static String setSpc(String _text) {
		StringBuffer html = new StringBuffer();
		String text = _text;

		int startindex = 0;
		int endindex = 0;

		while ((endindex = text.indexOf(" ", startindex)) > -1) {
			html.append(text.substring(startindex, endindex));
			html.append("&nbsp;");
			startindex = endindex + 1;
		}
		html.append(text.substring(startindex, text.length()));

		return html.toString();
	}

	public static String a2k(String str) {
		String rtn = null;

		try {
			rtn = (str == null) ? "" : new String(str.getBytes("8859_1"),"euc-kr");
		} catch (java.io.UnsupportedEncodingException e) {
		}

		return rtn;
	}

	public static String k2a(String str) {
		String rtn = null;

		try {
			rtn = (str == null) ? "" : new String(str.getBytes("euc-kr"),"8859_1");
		} catch (java.io.UnsupportedEncodingException e) {
		}

		return rtn;
	}

	/**
	 * 문자열 치환.(src : 검색할 문자열, oldstr : 변경할 문자, newstr : 대체할 문자)
	 *
	 * @param src
	 * @param oldstr
	 * @param newstr
	 * @return
	 */
	public static String replace(String src, String oldstr, String newstr) {
		if (src == null) {
			return null;
		}

		StringBuffer dest = new StringBuffer("");
		int len = oldstr.length();
		int srclen = src.length();
		int pos = 0;
		int oldpos = 0;

		while ((pos = src.indexOf(oldstr, oldpos)) >= 0) {
			dest.append(src.substring(oldpos, pos));
			dest.append(newstr);
			oldpos = pos + len;
		}

		if (oldpos < srclen) {
			dest.append(src.substring(oldpos, srclen));
		}

		return dest.toString();
	}

	/**
	 * SCRIPT에서 FORM필드의 VALUE값 SETTING시 사용.
	 *
	 * @param str
	 * @return
	 */
	static public String getScriptTag(String str) {
		if (str != null) {
			str = str.trim();
			str = replace(str, "\n", "\\n");
			str = replace(str, "\r", "");
			str = replace(str, "`|", "\\n");
			str = replace(str, "'", "\\'");
			str = replace(str, "\"", "\\\"");
			str = replace(str, "(", "\\(");
			str = replace(str, ")", "\\)");
			str = replace(str, "/", "\\/");
			str = replace(str, ",", "\\,");
			str = replace(str, "=", "\\=");
			str = replace(str, "-", "\\-");
			str = replace(str, "&", "\\&");
			str = replace(str, "#", "\\#");
			str = replace(str, "^", "\\^");
			str = replace(str, ";", "\\;");
			str = replace(str, ":", "\\:");
			str = replace(str, "*", "\\*");
			str = replace(str, "<", "\\<");
			str = replace(str, ">", "\\>");
		}

		return str;
	}

	/**
	 * TEXTFIELD에 VALUE값 SETTING시 사용
	 *
	 * @param str
	 * @return
	 */
	public static String getTextTag(String str) {
		if (str != null) {
			str = str.trim();
			str = replace(str, "\"", "&quot;");
			str = replace(str, "'", "&#39;");
		}

		return str;
	}

	static public String setTextTag(String str) {
		if (str != null) {
			str = str.trim();
			str = str.replaceAll("&amp;", "&");
			str = str.replaceAll("&apos;", "'");
		}

		return str;
	}

    /**
     * 문자를 숫자형으로 치환
     *
     * @param str
     * @return
     */
    public static int stoi(String str) {
        if (str == null) {
        	return 0;
        }

        if (str.equals("")) {
        	return 0;
        } else {
        	return Integer.valueOf(str).intValue();
        }
    }

    /**
     * 문자를 INT형으로 치환, 값이 NULL일 경우는 VAL로 돌려준다.
     *
     * @param str
     * @param val
     * @return
     */
    public static int stoi(String str, int val) {
        if (str == null) {
        	return val;
        }

        if (str.equals("")) {
        	return val;
        } else {
        	return Integer.valueOf(str).intValue();
        }
    }

    public static String removeChar(String value, char remove_char) {
		int flag = 0;
		String newval = "";
		int index = 0;
		int temp = 0;
		flag = value.indexOf(remove_char, 0);

        if (flag == -1)
            return value.trim();
        do {
        	index = value.indexOf(remove_char, temp);
        	if (index == -1) {
        		newval = newval.concat(value.substring(temp));
                break;
            }
        	newval = newval.concat(value.substring(temp, index));
            temp = index + 1;
        } while (true);

        return newval.trim();
    }

    public static String nullCheck(String original_val) {
    	if (original_val == null) {
    		return "";
    	} else {
    		return original_val;
    	}
    }

	public static String nullCheck(String original_val, String replace_val) {
		if (original_val == null  || original_val.equals("null") || "".equals(original_val)) {
			return replace_val;
		} else {
			return original_val;
		}
	}

	public static String nullCheck(String original_val, int replace_val) {
		if (original_val == null) {
			return replace_val + "";
		} else {
			return original_val;
		}
	}

	public static String nullCheck(Object original_val) {
		if (original_val == null) {
			return "";
		} else {
			return original_val.toString();
		}
	}

	public static boolean isEmpty(String str){
 		return (str == null || str.trim().equals(""));
 	}

	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}

	public static String nvl(Object value) {
		return nvl(value, "");
	}

	public static String nvl(Object inputValue, String returnValue) {
    	String inputValueStr = "";

    	if (inputValue != null) {
    		inputValueStr = String.valueOf(inputValue);
    	}

    	if (isEmpty(inputValueStr)) {
    		return returnValue;
    	} else {
    		return inputValueStr;
    	}
	}

	public static String voidNull(String param){
	    if (param == null) {
	    	return "";
	    }

	    if (param.trim().equals("")) {
	    	return "";
	    } else {
	         return param.trim();
	    }
	}

	public static String sha256Encode(String text) {
		String encodeString = "";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(text.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}

			encodeString = hexString.toString();
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}

	    return encodeString;
	}

	public static byte[] generateKey(String key) {
		byte[] desKey = new byte[8];
		byte[] bkey = key.getBytes();

	    if (bkey.length < desKey.length) {
	    	System.arraycopy(bkey, 0, desKey, 0, bkey.length);

	    	for (int i = bkey.length; i < desKey.length; i++)
	    		desKey[i] = 0;
	    } else
	    	System.arraycopy(bkey, 0, desKey, 0, desKey.length);

	    return desKey;
	}

	/**
	 * 받은 키워드를 콤마로 구분하여 DESC 정렬 쿼리로 변환
	 * @param searchKeyword
	 * @return
	 * @throws Exception
	 */
	public static String getSortTxtByReplace(String searchKeyword) throws Exception {
	    String sortTxt = searchKeyword;
	    if (sortTxt.contains(",")) sortTxt = sortTxt.replaceAll(",", "*1 DESC, ");
	    if (!sortTxt.isEmpty()) sortTxt += "*1 DESC";
	    return sortTxt;
	}

	/**
	 * 입력된 내용에서 태그를 제거하고 내용을 반환한다.
	 *
	 * @param inputValue
	 * @return
	 * @throws Exception
	 */
	public static String removeTag(String inputValue) throws Exception {
		String returnValue = "";

		inputValue = voidNull(inputValue);
		inputValue = StringEscapeUtils.unescapeHtml4(inputValue);
		inputValue = inputValue.replaceAll("<(/)?([a-zA-Z0-9]*)(\\s[a-zA-Z0-9]*=[^>]*)?(\\s)*(/)?>", "");
		returnValue = inputValue.replaceAll("<!--.*-->", "");

	    return returnValue;
	}

	public static String specialCharRemove(String value) {
		if (value == null) {
			return "";
		}
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        value = value.replaceAll(match, "");

        return value;
    }

	/**
	 * 스트링 변수의 매핑값을 맵에 담긴 값으로 치환
	 *
	 * @param content
	 * @param contentObj
	 * @return
	 */
	public static String setMappingString(String content, Map<String, String> contentObj) {
		String mapping = "";

		if (!((Map<String, String>)contentObj).isEmpty()) {
			for (Entry<String, String> val : contentObj.entrySet()) {
				String value = val.getValue();

				if (StringUtil.isNotEmpty(value)) {
					content = mapping = content.replace(val.getKey(), val.getValue());
				}
			}

			return mapping;
		} else {
			if (content == null || "null".equals(content)) {
				return "";
			} else {
				return content;
			}
		}
	}

	public static String uniCode(String args) {
		String text = args;
		String rtnVal = "";

		for (int i = 0; i < text.length(); i++) {
			rtnVal +=  "\\" + String.format("%04X%n", (int)text.charAt(i));
		}

		return rtnVal.replaceAll("\n", "").replaceAll("\r", "");
	}

	/**
     * 데이터를 암호화하는 기능
     *
     * @param  data 암호화할 데이터
     * @return String result 암호화된 데이터
     * @exception Exception
     */
    public static String encodeBinary(byte[] data) throws Exception {
		if (data == null) {
		    return "";
		}

		return new String(Base64.encodeBase64(data));
    }

    /**
     * 데이터를 복호화하는 기능
     *
     * @param  data 복호화할 데이터
     * @return String result 복호화된 데이터
     * @exception Exception
     */
    public static byte[] decodeBinary(String data) throws Exception {
    	return Base64.decodeBase64(data.getBytes());
    }

    public static String encodeURIComponent(String s) {
		String result = null;

		try {
			result = URLEncoder.encode(s, "UTF-8")
				.replaceAll("\\+", "%20")
				.replaceAll("\\%21", "!")
				.replaceAll("\\%27", "'")
				.replaceAll("\\%28", "(")
				.replaceAll("\\%29", ")")
				.replaceAll("\\%7E", "~");
		} catch (UnsupportedEncodingException e) {
			result = s;
		}

		return result;
	}

	 /**
      * numberFormat
      * 숫자형 String 데이터에 1000 단위 콤마(,)를 적용하여 리턴
      * @param num
      * @return
      */
    public static String numberFormat(String num) {
    	 return numberFormat(num, "#,###.###");
     }

	 /**
      * numberFormat
      * 숫자형 String 데이터에 포맷을 적용하여 리턴
      * @param num
      * @param format
      * @return
      */
    public static String numberFormat(String num, String format) {
    	 DecimalFormat Commas = new DecimalFormat(format);
    	 String result = "";

    	 try {
    		 BigDecimal bigdecimalNum = new BigDecimal(num);
    		 result = (String)Commas.format(bigdecimalNum);
    	 } catch (Exception e) {
    		 result = "";
    	 }

    	 return result;
     }

	 public static String nvl(String cValue, String rValue) {

    	String cValueStr = "";

    	if (cValue != null) {
    		cValueStr = String.valueOf(cValue);
    	}

        if (isEmpty(cValueStr)) {
        	return rValue;
        } else {
        	return cValueStr;
        }
    }

	/**
	 * 숫자로된 문자열 데이터를 넘겨받아 휴대폰 형식으로 변경하여 반환
	 *
	 * @param str
	 * @return
	 */
	public static String formatPhone(String str) {

		String result = str;
		if (result == null) {
			return "";
		}

		//입력받은 문자열의 숫자만 남기고 제거
		str = str.replaceAll("[^0-9]", "");

		if (str.length() == 8) {	//8자리인경우
			result =  str.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
		} else if (str.length() == 12) {
			result = str.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
		} else if(str.length() == 9 || str.length() == 10|| str.length() == 11){
			result = str.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
		}

		return result;
	}

	/**
     * For related string, fill the input length from the right with defined
     * string.<br>
     *
     * <pre>
     * BmStringUtil.rightPad(null, *, *) = null
     * BmStringUtil.rightPad("", 3, "z") = "zzz"
     * BmStringUtil.rightPad("bat", 3, "yz") = "bat"
     * BmStringUtil.rightPad("bat", 5, "yz") = "batyz"
     * BmStringUtil.rightPad("bat", 8, "yz") = "batyzyzy"
     * BmStringUtil.rightPad("bat", 1, "yz") = "bat"
     * BmStringUtil.rightPad("bat", -1, "yz") = "bat"
     * BmStringUtil.rightPad("bat", 5, null) = "bat  "
     * BmStringUtil.rightPad("bat", 5, "") = "bat  "
     * </pre>
     *
     * @param str
     *            the String to pad out, may be null
     * @param size
     *            the size to pad to
     * @param padStr
     *            the String to pad with, null or empty treated as single space
     * @return string that is padded <code>null</code> if null String input
     */
    public static String rightPad(String str, int size, String padStr) {
         return padString(str, size, padStr, false);
    }

    /**
    * For related string, fill the input length from the left with defined
    * string.<br>
    *
    * <pre>
    * BmStringUtil.leftPad(null, *, *) = null
    * BmStringUtil.leftPad("", 3, "z") = "zzz"
    * BmStringUtil.leftPad("bat", 3, "yz") = "bat"
    * BmStringUtil.leftPad("bat", 5, "yz") = "yzbat"
    * BmStringUtil.leftPad("bat", 8, "yz") = "yzyzybat"
    * BmStringUtil.leftPad("bat", 1, "yz") = "bat"
    * BmStringUtil.leftPad("bat", -1, "yz") = "bat"
    * BmStringUtil.leftPad("bat", 5, null) = "  bat"
    * BmStringUtil.leftPad("bat", 5, "") = "  bat"
    * </pre>
    *
    * @param str
    *            string to be modified
    * @param size
    *            size that includes letter for padding
    * @param padStr
    *            letter to fill in
    * @return string that is padded <code>null</code> if null String input
    */
    public static String leftPad(String str, int size, String padStr) {
         return padString(str, size, padStr, true);
    }

    private static String padString(String str, int size, String padStr, boolean isLeft) {
	     if (str == null) {
	          return null;
	     }
	     int originalStrLength = str.length();

	     if (size < originalStrLength) {
	    	 return str;
	     }

	     int difference = size - originalStrLength;

	     String tempPad = "";

	     if (difference > 0) {
	         if (padStr == null || "".equals(padStr)) {
	              padStr = " ";
	         }
	         do {
	              for (int j = 0; j < padStr.length(); j++) {
	                   tempPad += padStr.charAt(j);
	                   if (str.length() + tempPad.length() >= size) {
	                        break;
	                   }
	              }
	         } while (difference > tempPad.length());
	         if (isLeft) {
	              str = tempPad + str;
	         } else {
	              str = str + tempPad;
	         }
         }

         return str;
    }

    /**
	 * 스트링 변수의 문자열을 HTML ASCII 형식으로 변환
	 *
	 * @param content
	 * @param contentObj
	 * @return
	 */
	public static String strToHtmlAscii(String str) {
		if (StringUtil.isEmpty(str)) {
			return str;
		}

		char ch[] = str.toCharArray();

		String conStr = "";
		String chr = "";
		try {
			for (int aa= 0; ch.length > aa; aa++) {
				if (((int)ch[aa] >= 44032 && (int)ch[aa] <= 55296)
					|| ((int)ch[aa] >= 0 && (int)ch[aa] <= 13120)) {
					chr = ""+ch[aa];
				} else {
					chr = "&#"+ (int)ch[aa] + ";" ;
				}
				conStr = conStr + chr ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conStr;
	}
	
	@SuppressWarnings("deprecation")
	public static String StringToHexa(String OrgString) {
		if (OrgString == null)
			return "";
		if (OrgString.length() == 0)
			return "";
		byte[] tmp = new byte[OrgString.length() * 2];

		String HexaString = "";

		OrgString.getBytes(0, OrgString.length(), tmp, 0);
		tmp = OrgString.getBytes();

		for (int bi = 0; bi < OrgString.length(); bi++) {
			HexaString = HexaString + Integer.toHexString(tmp[bi] & 0xFF);
		}

		return HexaString;
	}

	public static String[] calComment(String paramString, int paramInt1, int paramInt2) {
		String[] arrayOfString = new String[paramInt2];
		String str1 = null;
		String str2 = null;
		if (paramString == null) {
			return null;
		}
		int i = 0;
		int j = 0;
		for (int k = 0; k < paramInt2; k++) {
			int m = 0;
			str1 = "";
			for (int n = i; n < paramString.length(); n++) {
				j++;
				str2 = paramString.substring(n, n + 1);
				m += length(str2);
				if (m > paramInt1) {
					j -= 1;
					break;
				}
				str1 = str1 + str2;
			}
			i = j;
			arrayOfString[k] = str1;
		}
		
		return arrayOfString;
	}

	public static int length(String paramString) {
		if (paramString == null) {
			return 0;
		}
		byte[] arrayOfByte = paramString.getBytes();
		int i = 0;
		try {
			i = arrayOfByte.length;
		} catch (Exception localException) {
		} finally {
		}

		return i;
	}
}