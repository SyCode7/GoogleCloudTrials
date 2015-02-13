package de.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivateKey;

public class GCSSignedURLExample {
	
	final String SERVICE_ACCOUNT_EMAIL = "139888340867-32r1p9d4hm7gnpfud35uqplbr9gkbvsj@developer.gserviceaccount.com";
	final String SERVICE_ACCOUNT_PKCS12_FILE_PATH = "C:\\Users\\Kennedy.Torkura\\googleIDTestStorage-6c02d3ae0d7c";
	final long expiration = System.currentTimeMillis()/1000 + 60;
	
	final String BUCKET_NAME = "starting";
	String OBJECT_NAME = "BPJ_TestBook_3_0_5.pdf";
	
	
	PrivateKey key ;
	
	public static void main(String[] args) {
		GCSSignedURLExample tc = new GCSSignedURLExample();
		
	}
	
	public GCSSignedURLExample (){
		try {
			key = loadKeyFromPkcs12(SERVICE_ACCOUNT_PKCS12_FILE_PATH, "notasecret".toCharArray());
			
			System.out.println("========== PUT File =========");
			String put_url = this.getSigningURL("PUT");
			
			URL url = new URL(put_url);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
			out.write("We are trying");
			out.close();
			
			System.out.println("PUT Request URL" + put_url);
			System.out.println("PUT Response code :" + httpCon.getResponseCode());
			renderResponse(httpCon.getInputStream());
			
			System.out.println("========== GET File =========");
			String get_url = this.getSigningURL("GET");
			url =new URL(get_url);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("GET");
			
			System.out.println("GET Request URL " + get_url);
			System.out.println("GET Response code :" + httpCon.getResponseCode());
			renderResponse(httpCon.getInputStream());
			
			System.out.println("========== DELETE File =========");
			String delete_url = this.getSigningURL("DELETE");
			url =new URL(delete_url);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("DELETE");
			
			System.out.println("DELETE Request URL " + get_url);
			System.out.println("DELETE Response code :" + httpCon.getResponseCode());
			renderResponse(httpCon.getInputStream());
			
			
		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}
	}

	private void renderResponse(InputStream inputStream) {
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
				
				@Override
				public int read() throws IOException {
					// TODO Auto-generated method stub
					return 0;
				}
			})
			
	}

	private String getSigningURL(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private PrivateKey loadKeyFromPkcs12(
			String sERVICE_ACCOUNT_PKCS12_FILE_PATH2, char[] cs) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
