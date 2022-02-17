package com.rendra.imakan.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.rendra.imakan.R
import com.rendra.imakan.home.HomePageActivity
import com.rendra.imakan.model.User
import kotlinx.android.synthetic.main.activity_sign_in.*

import com.rendra.imakan.signup.SignUpActivity
import com.rendra.imakan.utils.Preferences


class SignInActivity : AppCompatActivity() {

    lateinit var iUsername:String
    lateinit var iPassword:String

    lateinit var mDatabase: DatabaseReference
    lateinit var preference: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("user")
        preference = Preferences(this)

        preference.setValue("onboarding", "1")
        if (preference.getValue("status").equals("1")) {
            finishAffinity()
            startActivity(Intent(this@SignInActivity, HomePageActivity::class.java))
        }

        btn_login.setOnClickListener {
            iUsername = et_username.text.toString()
            iPassword = et_password.text.toString()

            if (iUsername.equals("")) {
                et_username.error = "Silahkan tulis username anda"
                et_username.requestFocus()
            } else if (iPassword.equals("")) {
                et_password.error = "Silahkan tulis password anda"
                et_password.requestFocus()
            } else {
                pushLogin(iUsername, iPassword)
            }

            finishAffinity()
            startActivity(Intent(this, HomePageActivity::class.java))
        }

        btn_register.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)

                if (user == null) {
                    Toast.makeText(this@SignInActivity, "Username tidak ditemukan", Toast.LENGTH_LONG).show()
                } else {
                    if (user.password.equals(iPassword)) {
                        preference.setValue("nama", user.username.toString())
                        preference.setValue("email", user.email.toString())
                        preference.setValue("password", user.password.toString())
                        preference.setValue("phoneNumber", user.phoneNumber.toString())
                        preference.setValue("url", user.url.toString())
                        preference.setValue("status", "1")

                        startActivity(Intent(this@SignInActivity, HomePageActivity::class.java))
                    } else {
                        Toast.makeText(this@SignInActivity, "Password anda salah", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignInActivity, error.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}