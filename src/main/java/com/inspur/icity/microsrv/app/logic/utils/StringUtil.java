package com.inspur.icity.microsrv.app.logic.utils;


import java.util.*;

/**
 * @Class StringUtil
 * @Description: 常用字符串及数组操作
 *
 * @Author sunchj
 * @CreateDate 2018/2/2 16:35
 *
 */
public class StringUtil {
	/** 
	 * Change the null string value to "", if not null, then return it self, use
	 * this to avoid display a null string to "null".
	 *
	 *  @param  input
	 *			the string to clear
	 *  @return  the result
	  */ 
	 public static String clearNull(String input) {
		 return  isEmpty(input)  ?   ""  : input;
	}

	/** 
	 * 转换由表单读取的数据的内码(从 ISO8859 转换到 gb2312).
	 *
	 *  @param  input
	 *			输入的字符串
	 *  @return  转换结果, 如果有错误发生, 则返回原来的值
	  */ 
	 public static String toChi(String input) {
		 try  {
			 byte [] bytes  =  input.getBytes( " ISO8859-1 " );
			 return   new  String(bytes,  " GBK " );
		} catch (Exception ex) {
		}
		 return  input;
	}

	/** 
	 * 转换由表单读取的数据的内码到 ISO(从 GBK 转换到ISO8859-1).
	 *
	 *  @param  input
	 *			输入的字符串
	 *  @return  转换结果, 如果有错误发生, 则返回原来的值
	  */ 
	 public static String toISO(String input) {
		 return  changeEncoding(input,  " GBK " ,  " ISO8859-1 " );
	}

	/** 
	 * 转换字符串的内码.
	 *
	 *  @param  input
	 *			输入的字符串
	 *  @param  sourceEncoding
	 *			源字符集名称
	 *  @param  targetEncoding
	 *			目标字符集名称
	 *  @return  转换结果, 如果有错误发生, 则返回原来的值
	  */ 
	 public static String changeEncoding(String input, String sourceEncoding,
			String targetEncoding) {
		 if(input ==  null || "".equals(input)) {
			 return  input;
		}

		 try  {
			 byte [] bytes  =  input.getBytes(sourceEncoding);
			 return   new  String(bytes, targetEncoding);
		} catch (Exception ex) {
		}
		 return  input;
	}


