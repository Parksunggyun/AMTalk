package altong.mon.amtalk.login

import altong.mon.amtalk.BR
import altong.mon.amtalk.BaseActivity
import altong.mon.amtalk.R
import altong.mon.amtalk.databinding.ActivityLoginBinding
import altong.mon.amtalk.viewmodel.LoginViewModel
import android.databinding.DataBindingUtil
import android.os.Bundle

/*
 * Created by 15U560 on 2018-04-03.
 */

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    companion object {
        const val LOGIN = R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, LOGIN)
        val loginViewModel = LoginViewModel(this, this, binding.emailEt, binding.passwordEt)
        binding.setVariable(BR.loginViewModel, loginViewModel)
        binding.executePendingBindings()
    }

}