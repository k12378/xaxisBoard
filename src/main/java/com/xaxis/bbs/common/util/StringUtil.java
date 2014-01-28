package com.xaxis.bbs.common.util;

public class StringUtil {
	
	/**
	 * numberToDivisionCommaStr
	 * ���ڿ� �ĸ��� ���� ���ڿ� ��ȯ.
	 * example ) 1000000 => 1,000,000
	 * @param number
	 * @return
	 */
	public String numberToDivisionCommaStr(int number)
	{
		String numberStr = Integer.valueOf(number).toString();
		
		String[] numberStrArray = this.stringToStringArray(numberStr);
		
		String commaNumber = "";
		
		int loopIndex = 0;
		for( int i=(numberStrArray.length-1); i >= 0; i--){
			
			if( loopIndex % 3 == 0 && loopIndex != 0){
				commaNumber = "," + commaNumber;
			}
			
			commaNumber = numberStrArray[i] + commaNumber;
			loopIndex++;
		}
		
		return commaNumber;
	}
	
	/**
	 * stringToStirngArray
	 * ���ڿ��� �迭 ���·� ��ȯ.
	 * @param str
	 * @return
	 */
	public String[] stringToStringArray(String str){		
		String[] stringArr = new String[str.length()];				
		for( int i= 0; i < str.length(); i++ ){			
			stringArr[i] = String.valueOf(str.charAt(i));
		}
		return stringArr;
	}
	
	
	
	/*
	 * Validation
	 */
	
	/**
	 * isNumeric
	 * ���� ���� Ȯ��
	 * @param value
	 * @return
	 */
	public boolean isNumeric(String value){
		String pattern = "^[0-9]+$";
		return value.trim().matches(pattern);
	}
	
	/**
	 * isAlphabet
	 * ���ĺ� ���� Ȯ��
	 * @param value
	 * @return
	 */
	public boolean isAlphabet(String value){
		String pattern = "^[0-9a-zA-Z]+$";
		return value.trim().matches(pattern);
	}
	
	/**
	 * isAlphanumeric
	 * ���ĺ� + ���� ���� Ȯ��
	 * @param value
	 * @return
	 */
	public boolean isAlphanumeric(String value){
		String pattern = "^[0-9a-zA-Z]+$";
		return value.trim().matches(pattern);
	}
	
	/**
	 * isEmail
	 * Email ���� ���� Ȯ��
	 * @param value
	 * @return
	 */
	public boolean isEmail(String value){
		String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		return value.trim().matches(pattern);
	}	
}