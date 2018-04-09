package altong.mon.amtalk.login

import altong.mon.amtalk.BR
import altong.mon.amtalk.BaseActivity
import altong.mon.amtalk.R
import altong.mon.amtalk.databinding.ActivityMembershipBinding
import altong.mon.amtalk.viewmodel.MembershipViewModel
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle

class MembershipActivity : BaseActivity() {

    lateinit var binding: ActivityMembershipBinding

    companion object {
        const val MEMBERSHIP = R.layout.activity_membership
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, MEMBERSHIP)
        val genderTxtView = listOf(binding.maleTv, binding.femaleTv)
        val editTexts = listOf(binding.emailEditTxt, binding.passwordEditTxt, binding.birthEditTxt, binding.nicknameEditTxt, binding.phoneEditTxt)
        val membershipViewModel = MembershipViewModel(this, this, genderTxtView, editTexts)
        binding.setVariable(BR.membershipViewModel, membershipViewModel)
        binding.executePendingBindings()

    }

    override fun onBackPressed() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}