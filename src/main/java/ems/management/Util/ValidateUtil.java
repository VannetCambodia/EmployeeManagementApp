package ems.management.Util;

import java.util.HashMap;
import java.util.Map;

import ems.management.Util.exception.ValidateFieldException;

public class ValidateUtil {

	public static void validateField(HashMap<String, Object> requestField) throws ValidateFieldException {
		
		for (Map.Entry<String, Object> field : requestField.entrySet()) {
			if(field.getKey() instanceof String 
					&& ( ((HashMap<String, Object>) field.getValue()).isEmpty() || field.getValue() == null)) {
				throw new ValidateFieldException(field.getKey() + "cannot be null");
			}
		}
	}
}
