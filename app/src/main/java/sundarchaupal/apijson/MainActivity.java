
package sundarchaupal.apijson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url="http://searchkero.com/mymob/fetch.php";
        StringRequest stringRequest=new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Json parsing in url fetch
                try {
                    JSONObject jo=new JSONObject(response);
                    JSONArray ja=jo.getJSONArray("data");
                    JSONObject job=ja.getJSONObject(2);
                    String data=job.getString("email");
                    JSONObject job1=ja.getJSONObject(3);
                    String date=job1.getString("datetime");
                    Toast.makeText(MainActivity.this,data+ "\n"+date,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Json parsing in url fetch
                try {
                    JSONObject jo=new JSONObject("http://searchkero.com/Ablog/insert.php");
                    JSONArray ja=jo.getJSONArray("data");
                    JSONObject job=ja.getJSONObject(0);
                    String data=job.getString("datetime");
                    Toast.makeText(MainActivity.this,data,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

