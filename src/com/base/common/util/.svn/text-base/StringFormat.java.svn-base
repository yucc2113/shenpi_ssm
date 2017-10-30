package com.base.common.util;

public class StringFormat {

	public static String toGBK( String value ) {
		String strRet = null ;
		if ( value == null ) {
			return strRet;
		}
		try {
			strRet = new String(value.getBytes("iso-8859-1"),"GBK") ;
		} catch( Exception exc ) {
			strRet = "" ;
		}
		
		return strRet;
	}
	
	public static String toGBKS( String value ) {
		String strRet = null ;
		if ( value == null ) {
			return strRet;
		}
		
		try {
			strRet = new String(value.getBytes("ISO8859_1"),"GBK") ;
		} catch( Exception exc ) {
			strRet = "" ;
		}
		
		return strRet;
	}
	
	public static String to8859s( String value ) {
		String strRet = null ;
		if ( value == null ) {
			return strRet;
		}
		
		try {
			strRet = new String(value.getBytes("GBK"),"ISO8859_1") ;
		} catch( Exception exc ) {
			strRet = "" ;
		}
		
		return strRet;
	}	
	
	public static String to8859( String value ) {
		String strRet = null ;
		if ( value == null ) {
			return strRet;
		}
		
		try {
			strRet = new String(value.getBytes("GBK"),"iso-8859-1") ;
		} catch( Exception exc ) {
			strRet = "" ;
		}
		
		return strRet;
	}	
	
	public static String cutString( String value, int max ) {
		if ( value == null ) {
			return value ;
		}
		
		if ( value.length() > max ) {
			return value.substring( 0, max ) ;
		}
		
		return value ;
	}
	
    public static String stringEncode(String value, String enc) {
        try {
            if (value == null || value.length() <= 0) {
                return value;
            }
            return java.net.URLEncoder.encode(value, enc);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
    
    public static String stringDecode(String value, String enc) {
        try {
            if (value == null || value.length() <= 0) {
                return value;
            }
            return java.net.URLDecoder.decode(value, enc);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
    
    public static String toEUCKR( String value ) {
		String strRet = null ;
		if ( value == null ) {
			return strRet;
		}
		
		try {
			strRet = new String(value.getBytes("utf-8"),"euc-kr") ;
		} catch( Exception exc ) {
			strRet = "" ;
		}
		
		return strRet;
	}	

}
