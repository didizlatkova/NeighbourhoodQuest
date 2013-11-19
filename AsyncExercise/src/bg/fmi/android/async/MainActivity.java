package bg.fmi.android.async;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static class DownloadTask extends AsyncTask<String, Void, String> {

		private String download(final String url) throws Exception {
			final DefaultHttpClient client = new DefaultHttpClient();
			final HttpGet httpGet = new HttpGet(url);
			final StringBuilder response = new StringBuilder();

			final HttpResponse execute = client.execute(httpGet);
			final InputStream content = execute.getEntity().getContent();

			final BufferedReader buffer = new BufferedReader(new InputStreamReader(
					content));
			String s = "";
			while ((s = buffer.readLine()) != null) {
				response.append(s);
			}

			return response.toString();
		}
		
		@Override
		protected String doInBackground(String... urls) {

			String res = null;
			
			try {
				res =  download(urls[0]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return res;
		}
		
		@Override
		protected void onPostExecute(String result){
			contentText.setText(result);
		}

	}

	private EditText urlText;
	private static TextView contentText;

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.urlText = (EditText) findViewById(R.id.url_text);
		this.contentText = (TextView) findViewById(R.id.content_text);
	}

	// this method is bound to a button click in the xml.
	// this is more often than not a bad idea.
	public void downloadClicked(final View unused) {
		final String url = urlText.getText().toString();
		
		DownloadTask task = new DownloadTask();
		task.execute(url);

//		String response = null;
//		try {
//			response = download(url);
//		} catch (final Exception e) {
//			Log.e("ERROR", "error"); // lame error handling
//			response = "There was an error";
//		} finally {
//			contentText.setText(response);
//		}
	}

	
}