	/** 
	 * 对给定字符进行 URL 编码
	  */ 
	 public static String encode(String value) {
	 	if(isEmpty(value)) {
			 return   "" ;
		}

		 try  {
			value  =  java.net.URLEncoder.encode(value,  " GB2312 " );
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		 return  value;
	}

	/** 
	 * 对给定字符进行 URL 解码
	 *
	 *  @param  value
	 *			解码前的字符串
	 *  @return  解码后的字符串
	  */ 
	 public static String decode(String value) {
	 	if(isEmpty(value)) {
			 return   "" ;
		}

		 try  {
			 return  java.net.URLDecoder.decode(value,  " GB2312 " );
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		 return  value;
	}
	 
	/** 
	  * 判断list是否未空, 如果不为 null 或者长度大于0, 均返回 true.
	   */ 
	  public static  boolean  isNotEmptyList(List<?> input) {
		  return  (input  !=   null   &&  input.size()  >   0 );
	 }

	/** 
	  * 判断list是否未空, 如果不为 null 或者长度大于0, 均返回 true.
	   */ 
	  public static  boolean  isEmptyList(List<?> input) {
		  return  (input ==  null || input.size() == 0 );
	 }
	  
	 /** 
	   * 判断map是否未空, 如果不为 null 或者长度大于0, 均返回 true.
		*/ 
	   public static  boolean  isEmptyMap(Map<?,?> input) {
		   return  (input ==  null || input.size() ==  0 );
	  }
	  /** 
		* 判断map是否未空, 如果不为 null 或者长度大于0, 均返回 true.
		 */ 
		public static  boolean  isNotEmptyMap(Map<?,?> input) {
			return  !isEmptyMap(input);
	   }

	/**
	 * 判断字符串数组是否未空, 如果不为 null 或者长度大于0, 均返回 .
	 */
	public static  boolean  isEmptyArray(Object[] input) {
		return  (input ==  null || input.length ==  0 );
	}

	/** 
	  * 判断字符串数组是否未空, 如果不为 null 或者长度大于0, 均返回 .
	   */ 
	  public static  boolean  isNotEmptyArray(Object[] input) {
		  return  !isEmptyArray(input);
	 }
	 

	/** 
	 * 判断字符串是否未空, 如果为 null 或者长度为0, 均返回 true.
	  */ 
	 public static  boolean  isEmpty(String input) {
		 return null == input || isBlank(input.trim()) || "null".equals(input.trim().toLowerCase());
		 //return  (input ==  null || input.length() ==  0 );
	}
	 
	/** 
	  * 判断字符串是否未空, 如果为 null 或者长度为0, 均返回 true.
	   */ 
	  public static  boolean  isNotEmpty(String input) {
		  return  !isEmpty(input);
	 }
	  
	/** 
	 * 判断字符串是否未空, 如果为 null 或者长度为0, 均返回 true.
	  */ 
	 public static  boolean  isEmptyStringObject(Object input) {
		 return  (input ==  null || input.toString().length() ==  0 );
	}
	 
	/** 
	  * 判断字符串是否未空, 如果为 null 或者长度为0, 均返回 true.
	   */ 
	  public static  boolean  isNotEmptyStringObject(Object input) {
		  return  !isEmptyStringObject(input);
	 }

	/**
	 * 判断SET是否为空, 如果为 null 或者isEmpty, 均返回 true.
	  */ 
	 public static  boolean  isEmptySet(Set input) {
		 return  (input ==  null || input.isEmpty()  == true );
	}

	/**
	 * 判断SET是否为空, 如果为 null 或者isEmpty()  == false, 均返回 false.
	  */
	 public static  boolean  isNotEmptySet(Set input) {
		 return !isEmptySet(input);
	}

		/**
	   * 将字符串转换为整型数字
	   * @param str
	   * @return
	   */
	  public static int parseInt(String str){
		  if(isNotEmpty(str)){
			  return Integer.parseInt(str);
		  }else{
			  return 0;
		  }
	  }
	 
	/** 
	 * 获得输入字符串的字节长度(即二进制字节数), 用于发送短信时判断是否超出长度.
	 *
	 *  @param  input
	 *			输入字符串
	 *  @return  字符串的字节长度(不是 Unicode 长度)
	  */ 
	 public static  int  getBytesLength(String input) {
		 if(input ==  null ) {
			 return   0 ;
		}
		 int  bytesLength  =  input.getBytes().length;
		 return  bytesLength;
	}
	
	public static String replaceChar(String s,  char  c,  char  c1) {
		 if(s ==  null ) {
			 return   "" ;
		}
		 return  s.replace(c, c1);
	}

	public static String replaceString(String s, String s1, String s2) {
		 if(s ==  null || s1 ==  null || s2 ==  null ) {
			 return   "" ;
		}
		 return  s.replaceAll(s1, s2);
	}
	
	/**
	 * 去掉右侧空格。 <br>
	 * 
	 * @author sunchj
	 */
	public static String trimRight(String a) {
		if ("".equals(a)) {
			return a;
		}
		int len = 0;
		for (int i = a.length() - 1; i >= 0; i--) {
			if (a.charAt(i) == ' ' || a.charAt(i) == '　') {
				len++;
			} else {
				break;
			}

		}// end for

		return a.substring(0, a.length() - len);
	}
	/**
	 * 去掉左侧空格。 <br>
	 * 
	 * @author sunchj
	 */
	public static String trimLeft(String a) {
		if ("".equals(a)) {
			return a;
		}
		int len = 0;
		int tl = a.length();
		for (int i = 0; i < tl; i++) {
			if (a.charAt(i) == ' ' || a.charAt(i) == '　') {
				len++;
			} else {
				break;
			}

		}// end for

		return a.substring(len, a.length());
	}	
	public static String trim(String a){
		if(a == null || "".equals(a)){
			return "";
		}
		
		return trimRight(trimLeft(a));
	}
	/**
	 * 将Map转化为字符串数组。 <br>
	 * 
	 * @author sunchj
	 */
	public static String[] MapToStringArray(Map map) {
		String array[] = null;
		if (map != null && !map.isEmpty()) {
			Object[] o = map.keySet().toArray();
			array = new String[o.length];
			for (int i = 0; i < o.length; i++) {
				array[i] = String.valueOf(o[i]);
			}
			return array;
		}
		return new String[0];
	}

	/**
	 * 将List的元素转化为字符串元素。
	 * @param list
	 * @param wrapChar
	 *            包裹元素的符号，有则前后包裹，无则不包裹。
	 * @param compart
	 *            元素与元素之间的连接符号，默认为逗号[,]。
	 * @author sunchj
	 * @return String
	 */
	public static String listToString(List list, String wrapChar, String compart) {
		if (list == null || list.size() == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		if (wrapChar != null) {
			sb.append(wrapChar).append(String.valueOf(list.get(0))).append(wrapChar);
		} else {
			sb.append(String.valueOf(list.get(0)));
		}
		for (int i = 1; i < list.size(); i++) {
			if (compart != null) {
				sb.append(compart);
			} else {
				sb.append(",");
			}
			
			if (wrapChar != null) {
				sb.append(wrapChar).append(String.valueOf(list.get(i))).append(wrapChar);
			} else {
				sb.append(String.valueOf(list.get(i)));
			}
		}
		return sb.toString();
	}
	/**
	 * 将集合元素转化为字符串元素。
	 * @param colect
	 * @param wrapChar
	 *            包裹元素的符号，有则前后包裹，无则不包裹。
	 * @param compart
	 *            元素与元素之间的连接符号，默认为逗号[,]。
	 * @author sunchj
	 * @return String
	 */
	public static String CollectionToSpString(Collection colect, String wrapChar, String compart) {
		if (colect == null || colect.size() == 0){
			return "";
		}

		Iterator colt = colect.iterator();
		List lit = new ArrayList();
		while (colt.hasNext()) {
			lit.add(colt.next());
		}
		return listToString(lit, wrapChar, compart);
	}

	/**
	 * 将数组转化为字符串。 <br>
	 * 
	 * @author sunchj
	 */
	public static String arrayToString(String[] argStr, String wrapChar, String compart) {
		return listToString(Arrays.asList(argStr), wrapChar, compart);
	}

	/**
	 * 将带有分隔符的字符串转化为另一中带有分隔符的字符串。 <br>
	 * 
	 * @author sunchj
	 */
	public static String muliStringToString(String argStr, String wrapChar, String compart) {
		StringTokenizer st = new StringTokenizer(argStr, compart);
		String[] s = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			s[i] = st.nextToken();
			i++;
		}
		return listToString(Arrays.asList(s), wrapChar, compart);
	}

	/**
	 * 去掉 null 或 “null”
	 * @param o
	 * @author sunchj
	 * @return String
	 */
	public static String trimNull(Object o) {
		if (o == null || "null".equals(String.valueOf(o))) {
			return "";
		}
		if (o instanceof String) {
			return String.valueOf(o);
		}
		return String.valueOf(o);
	}
	/**
	 * 将字符串转化为字节数组
	 * @param str
	 * @author sunchj
	 * @return byte[]
	 */
	public static byte[] StringToByte(String str) {
		int len = str.length();
		byte[] bytes = new byte[len];

		for (int i = 0; i < len; i++) {
			bytes[i] = (byte) (str.charAt(i));
		}
		return bytes;
	}
	
	/**
	 * 将对象转化为字符串
	 * @param o
	 * @author sunchj
	 * @return String
	 */
	public static String objToString(Object o) {
		if(o != null && o != "null"){
			return o.toString();
		}
		
		return "";
	}

	/**
	 *
	 * @Title: isConSpeCharacters
	 * @Author sunchj
	 * @Date 2018/3/26 19:41
	 * @Description: 是否含有特殊符号，￥，#，$，日文平假名，™
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isContainSpecialChar(String str){
		if(isEmpty(str)){
			return false;
		}

		str = str.replaceAll(" ", "");
		// \uffe5:￥
		// \u0023:#
		// \u0024:$
		// \u3041-\u309F:日文平假名
		// \u2122:™
		//特殊字符查询网站：http://tool.chinaz.com/tools/unicode.aspx
		if(str.replaceAll("[\u4e00-\u9fa5a-zA-Z0-9\uffe5]*","").length() == 0){
			//不包含特殊字符
			return false;
		}
		return true;
	}
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
}
