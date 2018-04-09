package altong.mon.amtalk.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import altong.mon.amtalk.BaseActivity;
import altong.mon.amtalk.MainActivity;
import altong.mon.amtalk.R;
import altong.mon.amtalk.login.MembershipActivity;

public class LoginViewModel implements ViewModel {

    private BaseActivity activity;
    private Context context;
    private EditText[] editTexts;

    public LoginViewModel(BaseActivity activity, Context context, EditText... editTexts) {
        this.activity = activity;
        this.context = context;
        this.editTexts = editTexts;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    public void listener(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:
                final String email = editTexts[0].getText().toString();
                final String password = editTexts[1].getText().toString();
                JSONObject jRequest = new JSONObject();
                try {
                    jRequest.put("email", email);
                    jRequest.put("password", password);
                    final RequestQueue requestQueue = Volley.newRequestQueue(context);
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://10.20.2.119:1992/talk/users/login", jRequest,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        switch (response.getString("email")) {
                                            case "email or password incorrect.":
                                                Toast.makeText(context, "이메일 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                                                break;
                                            default:
                                                try {
                                                    String email = response.getString("email");
                                                    String nickname = response.getString("nickname");
                                                    String birth = response.getString("birth");
                                                    String phone = response.getString("phone");
                                                    String gender = response.getString("gender");
                                                    String profile_url = response.getString("profile_url");
                                                    String join_date = String.valueOf(response.get("join_date"));
                                                    SharedPreferences.Editor editor = activity.userData.edit();
                                                    editor.putString("email", email);
                                                    editor.putString("nickname", nickname);
                                                    editor.putString("birth", birth);
                                                    editor.putString("phone", phone);
                                                    editor.putString("gender", gender);
                                                    editor.putString("profile_url", profile_url);
                                                    editor.putString("join_date", join_date);
                                                    editor.apply();
                                                    activity.startActivity(new Intent(context, MainActivity.class));
                                                    activity.finish();
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });

                    requestQueue.add(request);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.membershipBtn:
                activity.startActivity(new Intent(activity, MembershipActivity.class));
                activity.finish();
                break;
            case R.id.searchPasswordTv:
                Toast.makeText(context, "비밀번호 찾기", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
