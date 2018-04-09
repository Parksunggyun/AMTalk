package altong.mon.amtalk.viewmodel

import altong.mon.amtalk.BaseActivity
import altong.mon.amtalk.R
import altong.mon.amtalk.login.BCrypt
import altong.mon.amtalk.login.LoginActivity
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.util.regex.Pattern

class MembershipViewModel(activity: BaseActivity, context: Context, txtViews: List<TextView>, editTexts : List<EditText>) : ViewModel {

    var activity : BaseActivity
    var context : Context
    var txtViews : List<TextView>
    var editTexts : List<EditText>

    init {
        this.activity = activity
        this.context = context
        this.txtViews = txtViews
        this.editTexts = editTexts
    }

    lateinit var gender : String

    override fun onCreate() {
    }

    override fun onResume() {
    }

    override fun onStart() {
    }

    override fun onPause() {
    }

    fun listener(view: View) {
        when(view.id) {
            R.id.maleTv -> {
                txtViews[0].setBackgroundResource(R.drawable.colored_border)
                txtViews[1].setBackgroundResource(R.drawable.border)
                gender = txtViews[0].text.toString()
            }
            R.id.femaleTv -> {
                txtViews[1].setBackgroundResource(R.drawable.colored_border)
                txtViews[0].setBackgroundResource(R.drawable.border)
                gender = txtViews[1].text.toString()
            }
            R.id.requestMembershipBtn -> {

                val email = editTexts[0].text.toString()
                val password = editTexts[1].text.toString()
                val birth = editTexts[2].text.toString()
                val nickname = editTexts[3].text.toString()
                val phone = editTexts[4].text.toString()
                if(!isEmail(email) || email == "") {
                    Toast.makeText(context, "이메일을 형식에 맞게 정확히 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else if(TextUtils.isEmpty(password)) {
                    Toast.makeText(context, "비밀번호를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else if (TextUtils.isEmpty(birth)) {
                    Toast.makeText(context, "생년월일을 정확히 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else if (TextUtils.isEmpty(nickname)) {
                    Toast.makeText(context, "별명을 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(context, "휴대폰 번호를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else {
                    val request = object : StringRequest(Request.Method.POST, "http://10.20.2.119:1992/talk/users/membership", Response.Listener {
                        Log.d("response", it)
                        when(it) {
                            "ok" -> {
                                Toast.makeText(context, "가입을 축하드립니다.", Toast.LENGTH_SHORT).show()
                                activity.startActivity(Intent(context, LoginActivity::class.java))
                                activity.finish()
                            }
                            "existEmail" -> Toast.makeText(context, "이미 가입된 이메일입니다.", Toast.LENGTH_SHORT).show()
                            "existNickname" -> Toast.makeText(context, "이미 사용된 별명입니다.", Toast.LENGTH_SHORT).show()
                            "existPhone" -> Toast.makeText(context, "이미 가입된 휴대폰 번호입니다.", Toast.LENGTH_SHORT).show()
                            else -> {
                                Toast.makeText(context, "잠시 후 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }, Response.ErrorListener {

                    }) {
                        override fun getParams(): Map<String, String> {
                            val params = HashMap<String, String>()
                            params["email"] = email
                            params["password"] = BCrypt.hashpw(password, BCrypt.gensalt())
                            params["birth"] = birth
                            params["nickname"] = nickname
                            params["phone"] = phone
                            params["gender"] = gender
                            return params
                        }

                    }

                    val queue = Volley.newRequestQueue(context)
                    queue.add(request)
                }
            }
            R.id.goLoginIv -> {
                activity.onBackPressed()
            }


        }
    }

    private fun isEmail(email: String?): Boolean {
        val isEmail: Boolean?
        if (email == null) return false
        isEmail = Pattern.matches(
                "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+",
                email.trim { it <= ' ' })
        return isEmail
    }

}