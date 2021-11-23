package com.dci.configutil;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Utils.
 *
 * 
 */
public class Utils {
	public static String databaseNameFromJdbcUrl(String url) {
		try {
			URI uri = new URI(url.replace("jdbc:", ""));
			return uri.getPath().substring(1);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
