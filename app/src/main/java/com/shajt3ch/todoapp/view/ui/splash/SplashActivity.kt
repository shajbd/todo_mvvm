package com.shajt3ch.todoapp.view.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.shajt3ch.todoapp.R
import com.shajt3ch.todoapp.util.GeneralHelper
import com.shajt3ch.todoapp.util.NetworkHelper
import com.shajt3ch.todoapp.view.ui.auth.LoginActivity
import kotlinx.coroutines.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //hiding status bar
        GeneralHelper.hideStatusBar(this)

        //splash delay
        CoroutineScope(Dispatchers.IO).launch {
            checkNetwork()
        }
    }

    //checking for internet connection
    suspend fun checkNetwork() {

        delay(2000L)

        val status = NetworkHelper.isNetworkConnected(this)

        if (status) {
            finish()
            startActivity(intentFor<LoginActivity>())

        } else {

            withContext(Dispatchers.Main) {

                alert {
                    isCancelable = false
                    title = getString(R.string.error_no_internet)
                    message = getString(R.string.error_no_internet_msg)
                    positiveButton("OK") {
                        it.dismiss()
                        val intent = Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS)
                        startActivity(intent)
                    }
                }.show()
            }
        }
    }

    suspend fun checkNetworkFast() {

        //delay(2000L)

        val status = NetworkHelper.isNetworkConnected(this)

        if (status) {
            finish()
            startActivity(intentFor<LoginActivity>())

        } else {

            withContext(Dispatchers.Main) {



                showNetworkDialogue()
            }
        }
    }

    private fun showNetworkDialogue() {
        alert {
            isCancelable = false
            title = getString(R.string.error_no_internet)
            message = getString(R.string.error_no_internet_msg)
            positiveButton("OK") {
                it.dismiss()
                val intent = Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS)
                startActivity(intent)
            }
        }.show()
    }

    override fun onRestart() {
        super.onRestart()
        CoroutineScope(Dispatchers.IO).launch {
            checkNetworkFast()
        }
    }

}
