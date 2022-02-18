package com.rendra.imakan.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.rendra.imakan.R
import com.rendra.imakan.home.HomePageActivity
import com.rendra.imakan.model.User
import com.rendra.imakan.utils.Preferences
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var sUsername:String
    lateinit var sEmail:String
    lateinit var sPhoneNumber:String
    lateinit var sPassword:String
    lateinit var sConfirmPassword:String

    lateinit var mDatabase: DatabaseReference
    lateinit var preference: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mDatabase = FirebaseDatabase.getInstance("https://imakan-493ae-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("user")
        preference = Preferences(this)

        btn_login2.setOnClickListener {
            sUsername = et_username.text.toString()
            sEmail = et_email.text.toString()
            sPhoneNumber = et_phoneNumber.text.toString()
            sPassword = et_phoneNumber.text.toString()
            sConfirmPassword = et_confirm_password.text.toString()

            if (sUsername.equals("")) {
                et_username.error = "Silahkan isi username Anda"
                et_username.requestFocus()
            } else if (sPhoneNumber.equals("")) {
                et_phoneNumber.error = "Silahkan isi nomor handphone Anda"
                et_phoneNumber.requestFocus()
            } else if (sEmail.equals("")) {
                et_email.error = "Silahkan isi nomor handphone Anda"
                et_email.requestFocus()
            } else if (sPassword.equals("")) {
                et_password.error = "Silahkan isi nomor handphone Anda"
                et_password.requestFocus()
            } else if (sConfirmPassword.equals(sPassword)) {
                et_confirm_password.error = "Password yang anda masukkan berbeda"
                et_confirm_password.requestFocus()
            } else {
                var statusUsername = sUsername.indexOf(".")
                if (statusUsername >= 0) {
                    et_username.error = "Silahkan tulis username Anda tanpa '.'"
                    et_username.requestFocus()
                } else {
                    saveUsername(sUsername, sPhoneNumber, sEmail, sPassword)
                }
            }
        }
    }

    private fun saveUsername(
        sUsername: String,
        sPhoneNumber: String,
        sEmail: String,
        sPassword: String
    ) {
        var user = User()
        user.username = sUsername
        user.phoneNumber = sPhoneNumber
        user.email = sEmail
        user.password = sPassword

        if (sUsername != null) {
            checkingUsername(sUsername, user)
        }
    }

    private fun checkingUsername(sUsername: String, data: User) {
        mDatabase.child(sUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                if (user == null) {
                    mDatabase.child(sUsername).setValue(data)

                    preference.setValue("username", data.username.toString())
                    preference.setValue("phoneNumber", data.phoneNumber.toString())
                    preference.setValue("email", data.email.toString())
                    preference.setValue("url", "")
                    preference.setValue("status", "1")

                    startActivity(Intent(this@SignUpActivity, HomePageActivity::class.java).putExtra("data", data))
                } else {
                    Toast.makeText(this@SignUpActivity, "User telah digunakan", Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignUpActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}